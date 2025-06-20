package com.ToDoApp.springBoot.myFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String userName, String password) {
		
//		Logger logger = LoggerFactory.getLogger(getClass());
		
		boolean isValidName = userName.equalsIgnoreCase("Abhilash");
		boolean isValidPass = password.equalsIgnoreCase("bubbui");
		
		return isValidName&&isValidPass;
	}

}
