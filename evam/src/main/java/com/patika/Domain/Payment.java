package com.patika.Domain;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
@javax.persistence.Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int clientId;
	private double paidTotal;
	private Date date;

	
	@OneToOne(mappedBy = "payment")
    private Customer customer;
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	public Payment(long id, int clientId, double paidTotal, Date date) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.paidTotal = paidTotal;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public double getPaidTotal() {
		return paidTotal;
	}

	public void setPaidTotal(double paidTotal) {
		this.paidTotal = paidTotal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return id == other.id;
	}
}
