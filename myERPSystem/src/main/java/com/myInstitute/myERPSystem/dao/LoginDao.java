package com.myInstitute.myERPSystem.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myInstitute.myERPSystem.model.Student;

@Repository
public class LoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	public Student getUserDetails(String userId){		
		String sql = "select * from Student where userid=?";
		Student student = null;
		try{
			student = (Student)jdbcTemplate.queryForObject(sql, new Object[] { userId }, new BeanPropertyRowMapper(Student.class));
		}
		catch(Exception e){
			return student;
		}
		return student; 
	}
}
