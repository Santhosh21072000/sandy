package com.kgisl.sb2.service;

import java.util.List;

import com.kgisl.sb2.model.Customer;

public interface CustomerService {
    public List<Customer> getAll();
    public Customer findCustomerById(int id);
    public Customer createCustomer(Customer c);
    public Customer updatCustomer(int id,Customer currentUser);
    public void deleteCustomerById(int id);
}
