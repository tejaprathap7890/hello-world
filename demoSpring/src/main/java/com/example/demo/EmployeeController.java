package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entityexamples.Employee;
import com.example.demo.repos.EmployeeDao;
import com.example.demo.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployee()
	{
		return employeeDao.findAll();
	}
	@GetMapping("/getEmployees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable long id )
	{
		return empService.getEmployeeDetails(id);
	}
	
	@PostMapping("/empupdate")
	public Employee saveEmployee(@RequestBody Employee emps)
	{
		return empService.saveEmp(emps);
	}
	
	

}
