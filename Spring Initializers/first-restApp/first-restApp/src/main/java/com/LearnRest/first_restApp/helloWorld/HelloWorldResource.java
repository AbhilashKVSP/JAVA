package com.LearnRest.first_restApp.helloWorld;

import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldResource {
	
	@RequestMapping("/hello-world")
//	@ResponseBody
	public String helloWorld() {
		return "Hello World";
	}

	@RequestMapping("/hello-worldBean/{name}/message/{message}")
	public HelloWorldBean helloWorldBean(@PathVariable String message,@PathVariable String name) {
		return new HelloWorldBean("Hello World "+ name +" , "+ message);
	}

}
