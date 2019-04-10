package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.postgresql.User;
import com.example.demo.postgresql.userPostgresRepo;

@Component
public class postgresqlService {
	
	@Autowired
	private userPostgresRepo userPostgresRepo;
	
	public List<User> getAllUsers()
	{
		return userPostgresRepo.findAll();
	}

}
