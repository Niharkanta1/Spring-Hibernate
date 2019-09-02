package com.firstWebApp.firstWebAppDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.firstWebApp.firstWebAppDemo.model.ToDo;
import com.firstWebApp.firstWebAppDemo.services.TodoService;

@Controller
@SessionAttributes("userId")
public class ToDoController {
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model){
		String userId = (String) model.get("userId");
		model.put("todos", service.retrieveTodos(userId));
		return "todos";
	}
	
	@RequestMapping(value="/add-todos", method = RequestMethod.POST)
	public String addTodos(ModelMap model, @ModelAttribute("todo")ToDo todo){
		String userId = (String) model.get("userId");
		return "todos";
	}
}
