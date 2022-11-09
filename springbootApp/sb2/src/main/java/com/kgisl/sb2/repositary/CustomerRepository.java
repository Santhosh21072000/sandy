package com.kgisl.sb2.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.sb2.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    
}