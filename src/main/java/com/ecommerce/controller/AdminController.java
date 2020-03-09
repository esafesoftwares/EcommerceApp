package com.ecommerce.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import com.ecommerce.dao.AccountDao;
import com.ecommerce.model.Accounts;

@ComponentScan(value="com.ecommerce.dao")
@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class AdminController {
	@Autowired
    private AccountDao accountDao;
 
      // GET: Show Login Page
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(Model model) {
    	Accounts pro = new Accounts();
        model.addAttribute("product1",pro);
        return "login";
    }
	
 
    @RequestMapping(value = { "/accountInfo" }, method = RequestMethod.GET)
    public String accountInfo(Model model) {
 
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getPassword());
        System.out.println(userDetails.getUsername());
        System.out.println(userDetails.isEnabled());
 
        model.addAttribute("userDetails", userDetails);
        return "accountInfo";
    }
    @RequestMapping(value = { "/403" }, method = RequestMethod.GET)
    public String accessInfo() {
    	return"/403";
    }
    @RequestMapping(value = { "/addAccount" }, method = RequestMethod.GET)
    public String createAccount(Model model) {
    	Accounts acc = new Accounts();
        model.addAttribute("account1",acc);
        return "addAccount";
    }
    @RequestMapping(value = { "/addAccount" }, method = RequestMethod.POST)
    public String saveAccount( @Valid @ModelAttribute("account1") Accounts acc ,BindingResult br)throws IOException{
    	
    		if(br.hasFieldErrors())
    		{
    			return "addAccount";
    		}
    	 
    	
        accountDao.addAccount(acc);
        
    	
        return "redirect:/productList";
    }
 
}
