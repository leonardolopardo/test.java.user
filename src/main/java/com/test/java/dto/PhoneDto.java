package com.test.java.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * DTO de Phone
 */
@NoArgsConstructor
@SuperBuilder
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
