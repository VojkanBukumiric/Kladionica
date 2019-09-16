package com.example.kladionica.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DuplaUtakmicaAdvice {
	
	@ResponseBody
	@ExceptionHandler(DuplaUtakmicaException.class)
	
	String duplaUtakmica(DuplaUtakmicaException du) {
	return du.getMessage();	
	}

}
