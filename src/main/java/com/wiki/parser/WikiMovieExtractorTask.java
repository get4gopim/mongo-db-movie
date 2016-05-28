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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.showcase.mongo.domain.Movie;
import com.showcase.mongo.domain.MovieList;

public class WikiMovieExtractorTask implements Callable<MovieList> {

	private static final Logger LOGGER = Logger.getLogger(WikiMovieExtractorTask.class);
	
	private String name;
	private int year;
	
	private ThreadPoolExecutor threadPool;
	private BlockingQueue<Runnable> workQueue;
	
	public WikiMovieExtractorTask(String name, int year) {
		this.name = name;
		this.year = year;
		
		workQueue = new LinkedBlockingQueue<Runnable>();
		threadPool = new ThreadPoolExecutor(MainApp.CORE_POOL_SIZE, MainApp.MAX_POOL_SIZE, MainApp.KEEP_ALIVE_TIME, TimeUnit.SECONDS, workQueue);
	}
	
	public WikiMovieExtractorTask() {
		
	}
	
	@Override
	public MovieList call() {
		MovieList movieList = null;
		try {
			int tableId = 2;
			movieList = listMovieNames(tableId);
			while (movieList.getMovieList().isEmpty()) {
				tableId++;
				movieList = listMovieNames(tableId);
				
				if (tableId == 4) {
					break;
				}
			}
		} catch (Exception ex) {
			LOGGER.error("Error in parsing year: " + this.year, ex);
		}
		return movieList;
	}

	public MovieList listMovieNames(int tableId) throws Exception {
		Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/" + this.year + "_in_film").timeout(5*1000).get();
		Element table = doc.select("div#mw-content-text table").get(tableId);
		Elements rows = table.select("tr");
		
		Set<Future<Movie>> set = new HashSet<Future<Movie>>();
		MovieList movieList = new MovieList();
		
		LOGGER.debug("tableId = " + tableId + "; size = " + rows.size());
		
		/*if (rows.size() <= 2) {
			table = doc.select("div#mw-content-text table").get(3);
			rows = table.select("tr");
			LOGGER.debug("revised size = " + rows.size());
		}*/	
		
		//LOGGER.debug("rows = " + rows);
		
		for (Element row : rows) {
			Elements link = row.select("td i a");
			String movieLink = link.attr("abs:href");

			if (link.text().length() > 0) {
				LOGGER.debug(link.text() + " (" + movieLink + ") ");
				LOGGER.debug(" ---------------------------------------------------- ");
				
				LOGGER.info ("Movie [" + link.text() + "] extract process yet to begin...");
				Callable<Movie> movieTask = new WikiMovieInfoTask(movieLink, year);
				Future<Movie> future = threadPool.submit(movieTask);
				set.add(future);
				
				LOGGER.debug("\n");
			}
		}
		
		try {
			if (!workQueue.isEmpty()) {
				MainApp.waitAllSiteProcessThreadsToFinish(threadPool, workQueue);
			}
			
			List<Movie> data = new ArrayList<>();
			for (Future<Movie> future : set) {
				Movie movie = future.get();
				data.add(movie);
			}
			movieList.setData(data);
			
		} catch (Exception ex) {
			LOGGER.error(ex);
		}
		
		return movieList;
	}
	
}
