package com.example.kladionica.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UtakmicaPocelaAdvice {
	
	@ResponseBody
	@ExceptionHandler(UtakmicaPocelaException.class)
	
	String utakmicaPocela(UtakmicaPocelaException up) {
		return up.getMessage();
	}

}
