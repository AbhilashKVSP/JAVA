package com.MicroServices.rating_data_service.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MicroServices.rating_data_service.model.Rating;
import com.MicroServices.rating_data_service.model.UserRatedMovies;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRatedMovies getUserRatings(@PathVariable String userId) {
		UserRatedMovies userRatings = new UserRatedMovies(Arrays.asList(new Rating("1234", 4), new Rating("5678", 3)));
		return userRatings;
	}
	
}
