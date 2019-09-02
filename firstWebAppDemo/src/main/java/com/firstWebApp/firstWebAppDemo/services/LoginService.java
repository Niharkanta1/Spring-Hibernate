package com.firstWebApp.firstWebAppDemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstWebApp.firstWebAppDemo.dao.LoginDao;
import com.firstWebApp.firstWebAppDemo.model.Student;

@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;
	public boolean validateUser(String userid, String password) {
       Student student = loginDao.getUserDetails(userid);
       if(null != student && student.getPassword().equals(password)){
    	   return true;
       }
        return false;
	}
}
