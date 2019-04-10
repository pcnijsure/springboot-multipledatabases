package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.mysql.User;
import com.example.demo.mysql.userMysqlRepo;

@Component
public class mysqlService {
	
	@Autowired
	private userMysqlRepo userMysqlRepo;
	
	public List<User> getAllUsers()
	{
		return userMysqlRepo.findAll();
	}

}