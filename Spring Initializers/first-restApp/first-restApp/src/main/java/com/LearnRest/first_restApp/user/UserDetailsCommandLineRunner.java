package com.LearnRest.first_restApp.user;

import org.springframework.stereotype.Component;

//import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner{
	Logger logger = LoggerFactory.getLogger(getClass());

	private UserDetailsRepository repository;
	
	@Autowired
	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new UserDetails("tubbui","User"));
		repository.save(new UserDetails("Abbui","Admin"));
		repository.save(new UserDetails("bubbui","Admin"));
		
//		List<UserDetails> users = repository.findAll();
//		users.forEach(user -> logger.info(user.toString()));	
//		List<UserDetails> usersByRole = repository.findByRole("Admin");
//		usersByRole.forEach(user -> logger.info(user.toString()));	

	}

}
