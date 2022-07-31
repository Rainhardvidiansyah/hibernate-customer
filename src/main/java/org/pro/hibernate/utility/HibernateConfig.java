package org.pro.hibernate.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.pro.hibernate.entity.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HibernateConfig {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistryBuilder registryBuilder
                        = new StandardServiceRegistryBuilder();
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/customer_management?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "maulida1010");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                registryBuilder.applySettings(settings);
                standardServiceRegistry = registryBuilder.build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.buildSessionFactory();

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Customer.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
