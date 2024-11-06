package com.yrgo.client;

import com.yrgo.domain.Customer;
import com.yrgo.services.customers.CustomerManagementService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SimpleClient {

    public static void main(String[] args) {
        // Container that accepts application.xml as argument
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        // Get the CustomerManagementService bean
        CustomerManagementService customerService = (CustomerManagementService) context.getBean("customerManagementService");

        // Adding new customer
        Customer newCustomer = new Customer("DF45", "Cupido Ltd", "Initial notes");
        customerService.newCustomer(newCustomer);

        // Retrieve and print all customers
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Customer Company: " + customer.getCompanyName());
            System.out.println("Customer Notes: " + customer.getNotes());
            System.out.println();
        }
    }
}
