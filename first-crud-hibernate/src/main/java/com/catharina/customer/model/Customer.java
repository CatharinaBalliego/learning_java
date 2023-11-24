package com.catharina.customer.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="customer_tb")
public class Customer {
	
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="customer_name")
	private String name;
	
	@ManyToOne 
	@JoinColumn(name="customer_type_id")
	private CustomerType customerType;
	
	@Column(name="company_code")
	private Integer companyCode;

	@Column(name="register_dt")
	private Date registerDate;
	
	@Column(name="modification_dt")
	private Date modificationDate;

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

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", customerType=" + customerType + ", companyCode="
				+ companyCode + ", registerDate=" + registerDate + ", modificationDate=" + modificationDate + "]";
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	
	
}
