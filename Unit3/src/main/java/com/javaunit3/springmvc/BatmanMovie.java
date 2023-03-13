package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("batmanMovie")
public class BatmanMovie implements Movie {

	@Override
	public String getTitle() {

		return "Batman: The Dark Knight";
	}

	@Override
	public String getMaturityRating() {

		return "PG-13";
	}

	@Override
	public String getGenre() {

		return "Action";
	}

}
