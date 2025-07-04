package com.ToDoApp.springBoot.myFirstWebApp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoLoginPage(ModelMap model) {
		model.put("name", getLoggedUserName());
		return "Welcome";
	}
	
	private String getLoggedUserName() {
		
		Authentication authentication 
			= SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
