package com.test.java.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class PhoneDto {

	@Getter
	@Setter
	private UUID id;
	@Getter
	@Setter
	private String number;
	@Getter
	@Setter
	private String citycode;
	@Getter
	@Setter
	private String contrycode;

}
