package com.test;



import java.util.ArrayList;
import java.util.List;
import com.cg.go.entity.Address;
import com.cg.go.entity.Customer;
import com.cg.go.service.CustomerServiceImpl;
import com.cg.go.service.ICustomerService;

public class CustomerTest {

	public static void main(String[] args) {
		
		Address address=new Address(11,6,"bankcolony", "wgl", "wgl","Telangana",506002);
		Customer customer1=new Customer(10,"naresh","8179563708","thon@gmail.com",address,"retailer");
		Customer customer2=new Customer(11,"arvind","xxxxxxxxxx","arvi@gmail.com",address,"sales");
		ICustomerService customerService=new CustomerServiceImpl();
		customerService.addCustomer(customer1);
		customerService.addCustomer(customer2);
		customerService.updateCustomer(customer2);
		List<Customer> list=new ArrayList<Customer>();
		customerService.removeCustomer(customer1);
		list=customerService.getAllCustomers();
		//Customer customer3=list.get(0);
		//Customer customer4=list.get(1);
		
		//Customer customer=customerService.viewCustomer(customer2);
		System.out.println(list);

	}

}
