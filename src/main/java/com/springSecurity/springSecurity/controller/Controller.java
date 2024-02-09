package com.springSecurity.springSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurity.springSecurity.model.UserData;
import com.springSecurity.springSecurity.security.service.ServiceTest;

@RestController
@RequestMapping("/security")
public class Controller {
	
	@Autowired
	private ServiceTest serviceTest;

    @GetMapping("/welcome")
    public String greeting() {
        return "welcome";
    }

    @GetMapping("/all")
    public String login(){
        return "allroles";
    }
    
    @PostMapping("/createUser")
    public String addNewUser(@RequestBody UserData userData) {
    	return serviceTest.addUser(userData);
    }
    
    
    
}
