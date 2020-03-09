package com.ecommerce.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ecommerce.dao.CustomerDao;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Product;

@Controller
@EnableWebMvc
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;
	@RequestMapping( "/customerLogin")
    public String login(Model model) {
    	Customer cust = new Customer();
        model.addAttribute("customer1",cust);
        //customerDao.getorde(cust);
        
        return "customerLogin";
    }
	@RequestMapping(value= {"/productList1"})
	public String getProducts(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String phone=userDetails.getUsername();
		 System.out.println(userDetails.getPassword());
	        System.out.println(userDetails.getUsername());
		System.out.println(phone);
	   Customer cust1=customerDao.findCustomer(phone);
		List<Product> products = customerDao.getorde(cust1);
	   model.addAttribute("products", products);
	   customerDao.getOrderId(cust1);
	    return "myOrders";
	}
	@RequestMapping(value = { "/accountInfo1" }, method = RequestMethod.GET)
    public String accountInfo(Model model) {
 
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getUsername());
       
 
        model.addAttribute("userDetails", userDetails);
        return "accountInfo";
    }
	@RequestMapping(value = { "/customerRegistrationPage" }, method = RequestMethod.GET)
    public String Registration(Model model) {
    	Customer pro = new Customer();
        model.addAttribute("customer1",pro);
        
        return "customerRegistrationPage";
	}
	@RequestMapping(value = { "/customerRegistrationPage1" }, method = RequestMethod.POST)
    public String saveAccount( @Valid @ModelAttribute("customer1") Customer pro ,BindingResult br)throws IOException{
    	
    		if(br.hasFieldErrors())
    		{
    			return "customerRegistrationPage";
    		}
    	 
    	
        customerDao.addProduct(pro);
       
    	
        return "redirect:/customerLogin";
    }
 

}
