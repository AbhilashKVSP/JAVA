package com.MicroServices.movie_catalog_service.models;

import java.util.List;

public class UserRatedMovies {
	
	private List<Rating> userRatedMovies;
	
	public UserRatedMovies() {
		super();
	}

	public UserRatedMovies(List<Rating> userRatedMovies) {
		super();
		this.userRatedMovies = userRatedMovies;
	}

	public List<Rating> getUserRatedMovies() {
		return userRatedMovies;
	}

	public void setUserRatedMovies(List<Rating> userRatedMovies) {
		this.userRatedMovies = userRatedMovies;
	}
	

}
