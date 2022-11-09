package com.kgisl.san1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.san1.entity.Book;

@Repository
public interface BookRepository extends JpaRepository <Book,Integer>{
    
}
