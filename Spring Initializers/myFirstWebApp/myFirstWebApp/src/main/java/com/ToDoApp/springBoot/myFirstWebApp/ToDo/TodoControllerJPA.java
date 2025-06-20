package com.ToDoApp.springBoot.myFirstWebApp.ToDo;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private TodoRepository todoRepository;

	@Autowired
	public TodoControllerJPA(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("/List-Todo")
	public String listAllTodos(ModelMap model) {

		String username = getLoggedUserName(model);
		
		List<Todo> todos = todoRepository.findByuserName(username);
		model.put("todos", todos);
		return "ListTodos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showNewTodo(ModelMap model) {
		String userName = getLoggedUserName(model);

		Todo todo = new Todo(0, userName, "Default Description", LocalDate.now().plusWeeks(4), false);
		model.put("todo", todo);

		return "Newtodo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String AddToDo(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors())
			return "Newtodo";

		String userName = getLoggedUserName(model);
		todo.setUserName(userName);
		todoRepository.save(todo);

		return "redirect:List-Todo";
	}

	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {

		todoRepository.deleteById(id);
		return "redirect:List-Todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String ShowupdateTodo(@RequestParam int id, ModelMap model) {

		Todo todo = todoRepository.findById(id).get();
		model.put("todo", todo);
		return "Newtodo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(@RequestParam int id, ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors())
			return "Newtodo";
		
		String userName = getLoggedUserName(model);
		todo.setUserName(userName);
		todoRepository.save(todo);
		
		return "redirect:List-Todo";
	}

	private String getLoggedUserName(ModelMap model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
