package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entityexamples.Customer;
import com.example.demo.repos.CustomerDao;
import com.example.demo.services.CustomerService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

@Autowired
CustomerService customerService;
@Autowired
CustomerDao cd;


	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		return customerService.saveCustomer(customer);
	}
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomerDetails(@PathVariable int id)
	{
		return customerService.getCustomerDetails(id);
		
	}
	@PutMapping("customerupdate/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") int  custid,
			  @RequestBody Customer customer)  {
			 Customer cust = cd.findById((long) custid).get();
			

			cust.setFname(customer.getFname());
			 cust.setLname(customer.getLname());
			cust.setAddress(customer.getAddress());
			 final Customer c = cd.save(cust);
			 return ResponseEntity.ok(c);
			}
	@DeleteMapping("deletecustomer/{id}")
	public ResponseEntity<Void> deleteEmplotee(@PathVariable(value="id") int custid)
	{
		Customer c=cd.findById((long) custid).get();
		cd.delete(c);
		return ResponseEntity.ok().build();

	}
	
}









