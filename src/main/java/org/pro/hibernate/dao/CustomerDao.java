package org.pro.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.pro.hibernate.entity.Customer;
import org.pro.hibernate.utility.HibernateConfig;

import java.util.UUID;

public class CustomerDao {

    public static void saveCustomer(Customer customer){
        customer.setId(UUID.randomUUID().toString());
        Transaction tr = null;
        try(Session session = HibernateConfig.getSessionFactory().openSession()){

            tr = session.beginTransaction();
            session.save(customer);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(tr != null){
                tr.rollback();
            }

        }

    }


}
