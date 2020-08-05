package com.node.entity.linodeDetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.node.entity.model.ErrorResponse;

@ControllerAdvice
public class LinodeDetailsExceptionHandler {

	@ExceptionHandler(LinodeDetailsException.class)
	public ResponseEntity<Object> handleLinodeDetailsNotFound(LinodeDetailsException linodeDetailsException) {

		return new ResponseEntity<Object>(new ErrorResponse("422", linodeDetailsException.getMessage()),
				HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(DuplicateException.class)
	public ResponseEntity<Object> handleLinodeDetailsNotInserted(DuplicateException linodeDetailsException) {

		return new ResponseEntity<Object>(new ErrorResponse("409", linodeDetailsException.getMessage()),
				HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
