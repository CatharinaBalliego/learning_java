package com.catharina.customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.catharina.customer.model.Customer;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Customers-PU");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
	
		Customer customer = entityManager.find(Customer.class, 1);
		System.out.println(customer.getName());
		
		
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
