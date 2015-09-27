package com.training.assignment.service;

import java.util.List;

import com.training.assignment.domain.Customer;

 
public interface CustomerService {
	public List<Customer> findAllCustomer();

	public Customer findOneById(String id);

	public Customer saveCustomer(Customer customer);

	public Boolean deleteCustomer(Customer customer);
}
