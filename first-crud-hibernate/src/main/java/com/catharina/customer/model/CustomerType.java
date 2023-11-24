package com.catharina.customer.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "customer_type_tb")
public class CustomerType {
	
	@Id
	@Column(name = "customer_type_id")
	private Integer id;
	
	@Column(name = "customer_type_name")
	private String name;
	
	@OneToMany(mappedBy = "customerType")
	private List<Customer> customers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "CustomerType [id=" + id + ", name=" + name + "]";
	}



	

}
