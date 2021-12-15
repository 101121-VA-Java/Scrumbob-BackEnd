package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Daos.UserDao;
import com.revature.models.User;

@Service
public class UserService {
	private UserDao ud;
	
	@Autowired
	public UserService(UserDao ud) {
		this.ud = ud;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void createUser(User u) {
		ud.save(u);
	}
	
	public List<User> getAllUsers(){
		return ud.findAll();
		
	}
	
	public User getUser(int id){
		return ud.getById(id);
		
	}

}
