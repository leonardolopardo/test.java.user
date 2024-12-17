package com.test.java.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class PhoneDto {

	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	@NotEmpty
	private String number;
	@Getter
	@Setter
	@NotEmpty
	private String citycode;
	@Getter
	@Setter
	@NotEmpty
	private String countrycode;

}
