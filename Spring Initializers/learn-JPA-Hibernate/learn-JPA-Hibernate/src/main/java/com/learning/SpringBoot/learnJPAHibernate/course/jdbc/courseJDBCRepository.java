package com.learning.SpringBoot.learnJPAHibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.SpringBoot.learnJPAHibernate.course.Course;

@Repository
public class courseJDBCRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY =
			
			"""
			insert into Course(id,name,author)
			values(?,?,?);
			
			""";
	private static String DELETE_QUERY =
			
			"""
			delete from course 
			where id=?;
			
			""";
	private static String SELECT_QUERY =
			
			"""
			select * from course where id =?;
			
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void deleteByID(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);
	}
	
	public Course findByID(long id) {
		
		//result set to the bean -> called Row Mapper
		return springJdbcTemplate.queryForObject(SELECT_QUERY, 
				new BeanPropertyRowMapper<>(Course.class),id);
	}
}
