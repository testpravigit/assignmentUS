package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.mod.Customer;
import com.service.CustomerService;

@Controller
public class MainController {
	@Autowired
	CustomerService customerService;
	//login handler form
	@RequestMapping("/")
	public String Login() {
		
		
		return "login";
	}
	//login handler
	@RequestMapping("/loginHandler")
	public RedirectView loginHand(@RequestParam("uname") String name,@RequestParam("password") String pass,HttpServletRequest req) {
		RedirectView redirectView = new RedirectView();
		if(name.equals("test@sunbase.com")&&pass.equals("Test@123")) {
			
			redirectView.setUrl(req.getContextPath()+"/home");
			return redirectView ;
			
		}
		redirectView.setUrl(req.getContextPath()+"/failed");
		return redirectView ;
		
		
	}
	@RequestMapping("/failed")
	public String failed() {
		
		return "failed";
	}
	
	//HOME
	@RequestMapping("/home")
	public String home(Model m) {
		List<Customer> user = customerService.getUser();
		m.addAttribute("m",user);
		
		
		
		return "home";
	}
	
    //show add customer form
	@RequestMapping("/addC")
	public String addCustomer() {
		
		return "add";
	}
	
	//handle add customer 
	@RequestMapping("/addCustomer")
	public RedirectView addUser(@ModelAttribute Customer customer,HttpServletRequest req) {
		this.customerService.createUser(customer);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/home");
		return redirectView ;
	}
	
	//delete hamdler
	@RequestMapping("/deleteCustomer/{id}")
	public RedirectView deleteUser(@PathVariable("id") int id,  HttpServletRequest req) {
		this.customerService.deleteUser(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/home");
		
		return redirectView;
	}
	//update handler form
	@RequestMapping("/updatedCustomer/{id}")
	public String updateCustomer(@PathVariable("id") int id,Model m) {
		Customer singleUser = this.customerService.getSingleUser(id);
		m.addAttribute("cus", singleUser);
		System.out.println("updated called");
		
		return "update";
	}
	//update handler
	@RequestMapping("/up")
	public RedirectView updateUser(@ModelAttribute Customer customer,  HttpServletRequest req) {
//		Customer singleUser = this.customerService.getSingleUser(id);
		System.out.println("up called");
		this.customerService.updateUser(customer);
		System.out.println("up 1 called");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath()+"/home");
		
		return redirectView;
	} 
	//SEARCH NY NAME HANDLER
	@RequestMapping("/byName")
	public String getByName(@RequestParam("name") String name,Model m) {
		List<Customer> byName = this.customerService.getByName(name);
		m.addAttribute("name",byName);
		
		return "byname";
		
	}
	//SEARCH NY NAME HANDLER FORM
	@RequestMapping("/Bname")
	public String getBname(Model m) {
		List<Customer> user = customerService.getUser();
		m.addAttribute("m",user);
		
		return "bname";
		
	}
	
	//SEARCH BY CITY HANDLER
		@RequestMapping("/byCity")
		public String getByCity(@RequestParam("city") String city,Model m) {
			List<Customer> byName = this.customerService.getByCity(city);
			m.addAttribute("name",byName);
			
			return "bycity";
			
		}
		
		//SEARCH NY CITY HANDLER FORM
		@RequestMapping("/Bcity")
		public String getCname(Model m) {
			List<Customer> user = customerService.getUser();
			m.addAttribute("m",user);
			
			return "bcity";
			
		}
	
	
	
	
	
}
