package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.model.Usr;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Usr> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<Usr> findAllUsers() {
		return users;
	}
	
	public Usr findById(long id) {
		for(Usr user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public Usr findByName(String name) {
		for(Usr user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(Usr user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(Usr user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<Usr> iterator = users.iterator(); iterator.hasNext(); ) {
		    Usr user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(Usr user) {
		return findByName(user.getName())!=null;
	}

	private static List<Usr> populateDummyUsers(){
		List<Usr> users = new ArrayList<Usr>();
		users.add(new Usr(counter.incrementAndGet(),"Sam",30, 70000));
		users.add(new Usr(counter.incrementAndGet(),"Tom",40, 50000));
		users.add(new Usr(counter.incrementAndGet(),"Jerome",45, 30000));
		users.add(new Usr(counter.incrementAndGet(),"Silvia",50, 40000));
		return users;
	}

	public void deleteAllUsers() {
		users.clear();
	}

}
