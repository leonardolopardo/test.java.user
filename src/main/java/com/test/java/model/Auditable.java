package com.test.java.model;

import java.time.LocalDateTime;

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
	private LocalDateTime createdDate;

	@Getter
	@Setter
	private LocalDateTime lastModifiedDate;

}
