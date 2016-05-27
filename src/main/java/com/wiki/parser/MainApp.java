package com.wiki.parser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.showcase.mongo.domain.Movie;
import com.showcase.mongo.domain.MovieList;

public class MainApp {
	
	private static final Logger LOGGER = Logger.getLogger(MainApp.class);

	private ThreadPoolExecutor threadPool;
	private BlockingQueue<Runnable> workQueue;
	
	public static final int CORE_POOL_SIZE = 4;
	public static final int MAX_POOL_SIZE = 100;
	public static final int KEEP_ALIVE_TIME = 180;
	public static final float PERCENTAGE_FACTOR = 0.5f;
	
	public static RestTemplate REST_TEMPLATE;
	
	public MainApp() {
		workQueue = new LinkedBlockingQueue<Runnable>();
		threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, workQueue);
	}
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("ws-client-context.xml");
		if (appContext != null) {
			LOGGER.info ("initialized !!");
			REST_TEMPLATE = (RestTemplate) appContext.getBean("restTemplate1");
		}
		
		MainApp app = new MainApp();
		app.start();

		
		/*String link = "https://en.wikipedia.org/wiki/Philadelphia_(film)";
		WikiMovieInfoTask task = new WikiMovieInfoTask(link, 2016);
		task.call();*/		
	}
	
	
	
	public void start() {
		Set<Future<MovieList>> set = new HashSet<Future<MovieList>>();
		
		for (int year = 1967; year <= 1967; year++) {
			LOGGER.info ("Year " + year + " process yet to begin...");
			Callable<MovieList> movieTask = new WikiMovieExtractorTask("Thread " + year, year);
			Future<MovieList> future = threadPool.submit(movieTask);
			set.add(future);
		}
		
		try {
			waitAllSiteProcessThreadsToFinish(threadPool, workQueue);
			
			/*List<Movie> data = new ArrayList<>();
			for (Future<MovieList> future : set) {
				MovieList movieList = future.get();
				
				LOGGER.info("Movies Size = " + movieList.getMovieList().size());
				
				data.addAll(movieList.getMovieList());
			}
			
			printMovies (data);*/
		} catch (Exception ex) {
			LOGGER.error(ex);
		}
	}
	
	private void printMovies(List<Movie> data) {
		for (Movie movie : data) {
			LOGGER.info(movie.toString());
		}
		
		LOGGER.info("Movies Size = " + data.size());
	}
	
	public static void waitAllSiteProcessThreadsToFinish(ThreadPoolExecutor executor, BlockingQueue<Runnable> queue) throws InterruptedException {
		executor.shutdown();

		try {
			while (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
				LOGGER.info("Awaiting completion of threads.");
	
				LOGGER.info("pendingTask: " + getPendingTaksCount(executor) + " Free : " + getFreePoolSizeCount(executor)
						+ " Actual Maximum Pool size: " + executor.getMaximumPoolSize() + " Core Pool size: "
						+ executor.getCorePoolSize() + " Active: " + executor.getActiveCount() + " Completed: "
						+ executor.getCompletedTaskCount() + " Task count : " + executor.getTaskCount());
			}
		} finally {
			doRelease(executor, queue);
		}
	}
	
	public static long getPendingTaksCount(ThreadPoolExecutor executor) {
		return executor.getTaskCount() - executor.getCompletedTaskCount();
	}

	public static long getFreePoolSizeCount(ThreadPoolExecutor executor) {
		long pendingTask = getPendingTaksCount(executor);
		long freeCount = executor.getMaximumPoolSize() - pendingTask;
		freeCount = (freeCount > 0) ? freeCount : 0;
		return freeCount;
	}
	
	public static void doRelease(ThreadPoolExecutor executor, BlockingQueue<Runnable> queue) {
		executor = null;
		queue = null;
	}

}
