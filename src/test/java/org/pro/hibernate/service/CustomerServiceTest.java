package org.pro.hibernate.service;

import org.junit.jupiter.api.Test;
import org.pro.hibernate.entity.Customer;
import org.pro.hibernate.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerServiceTest {

    private CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService = new CustomerService(customerRepository);

//    public CustomerServiceTest(CustomerService customerService) {
//        this.customerService = customerService;
//    }

    private String id = UUID.randomUUID().toString();

    @Test
    void saveCustomer(){
        Customer customer = new Customer
                (id, "Rainhard", "myemail@gmail.com", "pass");
        Customer savedCustomer = customerService.saveCustomer(customer);
        System.out.println(savedCustomer);
    }

    @Test
    void sayHallo() {
        String s = customerService.sayHallo("Rainhard");
        System.out.println(s);
    }

    @Test
    void saveManyCustomers() {
        Customer customer1 =
                new Customer(UUID.randomUUID().toString(), "Hoki", "hoki@gmail.com", "cat");
        Customer customer2 = new Customer(UUID.randomUUID().toString(), "Yupi", "yupi@gmail.com", "cat");
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        List<Customer> savedCustomers = customerService.saveManyCustomers(customers);
        System.out.println(savedCustomers);
    }
}
