package com.test.java.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Clase de Auditoria
 */
@MappedSuperclass
@SuperBuilder
public abstract class Auditable {
	
	@Getter
	@Setter
	@CreatedDate
	private LocalDateTime createdDate;

	@Getter
	@Setter
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

}
