package com.kgisl.sb2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.sb2.model.Customer;
import com.kgisl.sb2.repositary.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    public CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(int id) {
        customerRepository.findById(id);
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }

    @Override
    public Customer createCustomer(Customer c1) {
        Customer c = new Customer();
        c.setId(1);
        c.setFirstname("jo");
        c.setLastname("R");
        c.setEmail("jo.r@gmail.com");
        c.getId();
        c.getFirstname();
        c.getLastname();
        c.getEmail();
        c1 = c;
        return customerRepository.save(c1);
    }

    @Override
    public Customer updatCustomer(int id, Customer currentUser) {
        Optional<Customer> cus = customerRepository.findById(id);
        Customer customer = cus.get();
        Customer c = new Customer();
        c.setId(1);
        c.setFirstname("jothika");
        c.setLastname("R");
        c.setEmail("jothika.r@gmail.com");
        c.getId();
        c.getFirstname();
        c.getLastname();
        c.getEmail();
        currentUser = c;
        System.out.println(customer);
        customer.setId(currentUser.getId());
        customer.setEmail(currentUser.getEmail());
        customer.setFirstname(currentUser.getFirstname());
        customer.setLastname(currentUser.getLastname());
        customerRepository.save(customer);
        return customerRepository.save(customer);

    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }

}