package com.training.assignment.service;

import java.util.List;

import com.training.assignment.domain.CompoundInterest;
import com.training.assignment.domain.Customer;

 
public interface CompoundInterestService {

	public 	CompoundInterest calculateCI(CompoundInterest compoundInterest);

	public List<CompoundInterest> findAllCi();

	List<Customer> findAllCust();
	public void deleteAll();

}
