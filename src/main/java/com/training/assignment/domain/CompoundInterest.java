package com.training.assignment.domain;

import java.util.List;

import javax.persistence.Entity;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import springdata.mongodb.CascadeSave;
import flexjson.JSONSerializer;

/**
 * This is a domain object to handle compound interest .
 * 
 */
@Entity(name = "compoundInterest")
public class CompoundInterest {

	@Id
	private String id;
	private Double principal;
	private Double rateOfInterest;
	private Integer time;
	private Double amount;
	private Double compoundInterest;
	@DBRef
//	private Customer customer;
	
	private List<Customer> customers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getCompoundInterest() {
		return compoundInterest;
	}

	public void setCompoundInterest(Double compoundInterest) {
		this.compoundInterest = compoundInterest;
	}

	public static String toJson(CompoundInterest compoundInterest) {
		return new JSONSerializer().exclude("*.class").include("customers").serialize(
				compoundInterest);
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	 

}
