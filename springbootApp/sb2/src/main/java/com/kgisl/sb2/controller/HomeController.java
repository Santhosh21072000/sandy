package com.kgisl.sb2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb2.model.Customer;



@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")
    public List<Customer> welcomIndex(){
        List<Customer> customer = new ArrayList<Customer>();
        Customer c=new Customer();
        c.setId(1);
        c.setFirstname("jothika");
        c.setLastname("R");
        c.setEmail("jo.r@gmail.com");
        c.getId();
        c.getFirstname();
        c.getLastname();
        c.getEmail();
        customer.add(c);
        return customer;
    }
}
