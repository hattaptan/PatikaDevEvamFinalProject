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

import com.patika.Domain.Payment;
import com.patika.Services.PaymentService;

@RestController
@RequestMapping("api/v1/payment")
@CrossOrigin
@RequestScope 
public class PaymentController {

	private final PaymentService paymentService;
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	@GetMapping("/getall")
	public List<Payment> getAll(){
		System.out.println("getAll");
		return this.paymentService.getPayment();
	}
	 
	
	@PostMapping("/createpayment")
	public ResponseEntity<?> add(@RequestBody Payment payment){
		
		
		System.out.println(payment.getId());
		this.paymentService.createCustomer(payment);

		return ResponseEntity.ok().build();
	} 

	@PutMapping("/update")
    public ResponseEntity <Optional<Payment>> updatepayment(@PathVariable Long id, @RequestBody Payment payment){
        return ResponseEntity.ok(paymentService.update(id, payment));
    }

	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.paymentService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
