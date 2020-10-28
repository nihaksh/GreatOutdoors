package com.cg.go.dao;
import java.util.*;
import javax.persistence.EntityManager;
import com.cg.go.entity.Customer;
public class CustomerRepositoryImpl implements ICustomerRepository{

	private EntityManager entityManager;
	
	public CustomerRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> list=new ArrayList<Customer>();
		list=entityManager.createQuery("from Customer",Customer.class).getResultList();
		return list;
	}
	
	public Customer addCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}
	
	public Customer updateCustomer(Customer customer) {
		entityManager.merge(customer);
		return customer;
	}
	
	public Customer removeCustomer(Customer customer) {
		entityManager.remove(customer);
		return null;
	}
	
	public Customer viewCustomer(Customer customer) {
		Customer customerObject=entityManager.find(Customer.class,customer.getCustomerId());
		return customerObject;
	}
}