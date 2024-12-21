package com.test.java.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

public class TokenDto {
	
	@Getter
	@Setter
	@NotEmpty 
	private String userName;

}
