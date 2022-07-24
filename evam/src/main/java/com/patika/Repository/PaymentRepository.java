package com.patika.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patika.Domain.Invoice;
import com.patika.Domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>   {

}
