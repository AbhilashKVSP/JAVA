package com.learning.SpringBoot.learnJPAHibernate.course.JPA;

import org.springframework.stereotype.Repository;

import com.learning.SpringBoot.learnJPAHibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findByID(long id) {
		Course course = entityManager.find(Course.class, id);
		return course;
	}
	
	public void deleteByID(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
	
	
	

}
