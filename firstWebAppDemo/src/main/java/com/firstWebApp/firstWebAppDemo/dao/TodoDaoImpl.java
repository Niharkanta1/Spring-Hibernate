package com.firstWebApp.firstWebAppDemo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.firstWebApp.firstWebAppDemo.model.ToDo;
import com.firstWebApp.firstWebAppDemo.rowmapper.ToDoRowMapper;
@Repository
public class TodoDaoImpl implements TodoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ToDo> getTodosByUser(String user) {
		String sql = "select * from STUDENT_TODO where username=?";
		List<ToDo> todos = new ArrayList<ToDo>();
		RowMapper<ToDo> rowMapper = new ToDoRowMapper();
		todos = jdbcTemplate.query(sql, rowMapper, user);
		return todos;
	}

	public void addTodos(String name, String desc, Date targetDate, boolean isDone) {
		// TODO Auto-generated method stub
		
	}

	public void assignTodosToUser(int id, String user) {
		// TODO Auto-generated method stub
		
	}

	public void deleteToDoByUser(String user) {
		// TODO Auto-generated method stub
		
	}

}
