package com.example.customerapp.service;

import com.example.customerapp.entity.Customer;
import com.example.customerapp.repo.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> findAll() {
        return repo.findAll();
    }

    public Customer findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found: " + id));
    }

    public Customer save(Customer customer) {
        return repo.save(customer);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
