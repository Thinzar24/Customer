package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customers,Long> {
    List<Customers> findByLastnameIgnoreCase(String search);
    List<Customers> findByCityIgnoreCase(String search);
    List<Customers> findAll();

}
