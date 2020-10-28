
package com.cg.go.dao;

import java.util.List;

import com.cg.go.entity.Customer;

public interface ICustomerRepository {

	public List<Customer> getAllCustomers();
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(Customer customer);
	public Customer viewCustomer(Customer customer);

}
