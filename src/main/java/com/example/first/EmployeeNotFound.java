package com.example.first;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeNotFound {
 @ExceptionHandler(EmployeeNotFoundException.class)
 @ResponseStatus(HttpStatus.NOT_FOUND)
 String employeeNotFoundHandler(EmployeeNotFoundException ex)
 {
	 return ex.getMessage();
 }
}
