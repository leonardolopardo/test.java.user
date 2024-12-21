package com.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.test.java.model.Phone;

public class PhoneTest {
	
	private Phone phone;

	@BeforeEach
	void setUp() {
		phone = Phone.builder().build();
	}
	
	@Test
	void testGetterAndSetter() {
		Long id = 1L;
		phone.setId(id);
		phone.setCitycode("cityCode");
		phone.setCountrycode("countrycode");
		phone.setNumber("1");
		
		assertEquals(id, phone.getId());
		assertEquals("cityCode", phone.getCitycode());
		assertEquals("countrycode", phone.getCountrycode());
		assertEquals("1", phone.getNumber());
	}

}
