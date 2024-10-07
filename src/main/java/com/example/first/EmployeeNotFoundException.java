package com.example.first;

public class EmployeeNotFoundException extends RuntimeException {
   EmployeeNotFoundException(Long id){
	   super ("could not find employee "+ id);
   }
}
