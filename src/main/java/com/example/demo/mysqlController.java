package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mysql.User;

@RestController
@RequestMapping("/mysql")
public class mysqlController {
	
	@Autowired
	private mysqlService mysqlService;
	
	@GetMapping
	public List<User> getAllMysqlUsers()
	{
		return mysqlService.getAllUsers();
	}

}
