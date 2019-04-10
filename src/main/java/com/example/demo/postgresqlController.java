package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.postgresql.User;

@RestController
@RequestMapping("/postgresql")
public class postgresqlController {

	@Autowired
	private postgresqlService postgresqlService;
	
	@GetMapping
	public List<User> getAllPostgresqlUsers()
	{
		return postgresqlService.getAllUsers();
	}
}
