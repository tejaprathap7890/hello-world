package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entityexamples.Employee;

import com.example.demo.repos.EmployeeDao;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	public Employee saveEmp(Employee emps) {
		return employeeDao.save(emps);
	}
	public Optional<Employee> getEmployeeDetails(long id) {
		 return employeeDao.findById(id);
	}

}
