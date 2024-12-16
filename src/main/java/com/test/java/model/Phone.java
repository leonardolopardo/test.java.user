package com.test.java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Entity
@Table(name = "phone")
public class Phone {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_user")
	private User user;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "number", nullable = false)
	@Getter
	@Setter
	private String number;
	
	@Column(name = "citycode", nullable = false)
	@Getter
	@Setter
	private String citycode;
	
	@Column(name = "countrycode", nullable = false)
	@Getter
	@Setter
	private String countrycode;

}
