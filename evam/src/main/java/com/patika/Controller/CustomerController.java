package com.patika.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

 
import com.patika.Domain.Customer;
import com.patika.Services.CustomerServices;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
@RequestScope

public class CustomerController {

	public final CustomerServices customerService;
	
	@Autowired
	public CustomerController(CustomerServices service) {
		this.customerService=service;
	}
	
	@GetMapping("/customerinfo")
	public List<Customer> getAll(){
		System.out.println("getAll");
		return this.customerService.getCustomer();
	}
	 
	
	@PostMapping("/createcustomer")
	public ResponseEntity<?> add(@RequestBody Customer customer){
		
		
		System.out.println(customer.getName());
		this.customerService.createCustomer(customer);

		return ResponseEntity.ok().build();
	} 

	@PutMapping("/update")
    public ResponseEntity <Optional<Customer>> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.update(id, customer));
    }

	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.customerService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}