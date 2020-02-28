package com.springFramework.CustomerAssigment.services;

import com.springFramework.CustomerAssigment.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer,Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }


    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id){
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if(customer != null){
            if(customer.getId() == null){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);
            return customer;
        }else{
            throw new RuntimeException("Customer can't be nill");
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
        customers.remove(id);
    }

    private int getNextKey() {
        return Collections.max(customers.keySet())+1;
    }


    private void loadCustomers(){
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Juan");
        customer1.setLastName("Andreu");
        customer1.setAddressLineOne("Calle Belgica 2");
        customer1.setCity("Valencia");
        customer1.setEmail("juan.andreu@gmail.com");
        customer1.setPhoneNumber("658235687");
        customer1.setZipCode("46021");


        customers.put(1, customer1);
        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Laura");
        customer2.setLastName("Bueno");
        customer2.setAddressLineOne("Calle Eolo 2");
        customer2.setCity("Valencia");
        customer2.setEmail("laura.b@gmail.com");
        customer2.setPhoneNumber("658232545");
        customer2.setZipCode("46001");


        customers.put(2, customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Manuel");
        customer3.setLastName("Polop");
        customer3.setAddressLineOne("Calle alquimista 2");
        customer3.setCity("Valencia");
        customer3.setEmail("manuel.polo@gmail.com");
        customer3.setPhoneNumber("658754123");
        customer3.setZipCode("46021");


        customers.put(3, customer3);
     }
}
