package com.LearnRest.first_restApp.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue
	private long Id;
	private String name;
	private String role;

	public UserDetails(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public UserDetails() {
		super();
	}

	public long getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "UserDetails [Id=" + Id + ", name=" + name + ", role=" + role + "]";
	}

}
