package com.patika.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patika.Domain.Payment;
import com.patika.Repository.PaymentRepository;
@Service
public class PaymentService {

	private final PaymentRepository paymentRepository;

	@Autowired
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	public List<Payment> getPayment() {

		return paymentRepository.findAll();
	}

	public void createCustomer(Payment toAdd) {
		paymentRepository.save(toAdd);
	}

	@Transactional
	public Optional<Payment> update(Long id, Payment payment) {
		return paymentRepository.findById(id).map(item -> {

			item.setClientId(payment.getClientId());
			item.setDate(payment.getDate());
			item.setId(payment.getId());
			item.setPaidTotal(payment.getPaidTotal());

			return paymentRepository.save(item);
		});
	}

	public void delete(Long id) {
		System.out.println("silindi");
		paymentRepository.deleteById(id);
	}
}
