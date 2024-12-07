package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        
        // Insert records
        insertClient(new Client("John Doe", "Male", 30, "New York", "john@example.com", "1234567890"));
        insertClient(new Client("Jane Smith", "Female", 25, "Los Angeles", "jane@example.com", "0987654321"));

        // Print all records
        printAllClients();

        // Print partial records
        printPartialClients();
        
        sessionFactory.close();
    }

    private static void insertClient(Client client) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    private static void printAllClients() {
        try (Session session = sessionFactory.openSession()) {
            List<Client> clients = session.createQuery("from Client", Client.class).list();
            for (Client client : clients) {
                System.out.println(client);
            }
        }
    }

    private static void printPartialClients() {
        try (Session session = sessionFactory.openSession()) {
            List<Client> clients = session.createQuery("select new com.klef.jfsd.exam.Client(c.name, c.gender, c.age, c.location, c.emailAddress, c.mobileNumber) from Client c", Client.class).list();
            for (Client client : clients) {
                System.out.println("Name: " + client.getName() + ", Age: " + client.getAge());
            }
        }
    }
}
