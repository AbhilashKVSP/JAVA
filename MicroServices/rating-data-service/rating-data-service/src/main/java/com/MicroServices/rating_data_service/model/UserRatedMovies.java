package com.MicroServices.rating_data_service.model;

import java.util.List;

public class UserRatedMovies {
	
	private List<Rating> userRatedMovies;

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
