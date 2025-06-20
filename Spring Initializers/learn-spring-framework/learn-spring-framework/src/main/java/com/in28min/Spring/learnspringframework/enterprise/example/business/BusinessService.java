
package com.in28min.Spring.learnspringframework.enterprise.example.business;
import com.in28min.Spring.learnspringframework.enterprise.example.data.DataService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BusinessService{
	
	private DataService dataService;
	
	@Autowired
	BusinessService(DataService dataService){
		this.dataService = dataService;
	}
	
	
	public long calculateSum() {
		List<Integer> data = dataService.getData();
		return data.stream().reduce(0,(c,e)-> c+e);
		
	}
}
