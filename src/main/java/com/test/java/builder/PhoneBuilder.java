package com.test.java.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.java.dto.PhoneDto;
import com.test.java.model.Phone;

@Component
public class PhoneBuilder {

	public List<Phone> listDtoToListModel(List<PhoneDto> listPhoneDto) {

		List<Phone> listModel = new ArrayList<>();

		for (PhoneDto phoneDto : listPhoneDto) {
			Phone phone = Phone.builder().id(phoneDto.getId()).number(phoneDto.getNumber()).citycode(phoneDto.getCitycode())
					.countrycode(phoneDto.getCountrycode()).build();

			listModel.add(phone);
		}

		return listModel;
	}

}
