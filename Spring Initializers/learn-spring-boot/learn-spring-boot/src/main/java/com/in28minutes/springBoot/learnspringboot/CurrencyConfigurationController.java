package com.in28minutes.springBoot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	@Autowired
	private CurrencyConversionConfiguration configuration;
	
	@RequestMapping("/currency-configuration")
	public CurrencyConversionConfiguration retrieveConfig(){
		return configuration;
	}
}
