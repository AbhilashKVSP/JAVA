package com.MicroServices.LearnConfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Autowired
	private propValue propValues;
	
	@Autowired
	private Environment env;

	@Value("${my.Greeting}")
	private String greetingMsg;
	@Value("${my.takeDefault}:defaultValue")
	private String takeDefault;
	@Value("${my.list}")
	private List<String> strList;
	@Value("#{${my.map}}")
	private Map<String,String> strMap;

	@GetMapping("/greeting1")
	public String greeting1() {
		return greetingMsg;
	}

	@GetMapping("/greeting2")
	public String greeting2() {
		return takeDefault;
	}

	@GetMapping("/greeting3")
	public List<String> greeting3() {
		return strList;
	}

	@GetMapping("/greeting4")
	public Map<String, String> greeting4() {
		return strMap;
	}

	@GetMapping("/greeting5")
	public String greeting5() {
		return propValues.toString();
	}
	
	@GetMapping("/envDetails")
	public String[] envDetails() {
		return env.getActiveProfiles();
	}
	
}
