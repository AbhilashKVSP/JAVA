package com.learning.SpringBoot.learnJPAHibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.learning.SpringBoot.learnJPAHibernate.course.JPA.CourseJPARepository;
import com.learning.SpringBoot.learnJPAHibernate.course.springDataJPA.CourseSpringDataJPARepo;
//import com.learning.SpringBoot.learnJPAHibernate.course.jdbc.courseJDBCRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private courseJDBCRepository repo;
	
//	@Autowired
//	private CourseJPARepository repo;

	@Autowired
	private CourseSpringDataJPARepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
//		repo.insert(new Course(1,"LearnFluidDynamics","Anderson"));
//		repo.insert(new Course(2,"LearnFluidDynamics","Abhilash"));
//		repo.deleteByID(2);
//		System.out.println(repo.findByID(1));

		repo.save(new Course(1,"LearnFluidDynamics","Anderson"));
		repo.save(new Course(2,"LearnFluidDynamics","Abhilash"));
		repo.deleteById(2l);
		System.out.println(repo.findById(1l));
		System.out.println(repo.findByAuthor("Anderson"));

		
	}
	
}
