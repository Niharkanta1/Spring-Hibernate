package com.firstWebApp.firstWebAppDemo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.firstWebApp.firstWebAppDemo.model.ToDo;

public interface TodoDao {
	List<ToDo> todos = new ArrayList<ToDo>();
	public List<ToDo> getTodosByUser(String user);
	public void addTodos(String name, String desc, Date targetDate, boolean isDone);
	public void assignTodosToUser(int id, String user);
	public void deleteToDoByUser(String user);
}
