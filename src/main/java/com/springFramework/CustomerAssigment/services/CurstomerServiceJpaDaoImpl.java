package com.springFramework.CustomerAssigment.services;

import com.springFramework.CustomerAssigment.domain.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
@Service
@Profile("jpadao")
public class CurstomerServiceJpaDaoImpl  implements  CustomerService{


    private EntityManagerFactory emf;
    @PersistenceUnit //inject de entity manager factory
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<Customer> listAllCustomers() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    //transactional
    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer savedCustomer = em.merge(customer);
        em.getTransaction().commit();
        return savedCustomer;
    }

    @Override
    public void deleteCustomer(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class,id));
        em.getTransaction().commit();

    }
}
