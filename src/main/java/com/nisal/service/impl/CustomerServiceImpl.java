package com.nisal.service.impl;

import com.nisal.model.Customer;
import com.nisal.repository.CustomerRepository;
import com.nisal.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
//        customer.setCreatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) throws Exception {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(
                () -> new Exception("Customer not found")
        );
        customerToUpdate.setFullName(customer.getFullName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhone(customer.getPhone());
//        customerToUpdate.setUpdatedAt(LocalDateTime.now());
        return customerRepository.save(customerToUpdate);
    }

    @Override
    public void deleteCustomer(Long id) throws Exception {
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(
                () -> new Exception("Customer not found")
        );
        customerRepository.delete(customerToUpdate);
    }

    @Override
    public Customer getCustomer(Long id) throws Exception {
        return customerRepository.findById(id).orElseThrow(
                () -> new Exception("Customer not found")
        );
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> searchCustomer(String keyword) throws Exception {
        return customerRepository.findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                keyword, keyword
        );
    }
}
