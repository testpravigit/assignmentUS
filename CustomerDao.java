package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mod.Customer;
import com.so.Dto.Student;
@Repository
public class CustomerDao {

	@Autowired
	HibernateTemplate hTemplate;
	
	@PersistenceContext
	private EntityManager entityManager;
	//SAVE CUSTOMER
	@Transactional
	public int saveCustomer(Customer customer) {
		int save = (Integer)this.hTemplate.save(customer);
		return save;
	}
	
	//GET ALL CUSTOMER
	public List<Customer> getAll() {
		List<Customer> c = hTemplate.loadAll(Customer.class);
		
		return c;
	}
	
	//DELETE CUSTOMER
	@Transactional
	public void deleteCustomer(int id) {
		Customer load = this.hTemplate.load(Customer.class, id);
		this.hTemplate.delete(load);
		
	}
	
	//GET SINGLE CUSTOMER
	public Customer getSingleCustomer(int id) {
		Customer load = this.hTemplate.get(Customer.class,id);
		System.out.println(load);
		return load;
		
	}
	
	//UPDATE CUSTOMER
	@Transactional
	public void updateCustomer(Customer c) {
		
		this.hTemplate.update(c);
	}
	@Transactional
	public List<Customer> findCustomersWithSomeCondition(String name) {
		String queryName = "Customer.findByFirstName";
       
        return entityManager.createNamedQuery(queryName, Customer.class)
	            .setParameter("name", name)
	            .getResultList();
	
    }
	
	
	
	@Transactional
	public List<Customer> findCustomersWithSomeCondition1(String city) {
		String queryName = "Customer.findByCity";
       
        return entityManager.createNamedQuery(queryName, Customer.class)
	            .setParameter("city", city)
	            .getResultList();
	
    }
	
	
	
	
}
