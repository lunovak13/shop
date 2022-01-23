package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }


    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }


    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    public void updateCustomer(Long id, Customer customer) {
        customerRepository.save(customer);
    }


    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
