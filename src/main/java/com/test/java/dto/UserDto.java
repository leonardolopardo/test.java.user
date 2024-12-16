package com.test.java.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class UserDto {
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	private List<PhoneDto> phones;
}
