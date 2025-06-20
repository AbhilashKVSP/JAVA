package com.ToDoApp.springBoot.myFirstWebApp.ToDo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static int todosCount = 0;
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(++todosCount,"Abhilash","Learn Microservices1", LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"Srinivas","Get MedicalCheckup1", LocalDate.now().plusMonths(1),false));
		todos.add(new Todo(++todosCount,"Padma","Get Bangles1", LocalDate.now().plusDays(6),false));
		todos.add(new Todo(++todosCount,"Abhilash","Learn Scooter1", LocalDate.now().plusYears(1),false));
	}
	
	public List<Todo> findByUsername (String userName){
		Predicate<? super Todo> predicate = todo ->todo.getUserName().equalsIgnoreCase(userName);
		return todos.stream().filter(predicate).toList();
	}
	
	public void AddTodo(String userName, String description, LocalDate targetDate, boolean done) {
		todos.add(new Todo(++todosCount,userName,description,targetDate,done));	
	}
	
	public void deleteById(int id) {
		
		Predicate<? super Todo> predicate = todo ->todo.getId()==id;
		todos.removeIf(predicate);
	}

	public Todo findByID(int id) {
		Predicate<? super Todo> predicate = todo ->todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateByID(int id, String description) {
		Predicate<? super Todo> predicate = todo ->todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		todo.setDescription(description);
	}
}
