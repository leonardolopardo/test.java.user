package com.test.java.dto.response;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Clase padre para las respuestas
 */
@MappedSuperclass
@AllArgsConstructor
@SuperBuilder
public abstract class ResponseDto {

	@Getter
	@Setter
	private String httpStatus;
}
