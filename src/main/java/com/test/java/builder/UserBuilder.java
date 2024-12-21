package com.test.java.builder;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.java.dto.PhoneDto;
import com.test.java.dto.UserDto;
import com.test.java.model.Phone;
import com.test.java.model.User;

/**
 * Builder de la clase User
 */
@Component
public class UserBuilder {

	@Autowired
	private PhoneBuilder phoneBuilder;

	// FIXME Se considera lastModifiedDate en NULL, ya que el problema no plantea
	// metodo de modificacion.
	// FIXME Se considera createdDate como un LocalDateTime.now(). Todo POST genera
	// una nueva tupla en base de datos.
	public User dtoToModel(UserDto userDto) {
		List<Phone> listPhone = phoneBuilder.listDtoToListModel(userDto.getPhones());

		User user = User.builder().id(userDto.getId()).email(userDto.getEmail()).name(userDto.getName())
				.userName(userDto.getUserName()).password(userDto.getPassword()).phones(listPhone)
				.createdDate(LocalDateTime.now()).lastModifiedDate(null).build();

		return user;
	}

	public UserDto modelToDto(User user) {

		List<PhoneDto> listPhoneDto = phoneBuilder.listModelToListDto(user.getPhones());
		UserDto userDto = UserDto.builder().id(user.getId()).email(user.getEmail()).name(user.getName())
				.password(user.getPassword()).phones(listPhoneDto).createdDate(user.getCreatedDate())
				.lastModifiedDate(user.getLastModifiedDate()).build();

		return userDto;
	}

}
