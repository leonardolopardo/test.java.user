package com.test.java.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

public class UserDto {
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	@NotEmpty
	private String name;
	@Getter
	@Setter
	@Email
	@NotEmpty
	private String email;
	@Getter
	@Setter
	@NotEmpty
	private String password;
	@Getter
	@Setter
	private List<PhoneDto> phones;
}
