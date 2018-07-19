package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long companyID;
    private String company;

    @OneToMany(mappedBy = "company",
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    public Set<Customers> customers;


    public long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(long companyID) {
        companyID = companyID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        company = company;
    }

    public Set<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customers> customers) {
        this.customers = customers;
    }
}
