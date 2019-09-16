package com.example.kladionica.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class NedovoljnoNovcaAdvice {
	
	@ResponseBody
	@ExceptionHandler(NedovoljnoNovcaException.class)
	
	String nedovoljnoNovca(NedovoljnoNovcaException nn) {
		
		return	nn.getMessage();
	}

}
