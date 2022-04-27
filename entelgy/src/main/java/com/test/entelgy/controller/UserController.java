package com.test.entelgy.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entelgy.dto.response.Response;
import com.test.entelgy.dto.response.UserResponseDto;
import com.test.entelgy.service.UsersService;

@RestController("/users")
public class UserController {
	@Autowired
	UsersService usersService;
	@PostMapping
	public Response<UserResponseDto> findUsers(){
		
		HttpStatus status=null;
		UserResponseDto user=null	;
		String message=null;
		try {
			user=usersService.getUsers();
			status=HttpStatus.OK;
		}catch(Exception e) {
			user=null;
			status=HttpStatus.INTERNAL_SERVER_ERROR;
			message="An Exception ocurred trying to find Users"+e.getMessage();
		}
		return new Response<UserResponseDto>(status, message, user);	
	}
}
