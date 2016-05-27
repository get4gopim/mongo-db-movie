package com.wiki.parser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;

import com.showcase.mongo.domain.Movie;

public class WikiMovieInfoTask implements Callable<Movie> {

	private static final Logger LOGGER = Logger.getLogger(WikiMovieInfoTask.class);
	
	//private static WikiParserTask PARSER = new WikiParserTask();
	
	private String movieLink;
	private int year;
	
	private List<Movie> moviesList;
	
	public List<Movie> getMoviesList() {
		if (moviesList == null) moviesList = new ArrayList<>();
		return moviesList;
	}

	public void setMoviesList(List<Movie> moviesList) {
		this.moviesList = moviesList;
	}

	public WikiMovieInfoTask(String movieLink, int year) {
		this.movieLink = movieLink;
		this.year = year;
		
		
	}
	
	public WikiMovieInfoTask() {
		
	}
	
	public void saveMovie(Movie movie) {
		try {
			MainApp.REST_TEMPLATE.postForEntity("http://springmobile.cfapps.io/service/movies/save", movie, ResponseEntity.class);
		} catch (Exception e) {
			LOGGER.error("saveMovie error: " + e);
		}
	}
	
	@Override
	public Movie call() {
		Movie movie = null;
		try {
			movie = getMovieDetails (this.movieLink);
			LOGGER.error("movie: " + movie);
			saveMovie (movie);
		} catch (Exception ex) {
			LOGGER.error("Error in parsing Movie Info: " + this.movieLink, ex);
		}
		return movie;
	}
	
	private Date getDate(String releaseDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(releaseDate);
	}
	
	private int getYear(Date releaseDate) throws Exception {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(releaseDate);
		return calendar.get(Calendar.YEAR);
	}

	public Movie getMovieDetails(String movieLink) throws Exception {
		Movie movie = new Movie();
		Document doc = Jsoup.connect(movieLink).timeout(5*1000).get();
		Element table = doc.select("div#mw-content-text table").get(0);
		
		int i = 0;
		for (Element row : table.select("tr")) {
			Elements th = row.select("th");			
			Elements td = row.select("td");
			
			if (i == 0) {
				LOGGER.debug("Title = " + th.text());
				LOGGER.debug("Year = " + this.year);
				movie.setReleaseYear(this.year);
				movie.setTitle(th.text());
			}			
			
			if (i == 1) {
				Elements img = td.select("img");
				LOGGER.debug("imgUrl = " + img.attr("abs:src"));
				movie.setImageUrl(img.attr("abs:src"));
			}
			
			if (th.text().length() > 0 && td.text().length() > 0) {
				
				String director = getContent("Directed by", th, td);
				if (director != null) {
					movie.setFlimDirector( director );
				}
				
				String music= getContent("Music by", th, td);
				if (music != null) {
					movie.setMusicDirector(music);
				}
				
				//getContent("Release dates", th, td);
				
				if (th.text().trim().equalsIgnoreCase("Release dates")) {
					Elements starringDiv = row.select("div ul li");
					String relDate = "";
					
					try {
						Element releaseDate = starringDiv.get(0);
						relDate = releaseDate.text();
						Date dt = null;
					
						relDate = relDate.substring( relDate.indexOf("(")+1, relDate.indexOf(")") );
						dt = getDate (relDate);
						movie.setReleaseDate(dt.getTime());
						movie.setReleaseYear(getYear(dt));
						//LOGGER.debug("releaseDate in msec = " + dt.getTime());
					} catch (Exception ex) {
						LOGGER.error("Release Date Parse Error", ex);
					}
					
					LOGGER.debug("releaseDate = " + relDate);
				}
				
				if (th.text().trim().equalsIgnoreCase("Starring")) {
					//LOGGER.debug("*** " + th.text() + " ****");					
					Elements starringDiv = row.select("div ul li");
					if (starringDiv.size() == 0) {
						starringDiv = row.select("a");
					}
					//LOGGER.debug("starringDiv = " + starringDiv);
					
					if (starringDiv.size() >= 2) {
						Element actor = starringDiv.get(0);
						Element actress = starringDiv.get(1);
						
						movie.setActorName(actor.text());
						movie.setActressName(actress.text());
						
						LOGGER.debug("Actor = " + actor.text());
						LOGGER.debug("Actress = " + actress.text());
					}
				} /*else {
					LOGGER.debug(th.text() + " :: " + td.text());
				}*/				
				
			}
			
			i++;
		}
		return movie;
	}

	private String getContent(String header, Elements th, Elements td) {
		String content = null;
		if (th.text().equalsIgnoreCase(header)) {
			LOGGER.debug(th.text() + " = " + td.text());
			content = td.text();
		}
		return content;
	}
	
	/*public List<Movie> waitAllSiteProcessThreadsToFinish(ThreadPoolExecutor executor, BlockingQueue<Runnable> queue) throws InterruptedException {
		executor.shutdown();

		try {
			while (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
				LOGGER.info("Awaiting completion of threads.");
	
				LOGGER.info("pendingTask: " + getPendingTaksCount(executor) + " Free : " + getFreePoolSizeCount(executor)
						+ " Actual Maximum Pool size: " + executor.getMaximumPoolSize() + " Core Pool size: "
						+ executor.getCorePoolSize() + " Active: " + executor.getActiveCount() + " Completed: "
						+ executor.getCompletedTaskCount() + " Task count : " + executor.getTaskCount());
			}
			
			LOGGER.info("Movie List count = " + getMoviesList().size());
		} finally {
			doRelease(executor, queue);
		}
		
		return getMoviesList();
	}
	
	public long getPendingTaksCount(ThreadPoolExecutor executor) {
		return executor.getTaskCount() - executor.getCompletedTaskCount();
	}

	public long getFreePoolSizeCount(ThreadPoolExecutor executor) {
		long pendingTask = getPendingTaksCount(executor);
		long freeCount = executor.getMaximumPoolSize() - pendingTask;
		freeCount = (freeCount > 0) ? freeCount : 0;
		return freeCount;
	}
	
	public static void doRelease(ThreadPoolExecutor executor, BlockingQueue<Runnable> queue) {
		executor = null;
		queue = null;
	}*/

}
