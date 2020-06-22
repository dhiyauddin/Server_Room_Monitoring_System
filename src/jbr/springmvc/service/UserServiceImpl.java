package jbr.springmvc.service;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
 
	@Autowired
	UserDaoImpl userDaoImpl;

	public void register(User user) {  
		userDaoImpl.register(user);
    }
	
	public User validateUser(Login login){
		User user = new User();		
		user = userDaoImpl.validateUser(login);
		return user;
	}

}	
