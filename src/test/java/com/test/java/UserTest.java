package com.test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.test.java.model.Phone;
import com.test.java.model.User;

class UserTest {

	private User user;

	@BeforeEach
	void setUp() {
		user = User.builder().build();
	}

	@Test
	void testGetterAndSetter() {
		Long id = 1L;
		user.setId(id);
		String name = "Leo";
		user.setName(name);
		String userName = "leo";
		user.setUserName(userName);
		String email = "leo@example.com";
		user.setEmail(email);
		String password = "securePassword";
		user.setPassword(password);
		
		assertEquals(id, user.getId());
		assertEquals(name, user.getName());
		assertEquals(userName, user.getUserName());
		assertEquals(email, user.getEmail());
		assertEquals(password, user.getPassword());
	}

	@Test
	void testPhonesGetterAndSetter() {
		List<Phone> phones = new ArrayList<>();
		Phone phone1 = Phone.builder().build();
		phone1.setId(1L);
		phone1.setNumber("123456789");
		phones.add(phone1);

		Phone phone2 = Phone.builder().build();
		phone2.setId(2L);
		phone2.setNumber("987654321");
		phones.add(phone2);

		user.setPhones(phones);
		assertEquals(phones, user.getPhones());
		assertEquals(2, user.getPhones().size());
		assertEquals("123456789", user.getPhones().get(0).getNumber());
	}

	@Test
	void testAddPhoneToUser() {
		List<Phone> phones = new ArrayList<>();
		user.setPhones(phones);

		Phone phone = Phone.builder().build();
		phone.setId(1L);
		phone.setNumber("123456789");
		phone.setCitycode("Citycode");
		phone.setCountrycode("Countrycode");

		user.getPhones().add(phone);

		assertEquals(1, user.getPhones().size());
		assertEquals(phone, user.getPhones().get(0));
		assertEquals("Citycode", user.getPhones().get(0).getCitycode());
		assertEquals("Countrycode", user.getPhones().get(0).getCountrycode());
	}
}
