package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.Customer;

public interface ICustomerService {


	List<Customer> getAllCustomers();
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer removeCustomer(Customer customer);
	Customer viewCustomer(Customer customer);
}
