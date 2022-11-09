package com.kgisl.sb2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.sb2.model.Customer;
import com.kgisl.sb2.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",headers = "Accept=application/json")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
        Customer c = customerService.findCustomerById(id);
        if (c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",headers = "Accept=application/json")
    public ResponseEntity<Customer> deleteCustomersById(@PathVariable("id") int id) {
        Customer cust = customerService.findCustomerById(id);
        if (cust == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping(value = "/{id}",headers = "Accept=application/json")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable("id") long id, @RequestBody Customer currentUser) {
        Customer customer = customerService.updatCustomer((int) id, currentUser);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Customer> createTeam(@RequestBody Customer customer) {
        Customer actualCustomer = customerService.createCustomer(customer);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(actualCustomer, headers, HttpStatus.CREATED);
    }

}