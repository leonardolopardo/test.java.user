package com.test.java.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
public abstract class AuditableDto {
	@Getter
	@Setter
	@CreatedDate
	private LocalDateTime createdDate;

	@Getter
	@Setter
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;
}
