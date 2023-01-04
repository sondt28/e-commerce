package com.son.ecommerce.common.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

public class ErrorsResponseHelper {

	public static List<String> getErrorResponse(BindingResult result) {
		return result.getAllErrors()
						.stream()
						.map(t -> t.getDefaultMessage())
						.collect(Collectors.toList());
	}
}
