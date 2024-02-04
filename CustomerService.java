package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.mod.Customer;


@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	public int createUser(Customer customer) {
		return this.customerDao.saveCustomer(customer);
		
	}
	public List<Customer> getUser(){
		return this.customerDao.getAll();
	}
	public void deleteUser(int id) {
		
		 this.customerDao.deleteCustomer(id);
	}
	
	public void updateUser(Customer c) {
		this.customerDao.updateCustomer(c);
	}
	public Customer getSingleUser(int id) {
		return this.customerDao.getSingleCustomer(id);
	}
   public List<Customer> getByName(String name){
	   return this.customerDao.findCustomersWithSomeCondition(name);
	   
   }
   public List<Customer> getByCity(String city){
	   return this.customerDao.findCustomersWithSomeCondition1(city);
	   
   }
   
  
}
