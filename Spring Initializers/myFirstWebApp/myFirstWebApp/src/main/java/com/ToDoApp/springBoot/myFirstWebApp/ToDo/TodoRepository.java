package com.ToDoApp.springBoot.myFirstWebApp.ToDo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer>{
	
	public List<Todo> findByuserName(String userName);
}
