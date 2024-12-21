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
import com.test.java.jwt.JwtService;
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

	@Autowired
	private JwtService jwtService;

	private String extractToken(String token) {
		token = token.substring(7);
		return token;
	}

	@PostMapping(value = "")
	public ResponseDto add(@RequestHeader("Authorization") String token, @Valid @RequestBody UserDto dto) {

		// Verificacion si existe el mismo email registrado
		if (!this.userService.existsByEmail(dto.getEmail())) {
			String username = jwtService.extractUsername(extractToken(token));
			dto.setUserName(username);

			User userToSave = userBuilder.dtoToModel(dto);

			LocalDateTime lastLogin = LocalDateTime.now();
			LocalDateTime createdDate = LocalDateTime.now();

			// Verificacion si existe nombre de usuario para actualizar lastLogin
			if (!this.userService.existsByUserName(username)) {
				lastLogin = userToSave.getCreatedDate();
			}

			User userSaved = this.userService.save(userToSave);

			ResponseUserSaveOkDto userSaveOkDto = userSaveBuilder.userToUserOkDto(userSaved);
			userSaveOkDto.setUserName(username);
			userSaveOkDto.setToken(extractToken(token));
			userSaveOkDto.setLastLogin(lastLogin);
			// FIXME no entiendo el criterio cuando un usuario podria estar inactivo.
			userSaveOkDto.setIsactive(true);

			return userSaveOkDto;
		} else {
			return new ResponseErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(), ErrorConstants.EXISTS_EMAIL);
		}
	}
}
