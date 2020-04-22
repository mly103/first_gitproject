package com.mly.demodev.test1.mapper;

import com.mly.demodev.test1.bean.User;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper{

	public void insert(User user);

	public void update(User user);
	
	public void delete(int id);

	public User find(int id);

	/**
	 * 用sql写的语句
	 * @param username
	 * @return
	 */
	@Select("select * from user where username = #{username}")
	public User findByName(String username);

	@Select("select * from user")
	public List<User> findAll();
}
