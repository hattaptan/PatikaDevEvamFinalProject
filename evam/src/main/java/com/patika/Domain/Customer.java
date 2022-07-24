package com.patika.Domain;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Table;

@Entity
@javax.persistence.Table(name="customers")
public class Customer {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
 
	private String Name;
 
	private String Surname;
 
	private int Subscribernumber;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
	private List<Invoice> invoice;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Payment payment;
	
	public Customer() {
	}

	public Customer(Long id, String name, String surname, int subscribernumber) {
		super();
		Id = id;
		Name = name;
		Surname = surname;
		Subscribernumber = subscribernumber;
	}

	public long getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public int getSubscribernumber() {
		return Subscribernumber;
	}

	public void setSubscribernumber(int subscribernumber) {
		Subscribernumber = subscribernumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Id == other.Id;
	}

	
	
	
}
