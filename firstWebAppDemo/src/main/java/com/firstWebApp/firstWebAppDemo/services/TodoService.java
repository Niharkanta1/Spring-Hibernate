package com.firstWebApp.firstWebAppDemo.services;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstWebApp.firstWebAppDemo.dao.TodoDao;
import com.firstWebApp.firstWebAppDemo.model.ToDo;


@Service
public class TodoService {
	private List<ToDo> todos = new ArrayList<ToDo>();
	private int todosCount = 3;
	
	@Autowired
	private TodoDao todoDao;
	
	public List<ToDo> retrieveTodos(String userId){
		List<ToDo> filteredTodos = todoDao.getTodosByUser(userId);
		return filteredTodos;
	}
	public void deleteTodos(int id){
		Iterator<ToDo> itr = todos.iterator();
		while(itr.hasNext()){
			ToDo todo = itr.next();
			if(todo.getId()==id){
				itr.remove();
			}
		}
	}	
}
