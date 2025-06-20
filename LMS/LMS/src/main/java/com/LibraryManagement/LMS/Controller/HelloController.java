package com.LibraryManagement.LMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.LibraryManagement.LMS.Configuration.LibraryConfiguration;


@RestController
@RequestMapping("/hello")

public class HelloController {

	@Autowired
	private LibraryConfiguration configuration;
	
	@GetMapping(value = "/libDetails")
	public LibraryConfiguration sayHello() {
		return configuration;
	}	
}
