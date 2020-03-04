package com.springFramework.CustomerAssigment.services;

import com.springFramework.CustomerAssigment.domain.Customer;
import java.util.List;

public interface CustomerService {

    List<Customer> listAllCustomers();

     Customer getCustomerById(Integer id);

     Customer saveOrUpdateCustomer(Customer customer);

     void deleteCustomer(Integer id);
}
