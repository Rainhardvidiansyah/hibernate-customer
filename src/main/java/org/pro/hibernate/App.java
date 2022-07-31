package org.pro.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.pro.hibernate.dao.CustomerDao;
import org.pro.hibernate.entity.Customer;


public class App {


    public static void main( String[] args ) {
        Customer customer = new Customer("Yupi", "yupi@gmail.com",
                "yupicat");
        CustomerDao.saveCustomer(customer);
        System.out.println(customer.getId());






    }
}
