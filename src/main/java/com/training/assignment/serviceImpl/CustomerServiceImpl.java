package com.training.assignment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.assignment.domain.ContactDetail;
import com.training.assignment.domain.Customer;
import com.training.assignment.repository.ContactDetailRepository;
import com.training.assignment.repository.CustomerRepository;
import com.training.assignment.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ContactDetailRepository contactDetailRepository; 

	@Override
	public List<Customer> findAllCustomer() {
		return this.customerRepository.findAll();
	}

	@Override
	public Customer findOneById(String id) {
		Customer customer = new Customer();
		if (id == null || id.equalsIgnoreCase(""))
			return customer;
		return this.customerRepository.findCustomerById(id);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		if (customer == null)
			return null;
		ContactDetail contactDetail = customer.getContact();
		this.contactDetailRepository.save(contactDetail);
		customer.setContact(contactDetail);
		return customerRepository.save(customer);

	}

	@Override
	public Boolean deleteCustomer(Customer customer) {
		if (customer != null
				&& (customer.getId() != null || customer.getId() != "")) {
			this.contactDetailRepository.delete(customer.getContact());
			this.customerRepository.delete(customer);
			return true;
		} else {
			return false;
		}

	}

}
