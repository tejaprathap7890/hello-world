package com.example.demo.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entityexamples.Customer;
@Repository
@Transactional
public interface CustomerDao extends JpaRepository<Customer,Long>
{
	
}
