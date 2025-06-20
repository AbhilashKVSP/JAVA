package com.ToDoApp.springBoot.myFirstWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginControllerNoSecurity {
	
	private AuthenticationService authenticationService;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public LoginControllerNoSecurity(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	
	@RequestMapping("loginEx")
	public String gotoLoginPageEx(@RequestParam String name, ModelMap model) {
		model.put("name",name);
		logger.info("Requst Param is {}",name);
		return "login";
	}
	
	@RequestMapping(value="loginNoSecurity",method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="loginNoSecurity",method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name,@RequestParam String password, ModelMap model) {
			
		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);
			return "Welcome";
		}
		model.put("errorMsg", "Invalid Credentials Please try again!");
		return "login";
	}
}
