package com.training.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.assignment.domain.Customer;

 
@Repository("customerRepository")
public interface CustomerRepository extends MongoRepository<Customer, Long> {
	public Customer findCustomerById(String id);

}
