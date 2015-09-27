package com.training.assignment.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.assignment.domain.CompoundInterest;
import com.training.assignment.domain.Customer;
import com.training.assignment.repository.CompoundInterestRepository;
import com.training.assignment.repository.CustomerRepository;
import com.training.assignment.service.CompoundInterestService;

 
@Service
public class CompoundInterestServiceImpl implements CompoundInterestService {

	/**
	 * This method will calculate compound interest using CompoundInterest
	 * domain object.
	 * 
	 * */
	@Autowired
	private CompoundInterestRepository compoundInterestRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CompoundInterest calculateCI(CompoundInterest compoundInterest) {
		Double ci = 0.0;
		if (compoundInterest == null) {
			return null;
		}

		if (compoundInterest.getPrincipal() > 0
				&& compoundInterest.getRateOfInterest() > 0
				&& compoundInterest.getTime() > 0) {

			Double cal1 = (100 + compoundInterest.getRateOfInterest()) * 0.01;
			Double cal2 = Math.pow(cal1, compoundInterest.getTime());
			ci = (cal2 - 1) * compoundInterest.getPrincipal();
			compoundInterest.setCompoundInterest(ci);
			compoundInterest.setAmount(compoundInterest.getPrincipal() * cal2);
			List<Customer> customers = new ArrayList<Customer>();
			Customer customer1 = new Customer();
 			customer1.setFname("Ramesh");
 			customer1.setLname("Shrivas");
			customerRepository.save(customer1);
 			customers.add(customer1);
 			/**
			 * Below line will save updated CompoundInterest object in database.
			 * 
			 * */
			compoundInterest.setCustomers(customers);
			this.compoundInterestRepository.save(compoundInterest);

		}
		return compoundInterest;
	}

	@Override
	public List<CompoundInterest> findAllCi() {
		return compoundInterestRepository.findAll();
	}

	@Override
	public List<Customer> findAllCust() {
		return customerRepository.findAll();
	}

	@Override
	public void deleteAll() {
		for (Customer customer : customerRepository.findAll()) {
			customerRepository.delete(customer);
		}

		compoundInterestRepository.deleteAll();
	}

}
