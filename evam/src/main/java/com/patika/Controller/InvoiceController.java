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
import com.patika.Domain.Invoice;
import com.patika.Services.InvoiceService;



@RestController
@RequestMapping("api/v1/invoice")
@CrossOrigin
@RequestScope


public class InvoiceController {

	private final InvoiceService invoiceService;

	@Autowired
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	@GetMapping("/getall")
	public List<Invoice> getAll(){
		System.out.println("getAll");
		return this.invoiceService.getInvoice();
	}
	 
	
	@PostMapping("/createinvoice")
	public ResponseEntity<?> add(@RequestBody Invoice invoice){
		
		
		System.out.println(invoice.getId());
		this.invoiceService.createInvoice(invoice);

		return ResponseEntity.ok().build();
	} 

	@PutMapping("/update")
    public ResponseEntity <Optional<Invoice>> updateinvoice(@PathVariable Long id, @RequestBody Invoice invoice){
        return ResponseEntity.ok(invoiceService.update(id, invoice));
    }

	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		this.invoiceService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
