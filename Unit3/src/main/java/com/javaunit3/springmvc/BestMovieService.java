package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BestMovieService {

//Field Injection	
//	@Autowired
	private Movie movie;

//	Setter Injection
//	@Autowired
//	public void setMovie(Movie newMovie) {
//		movie = newMovie;
//	}

//	Constructor injection
//	@Autowired
//	public BestMovieService(@Qualifier("batmanMovie") Movie movie) {
//	    this.movie = movie;
//	}

	@Autowired
	public BestMovieService(@Qualifier("titanicMovie") Movie movie) {
		this.movie = movie;
	}

	public Movie getBestMovie() {
		return movie;
	}
}
