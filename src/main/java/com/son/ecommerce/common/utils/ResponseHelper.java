package com.son.ecommerce.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ResponseHelper {

	public static Object getMessage(String message, HttpStatus status) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("message", message);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	public static Object getErrors(BindingResult errors, HttpStatus status) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("message", ErrorsResponseHelper.getErrorResponse(errors));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
}
