package com.catharina.customer.CRUD;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	
	public static void findById(EntityManager entityManager, Integer id) {
		String jpql = "select c from Customer c where c.id = :id";
		TypedQuery<Customer> typedQuery = entityManager.createQuery(jpql, Customer.class);
		typedQuery.setParameter("id", id);
		Customer customer = typedQuery.getSingleResult();
		System.out.println(customer);
		
	}
	

	
	//inner join
	public static void findByCustomerTypeId(EntityManager entityManager, Integer id) {
		String jpql = "select c from Customer c join c.customerType ct where ct.id = :id";
		TypedQuery<Customer> typedQuery = entityManager.createQuery(jpql, Customer.class);
		typedQuery.setParameter("id", id);
		List<Customer> customer = typedQuery.getResultList();
		customer.stream().forEach(System.out::println);
		
		
	}
	
	//filtering results
	
	
	//like
	public static void findByName(EntityManager entityManager, String name) {
		String jpql = "select c from Customer c where c.name like concat(:cname, '%')"; //starts with
		TypedQuery<Customer> typedQuery = entityManager.createQuery(jpql, Customer.class);
		typedQuery.setParameter("cname", name);
		List<Customer> customers = typedQuery.getResultList();
		customers.stream().forEach(System.out::println);
	}
	
	//between
	
	public static void registerBetween(EntityManager entityManager) {
		String jpql = "select c from Customer c where c.registerDate between :yesterday and :today";
		TypedQuery<Customer> typedQuery = entityManager.createQuery(jpql, Customer.class);
		typedQuery.setParameter("yesterday", LocalDateTime.now().minusDays(1));
		typedQuery.setParameter("today", LocalDateTime.now());
		List<Customer> customers = typedQuery.getResultList();
		customers.stream().forEach(System.out::println);
	}
	
	//in
	public static void findByListId(EntityManager entityManager, List<Integer> ids) {
		String jpql = "select c from Customer c where c.id in (:ids)";
		TypedQuery<Customer> typedQuery = entityManager.createQuery(jpql, Customer.class);
		typedQuery.setParameter("ids", ids);
		List<Customer> customers = typedQuery.getResultList();
		customers.stream().forEach(System.out::println);
		
	}
	
	//pagination
	
	public static void pagination(EntityManager entityManager, int startIndex, int maxResults) {
		String jpql = "select c from Customer c";
		TypedQuery<Customer> tq = entityManager.createQuery(jpql, Customer.class)
				.setFirstResult(startIndex)
				.setMaxResults(maxResults);
		tq.getResultList().stream().forEach(System.out::println);;
		
	}
	
	
	
	// ----------------------------- CRITERIA ------------------------------------------------
	
	/* Advantages:
	 * No query knowledge is necessary
	 * more performatic than JPQL. No casting neeeded.
	 */
	
	public static void criteria(EntityManager entityManager) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = criteriaQuery.from(Customer.class);
		
		criteriaQuery.select(root);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));
		
		TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Customer> customers = typedQuery.getResultList();
		customers.forEach(System.out::println);
	}
	
	public static void criteriaChooseReturnType(EntityManager entityManager) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomerType> cq = cb.createQuery(CustomerType.class);
		Root<Customer> root = cq.from(Customer.class);
		cq.select(root.get("customerType"));
		
		TypedQuery<CustomerType> typedQuery = entityManager.createQuery(cq);
		List<CustomerType> ct = typedQuery.getResultList();
		ct.forEach(System.out::println);
		
	}
	
	public static void criteriaGetById(EntityManager entityManager, int Id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class);
		cq.select(root);
		cq.where(cb.equal(root.get("id"), Id));
		
		TypedQuery<Customer> typedQuery = entityManager.createQuery(cq);
		Customer customer = typedQuery.getSingleResult();
		System.out.println(customer);
	}
}
