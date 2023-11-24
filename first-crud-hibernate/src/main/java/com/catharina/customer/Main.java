package com.catharina.customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.catharina.customer.CRUD.ReadOperations;
import com.catharina.customer.model.Customer;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Customers-PU");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//reading data
		Customer customer = entityManager.find(Customer.class, 1);
		System.out.println(customer.getName());
		
		System.out.println("all customers");
		ReadOperations.getAllCustomers(entityManager);

		System.out.println("customers' name");
		ReadOperations.getCustomersName(entityManager);
		
		System.out.println("get customerType single result");
		ReadOperations.getCustomerTypeFromCustomer(entityManager);
		
		System.out.println("custom columns");
		ReadOperations.getCustomersCustomColumns(entityManager);
		//insert
//		Customer amazon = new Customer();
//		amazon.setName("Amazon");
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(amazon);
//		entityManager.getTransaction().commit();
		
		//delete
//		Customer amazon = entityManager.find(Customer.class, 4);
//		
//		entityManager.getTransaction().begin();
//		entityManager.remove(amazon);
//		entityManager.getTransaction().commit();
			
		
		//update
//		Customer federzoni = entityManager.find(Customer.class, 1);
//		federzoni.setName(federzoni.getName() + " BR");
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(federzoni);
//		entityManager .getTransaction().commit();
//		
		entityManager.close();
		entityManagerFactory.close();

	}

}
