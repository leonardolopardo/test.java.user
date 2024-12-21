package com.test.java.builder;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.test.java.dto.response.ResponseUserSaveOkDto;
import com.test.java.model.User;


/**
 * Builder de salida de un User guardado
 */
@Component
public class UserSaveBuilder {

	public ResponseUserSaveOkDto userToUserOkDto(User userSaved) {

		ResponseUserSaveOkDto dto = ResponseUserSaveOkDto.builder().id(userSaved.getId())
				.createdDate(userSaved.getCreatedDate()).isactive(false).lastLogin(null)
				.lastModifiedDate(userSaved.getLastModifiedDate()).token("").httpStatus(HttpStatus.OK.getReasonPhrase()).build();
	return dto;
	}

}
