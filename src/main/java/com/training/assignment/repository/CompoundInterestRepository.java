package com.training.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.assignment.domain.CompoundInterest;

 
@Repository("conactRepository")
public interface CompoundInterestRepository extends
		MongoRepository<CompoundInterest, Long> {

}
