package org.pro.hibernate.service;

import org.pro.hibernate.entity.Customer;
import org.pro.hibernate.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
//        Customer customer1 = new Customer();
//        customer1.setId(UUID.randomUUID().toString());
//        customer1.setName(customer.getName());
//        customer1.setEmail(customer.getEmail());
//        customer1.setPassword(customer.getPassword());
        return customer;
    }

    public String sayHallo(String s){
        return s;
    }

    public List<Customer> saveManyCustomers(List<Customer> customersObj){
        List<Customer> customers = new ArrayList<>();
        customers.addAll(customersObj);
        return customers;
    }
}
