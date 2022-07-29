package com.dio.academiadigital.services.exceptions;

import java.util.Set;

import javax.validation.ConstraintViolationException;

public class ConstraintViolation extends ConstraintViolationException{

	public ConstraintViolation(Set<? extends javax.validation.ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
		// TODO Auto-generated constructor stub
	}

	
	
	

}
