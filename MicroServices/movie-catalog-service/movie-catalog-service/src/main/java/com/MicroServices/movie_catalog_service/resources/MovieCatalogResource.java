package com.MicroServices.movie_catalog_service.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.MicroServices.movie_catalog_service.models.CatalogItem;
import com.MicroServices.movie_catalog_service.models.Movie;
import com.MicroServices.movie_catalog_service.models.UserRatedMovies;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired 
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		UserRatedMovies ratings = restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingdata/users/"+userId, UserRatedMovies.class);

		return ratings.getUserRatedMovies().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getMovieId(), movie.getName(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
