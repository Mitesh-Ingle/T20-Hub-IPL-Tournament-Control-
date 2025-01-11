package com.tka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.UserDao;

@Service
public class UserService {
	public UserService() {
		System.err.println("In UserService");
	}

	@Autowired
	private UserDao dao;

	public boolean loginUser(String username, String password) {
		return dao.loginUser(username, password);
	}

}
