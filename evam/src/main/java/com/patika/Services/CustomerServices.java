package com.patika.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patika.Domain.Customer;
import com.patika.Repository.CustomerRepository;


@Service
public class CustomerServices {
	
	private final CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServices(CustomerRepository repository) {
		this.customerRepository=repository;
		
	}
	
	public List<Customer> getCustomer(){
		
		return customerRepository.findAll();
	}
	
	public void createCustomer(Customer toAdd) {
		 customerRepository.save(toAdd);
	}

	 @Transactional
	    public Optional<Customer> update(Long id , Customer customer) {
	        return customerRepository.findById(id).map(item -> {
	        	item.setName(customer.getName());
	        	item.setSurname(customer.getSurname());
	        	item.setSubscribernumber(customer.getSubscribernumber());
	         
	            return customerRepository.save(item);
	        });
	    }

	public void delete(Long id) {
		System.out.println("silindi");
		customerRepository.deleteById(id);
	}
}
