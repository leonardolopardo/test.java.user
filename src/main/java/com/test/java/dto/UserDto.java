package com.test.java.dto;

import java.util.List;

import com.test.java.util.DynamicRegex;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * DTO de User
 */
@NoArgsConstructor
@SuperBuilder
public class UserDto extends AuditableDto {
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
	@DynamicRegex(regexProperty = "app.secret.password", message = "El password no respeta el patron")
	private String password;
	@Getter
	@Setter
	private List<PhoneDto> phones;
}
