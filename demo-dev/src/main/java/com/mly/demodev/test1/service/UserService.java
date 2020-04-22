package com.mly.demodev.test1.service;

import javax.annotation.Resource;

import com.mly.demodev.test1.bean.User;
import com.mly.demodev.test1.mapper.UserMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;


@ComponentScan({"com.mly.demodev.test1.mapper"})
@Service("userService")
public class UserService implements UserIService{

	@Resource
	private UserMapper userMapper;
	
	@Override
	public void insert(User user) {
		userMapper.insert(user);
	}

	public void update(User user) {
		userMapper.update(user);
	}

	public User find(int id) {
		return userMapper.find(id);
	}
	
	public void delete(int id){
		userMapper.delete(id);
	}

	public User findByName(String username){
		return userMapper.findByName(username);
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}
}
