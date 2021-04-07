package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entityexamples.Customer;
import com.example.demo.repos.CustomerDao;

@Service
public class CustomerService {
	@Autowired
    CustomerDao customerDao;
	public Customer saveCustomer(Customer customer) {
		return customerDao.save(customer);
	}
	public Optional<Customer> getCustomerDetails(int id) {
		
	return customerDao.findById((long) id);
	}
	
}
