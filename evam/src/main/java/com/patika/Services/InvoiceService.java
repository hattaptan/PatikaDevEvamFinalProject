package com.patika.Services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patika.Domain.Invoice;
import com.patika.Repository.InvoiceRepository;

@Service
public class InvoiceService {

	private InvoiceRepository invoiceRepository;
	@Autowired
	public InvoiceService(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}
public List<Invoice> getInvoice(){
		
		return invoiceRepository.findAll();
	}
	
	public void createInvoice(Invoice toAdd) {
		invoiceRepository.save(toAdd);
	}

	 @Transactional
	    public Optional<Invoice> update(Long id , Invoice invoice) {
	        return invoiceRepository.findById(id).map(item -> {
	        	
	        	item.setClientId(invoice.getClientId());
	        	item.setDate(invoice.getDate());
	        	item.setDebpt(item.getDebpt());
	        	item.setId(item.getId());
	        
	         
	            return invoiceRepository.save(item);
	        });
	    }

	public void delete(Long id) {
		System.out.println("silindi");
		invoiceRepository.deleteById(id);
	}
}
