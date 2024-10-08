package com.example.first;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
   
   @PostMapping("/employees")
   Employee newEmployee(@RequestBody Employee newEmployee)
   {
	  return  repository.save(newEmployee);
   }
   
   @GetMapping("/employees/{id}")
   Employee getEmployee(@PathVariable Long id)
   {
	   return repository.findById(id)
			   .orElseThrow(()-> new EmployeeNotFoundException(id));
   }
   
   @PutMapping("/employees/{id}")
   Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id)
   {
	 return repository.findById(id)
			 .map(employee -> {
				  employee.setName(newEmployee.getName());
				  employee.setRole(newEmployee.getRole());
				  return repository.save(employee);
			 })
			 .orElseGet(()-> {return  repository.save(newEmployee);});
   }
   @DeleteMapping("/employees/{id}")
   void remove(@PathVariable Long id)
   {
	   repository.deleteById(id);
   }
   
   @PutMapping("/employees/{id}")
   Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id)
   {
	 return repository.findById(id)
			 .map(employee -> {
				  employee.setName(newEmployee.getName());
				  employee.setRole(newEmployee.getRole());
				  return repository.save(employee);
			 })
			 .orElseGet(()-> {return  repository.save(newEmployee);});
   }
   
   
}
