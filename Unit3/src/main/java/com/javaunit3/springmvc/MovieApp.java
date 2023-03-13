package com.javaunit3.springmvc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class MovieApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieApp.class);

		BestMovieService bestMovieService = applicationContext.getBean("bestMovieService", BestMovieService.class);
		Movie bestMovie = bestMovieService.getBestMovie();

		System.out.println("The Title is : " + bestMovie.getTitle());
		System.out.println("The Maturity Rating is : " + bestMovie.getMaturityRating());
		System.out.println("The Genre is : " + bestMovie.getGenre());

		applicationContext.close();
	}

}