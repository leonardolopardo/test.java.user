package com.test.java.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.java.model.User;

@Service
@Repository
public interface UserService extends CrudRepository<User, Long> {

	boolean existsByEmail(String email);

}
