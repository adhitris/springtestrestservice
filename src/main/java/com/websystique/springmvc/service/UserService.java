package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Usr;



public interface UserService {
	
	Usr findById(long id);
	
	Usr findByName(String name);
	
	void saveUser(Usr user);
	
	void updateUser(Usr user);
	
	void deleteUserById(long id);

	List<Usr> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(Usr user);
	
}
