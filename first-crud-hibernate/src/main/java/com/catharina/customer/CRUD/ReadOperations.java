package com.catharina.customer.CRUD;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.catharina.customer.model.Customer;
import com.catharina.customer.model.CustomerType;

public abstract class ReadOperations {

	public static void getAllCustomers(EntityManager entityManager) {
		String jpql = "select c from Customer c";
		TypedQuery<Customer> typedQuery = entityManager.createQuery(jpql, Customer.class);
		List<Customer> customers = typedQuery.getResultList();
		customers.forEach(c -> System.out.println(c));
	}
	
	
	public static void getCustomerTypeFromCustomer(EntityManager entityManager) {
		String jpql = "select c.customerType from Customer c where c.id = 1";
		TypedQuery<CustomerType> typedQuery  = entityManager.createQuery(jpql, CustomerType.class);
		CustomerType customerType = typedQuery.getSingleResult();
		System.out.println(customerType);
	}
	
	public static void getCustomersName(EntityManager entityManager) {
		String jpql = "select c.name from Customer c";
		TypedQuery<String> typedQuery = entityManager.createQuery(jpql, String.class);
		List<String> cName = typedQuery.getResultList();
		cName.forEach(c -> System.out.println(c));
	}
	
	public static void getCustomersCustomColumns(EntityManager entityManager) {
		String jpql = "select name, customerType from Customer";
		TypedQuery<Object []> typedQuery = entityManager.createQuery(jpql, Object[].class);
		List<Object []> customAtt = typedQuery.getResultList();
		customAtt.forEach(c -> System.out.println(String.format("%s, %s", c)));
	}
	
}
