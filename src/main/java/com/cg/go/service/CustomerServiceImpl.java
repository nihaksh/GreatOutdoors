package com.cg.go.service;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.cg.go.dao.CustomerRepositoryImpl;
import com.cg.go.dao.ICustomerRepository;
import com.cg.go.entity.Customer;

import util.JpaUtil;

public class CustomerServiceImpl implements ICustomerService{

    private EntityManager entityManager;

    private ICustomerRepository customerRepository;

    public CustomerServiceImpl(){
        entityManager=JpaUtil.getInstance().getEntityManager();
        this.customerRepository=new CustomerRepositoryImpl(entityManager);
    }

    public CustomerServiceImpl(EntityManager entityManager){
        this.entityManager=entityManager;
        this.customerRepository=new CustomerRepositoryImpl(entityManager);
    }

    @Override
	public List<Customer> getAllCustomers(){
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<Customer> list=new ArrayList<Customer>();
		list=customerRepository.getAllCustomers();
        transaction.commit();
        return list;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customerObject=customerRepository.addCustomer(customer);
        transaction.commit();
        return customerObject;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customerObject=customerRepository.updateCustomer(customer);
        transaction.commit();
        return customerObject;
	}

    @Override
	public Customer removeCustomer(Customer customer) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customerObject=customerRepository.removeCustomer(customer);
        transaction.commit();
        return customerObject;
	}

  @Override
	public Customer viewCustomer(Customer customer) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customerObject=customerRepository.viewCustomer(customer);
        transaction.commit();
		return customerObject;
	}
}
