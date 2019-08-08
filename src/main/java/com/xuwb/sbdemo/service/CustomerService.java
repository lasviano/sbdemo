package com.xuwb.sbdemo.service;

import com.xuwb.sbdemo.domain.Customer;

import java.util.List;

public interface CustomerService {
    public void save(Customer customer);

    public List<Customer> findAll();

    public Customer findById(Integer id);

    public void delete(Integer id);
}
