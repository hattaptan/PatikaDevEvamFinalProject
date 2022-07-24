package com.patika.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patika.Domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

 
	
}
