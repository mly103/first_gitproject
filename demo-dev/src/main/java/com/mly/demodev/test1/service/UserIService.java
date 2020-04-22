package com.mly.demodev.test1.service;

import com.mly.demodev.test1.bean.User;


import java.util.List;


public interface UserIService {
	
	public void insert(User user);

	User findByName(String usernae);

	List<User> findAll();
}
