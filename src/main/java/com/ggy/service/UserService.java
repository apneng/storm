package com.ggy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggy.dao.UserMapper;
import com.ggy.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public int signUp(User record) {
		// TODO Auto-generated method stub
		return this.userMapper.insert(record);
	}

	public User findUserByName(String userName){
		return this.userMapper.findUserByName(userName);
	}
}
