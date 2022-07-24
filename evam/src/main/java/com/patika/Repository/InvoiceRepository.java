package com.patika.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patika.Domain.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>  {

}
