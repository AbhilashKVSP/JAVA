package com.in28min.Spring.learnspringframework.enterprise.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28min.Spring.learnspringframework.enterprise.example.business.BusinessService;

@Component
public class MyWebController {
	
	private BusinessService businessService;
	
	@Autowired
	MyWebController(BusinessService businessService){
		this.businessService = businessService;
	}
	
	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}

}
