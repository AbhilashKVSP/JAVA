package com.MicroServices.movie_catalog_service.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.MicroServices.movie_catalog_service.models.CatalogItem;
import com.MicroServices.movie_catalog_service.models.Movie;
import com.MicroServices.movie_catalog_service.models.Rating;

@RestController
@RequestMapping("/catalogWC")
public class MovieCatalogResourceWebClient {

	@Autowired
	private WebClient webClient;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("5678", 3));
		return ratings.stream().map(rating -> {
			Movie movie = webClient.get().uri("/movies/" + rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();
			return new CatalogItem(movie.getMovieId(), movie.getName(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
