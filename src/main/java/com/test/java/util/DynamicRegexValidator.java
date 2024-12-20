package com.test.java.util;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class DynamicRegexValidator implements ConstraintValidator<DynamicRegex, String> {

	private final Environment environment;
	private String regex;

	public DynamicRegexValidator(Environment environment) {
		this.environment = environment;
	}

	@Override
	public void initialize(DynamicRegex constraintAnnotation) {
		// Obtén la expresión regular desde el archivo .properties
		String propertyKey = constraintAnnotation.regexProperty();
		this.regex = environment.getProperty(propertyKey);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || regex == null) {
			return false;
		}
		return value.matches(regex);
	}
}
