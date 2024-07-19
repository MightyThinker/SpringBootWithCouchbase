package com.pratyush.springcouchbase.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.pratyush.springcouchbase.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CouchbaseRepository<EmployeeEntity, Integer> {
	// Repository Custom Methods or Queries can be defined here
	// Over-ride pre-defined methods here
}
