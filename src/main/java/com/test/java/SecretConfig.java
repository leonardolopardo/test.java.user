package com.test.java;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase para leer propiedades del application.properties
 */
@Component
@ConfigurationProperties(prefix = "app.secret")
public class SecretConfig {

	@Getter
	@Setter
	private String password;

}
