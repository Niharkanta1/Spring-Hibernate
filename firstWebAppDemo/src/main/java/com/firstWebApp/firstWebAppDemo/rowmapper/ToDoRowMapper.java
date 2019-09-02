package com.firstWebApp.firstWebAppDemo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.firstWebApp.firstWebAppDemo.model.ToDo;

public class ToDoRowMapper implements RowMapper<ToDo> {
	
	public ToDo mapRow(ResultSet row, int rowNo) throws SQLException {
		ToDo todo = new ToDo();
		todo.setId(row.getInt("ID"));
		todo.setDesc(row.getString("DESCRIPTION"));
		todo.setTargetDate(row.getDate("TARGETDATE"));
		todo.setUser(row.getString("USERNAME"));
		todo.setStatus(row.getBoolean("ISDONE"));
		return todo;
	}

}
