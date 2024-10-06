package com.example.first;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
  private final EmployeeRepository repository;
   EmployeeController(EmployeeRepository repository)
   {
	   this.repository= repository;
   }
   @GetMapping("/employees")
   List<Employee> all()
   {
	   System.out.println(repository.count());
	    return repository.findAll();
   }
}
