package com.test.java.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.java.dto.PhoneDto;
import com.test.java.dto.UserDto;
import com.test.java.model.Phone;
import com.test.java.model.User;

@Component
public class UserBuilder {

	@Autowired
	private PhoneBuilder phoneBuilder;

	public User dtoToModel(UserDto userDto) {
		List<Phone> listPhone = phoneBuilder.listDtoToListModel(userDto.getPhones());

		User user = User.builder().id(userDto.getId()).email(userDto.getEmail()).name(userDto.getName())
				.password(userDto.getPassword()).phones(listPhone).build();

		return user;
	}

	public UserDto modelToDto(User user) {

		List<PhoneDto> listPhoneDto = phoneBuilder.listModelToListDto(user.getPhones());

		UserDto userDto = UserDto.builder().id(user.getId()).email(user.getEmail()).name(user.getName())
				.password(user.getPassword()).phones(listPhoneDto).build();

		return userDto;
	}

}
