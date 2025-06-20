package com.MicroServices.movie_info_service.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MicroServices.movie_info_service.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		return new Movie(movieId, "MovieName");
	}
}
