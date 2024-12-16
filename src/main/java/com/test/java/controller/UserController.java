package com.test.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.builder.UserBuilder;
import com.test.java.dto.UserDto;
import com.test.java.dto.response.ResponseDto;
import com.test.java.model.User;
import com.test.java.service.UserService;

import jakarta.validation.Valid;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserBuilder userBuilder;

	public ResponseDto add(@Valid UserDto dto) {
		User user = userBuilder.dtoToModel(dto);
		this.userService.save(user);
		return null;
	}

}
