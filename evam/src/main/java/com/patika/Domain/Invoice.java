package com.patika.Domain;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@javax.persistence.Table(name="invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int clientId;
	private double debpt;
	private Date date;
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}
	
	public Invoice(long id, int clientId, double debpt, Date date) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.debpt = debpt;
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
	public double getDebpt() {
		return debpt;
	}
	public void setDebpt(double debpt) {
		this.debpt = debpt;
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
		Invoice other = (Invoice) obj;
		return id == other.id;
	}
}
