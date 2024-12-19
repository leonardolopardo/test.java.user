package com.test.java.dto.response;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ResponseUserSaveOkDto extends ResponseDto {

	public ResponseUserSaveOkDto(String httpStatus) {
		super(httpStatus);
	}

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	@CreatedDate
	private LocalDateTime createdDate;

	@Getter
	@Setter
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	@Getter
	@Setter
	private LocalDateTime lastLogin;

	@Getter
	@Setter
	private String token;

	@Getter
	@Setter
	private boolean isactive;

}
