package com.test.java.dto.response;

import lombok.Getter;
import lombok.Setter;

public class ResponseErrorDto extends ResponseDto {

	public ResponseErrorDto(String httpStatus, String mensaje) {
		super(httpStatus);
		this.mensaje = mensaje;
	}

	@Getter
	@Setter
	private String mensaje;
}
