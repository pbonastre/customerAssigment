package com.springFramework.CustomerAssigment.bootstrap;

import com.springFramework.CustomerAssigment.domain.Customer;
import com.springFramework.CustomerAssigment.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadCustomer();
    }

    public void loadCustomer(){
        Customer customer1 = new Customer();
        customer1.setFirstName("Micheal");
        customer1.setLastName("Weston");
        customer1.setAddressLineOne("1 Main St");
        customer1.setCity("Miami");
        customer1.setZipCode("33101");
        customer1.setEmail("micheal@burnnotice.com");
        customer1.setPhoneNumber("305.333.0101");
        customerService.saveOrUpdateCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Fiona");
        customer2.setLastName("Glenanne");
        customer2.setAddressLineOne("1 Key Biscane Ave");
        customer2.setCity("Miami");
        customer2.setZipCode("33101");
        customer2.setEmail("fiona@burnnotice.com");
        customer2.setPhoneNumber("305.323.0233");
        customerService.saveOrUpdateCustomer(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Sam");
        customer3.setLastName("Axe");
        customer3.setAddressLineOne("1 Little Cuba Road");
        customer3.setCity("Miami");
        customer3.setZipCode("33101");
        customer3.setEmail("sam@burnnotice.com");
        customer3.setPhoneNumber("305.426.9832");
        customerService.saveOrUpdateCustomer(customer3);
    }

}
