package com.test.java.model;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Clase User
 */
@SuperBuilder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	@Getter
	@Setter
	private Long id;

	@Column(name = "name", nullable = false)
	@Getter
	@Setter
	private String name;
	
	@Column(name = "username", nullable = false)
	@Getter
	@Setter
	private String userName;

	@Column(name = "email", nullable = false)
	@Getter
	@Setter
	private String email;

	@Column(name = "password", nullable = false)
	@Getter
	@Setter
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = false)
	@Getter
	@Setter
	private List<Phone> phones;

}
