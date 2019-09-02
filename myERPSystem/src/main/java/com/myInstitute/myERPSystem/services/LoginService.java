package com.myInstitute.myERPSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myInstitute.myERPSystem.dao.LoginDao;
import com.myInstitute.myERPSystem.model.Student;

@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;
	public boolean validateUser(Student student) {
       Student result = loginDao.getUserDetails(student.getUserId());
       if(null != student && student.getPassword().equals(result.getPassword())){
    	   return true;
       }
        return false;
	}
}
