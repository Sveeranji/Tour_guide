package com.marolix.traveling.execpetion;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExecptionHandler {
	
	@ExceptionHandler(value =UserNotFoundExecption.class)
	public ResponseEntity<InfoExecption> HandlerExecption(UserNotFoundExecption e)
	{
		String msg=e.getMessage();
		
		InfoExecption infoExecption=new InfoExecption();
		infoExecption.setMsg(msg);
		infoExecption.setTime(LocalDateTime.now());
		
		return new ResponseEntity<InfoExecption>(infoExecption,HttpStatus.BAD_REQUEST);
	}

}
