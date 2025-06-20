package com.in28minutes.springBoot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
				new Course(1,"Learn AWS", "In28Min"),
				new Course(1,"Learn Azure", "In28Min"),
				new Course(1,"Learn .NET", "In28Min"));
	}
}
