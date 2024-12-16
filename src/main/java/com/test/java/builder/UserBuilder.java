package com.test.java.builder;

import org.springframework.stereotype.Component;

import com.test.java.dto.UserDto;
import com.test.java.model.User;

@Component
public class UserBuilder {

	public User dtoToModel(UserDto dto) {
		
		User user = User.builder().id(dto.getId()).email(dto.getEmail()).name(dto.getName()).password(dto.getPassword()).build();

		return user;
	}

}
