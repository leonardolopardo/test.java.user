package com.test.java.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.builder.UserBuilder;
import com.test.java.builder.UserSaveBuilder;
import com.test.java.constants.ErrorConstants;
import com.test.java.dto.UserDto;
import com.test.java.dto.response.ResponseDto;
import com.test.java.dto.response.ResponseErrorDto;
import com.test.java.dto.response.ResponseUserSaveOkDto;
import com.test.java.model.User;
import com.test.java.service.UserService;

import jakarta.validation.Valid;


/**
 * Comportamiento para el controlador de User
 */
@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserBuilder userBuilder;

	@Autowired
	private UserSaveBuilder userSaveBuilder;

	@PostMapping(value = "")
	public ResponseDto add(@RequestHeader("Authorization") String token, @Valid @RequestBody UserDto dto) {

		if (!this.userService.existsByEmail(dto.getEmail())) {
			User userToSave = userBuilder.dtoToModel(dto);
			User userSaved = this.userService.save(userToSave);

			ResponseUserSaveOkDto userSaveOkDto = userSaveBuilder.userToUserOkDto(userSaved);
			userSaveOkDto.setToken(token);
			userSaveOkDto.setLastLogin(LocalDateTime.now());
			
			
			return userSaveOkDto;
		} else {
			return new ResponseErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(), ErrorConstants.EXISTS_EMAIL);
		}

	}

}
