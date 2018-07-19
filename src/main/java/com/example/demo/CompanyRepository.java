package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    @Query("from Company where count(customer)>10")
    List<Company> findByEmpeeCount();
}
