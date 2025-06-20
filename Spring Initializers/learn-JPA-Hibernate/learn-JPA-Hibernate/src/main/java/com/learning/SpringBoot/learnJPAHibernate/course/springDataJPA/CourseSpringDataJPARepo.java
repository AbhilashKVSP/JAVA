package com.learning.SpringBoot.learnJPAHibernate.course.springDataJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.SpringBoot.learnJPAHibernate.course.Course;

public interface CourseSpringDataJPARepo extends JpaRepository<Course, Long> {
	
	List<Course> findByAuthor(String author);
}
