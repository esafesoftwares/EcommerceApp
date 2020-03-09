
	package com.ecommerce.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.ComponentScan;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseStatus;

	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import com.ecommerce.dao.CustomerDao;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.dao.OrderDetailsDao;
import com.ecommerce.dao.ProductDao;
	import com.ecommerce.model.CartItem;
import com.ecommerce.model.Customer;
import com.ecommerce.model.OrderDetails;
	import com.ecommerce.model.Orders;
	import com.ecommerce.model.Product;

	@ComponentScan(value="com.ecommerce.dao")
	@Controller
	@RequestMapping(value = "cart")
	public class CartController {
		@Autowired
	    private ProductDao productDao;
	 
		@Autowired
		private OrderDao orderDao;
		@Autowired
		private OrderDetailsDao orderDetails;
		
		@RequestMapping(value="/buy/{productId}", method = RequestMethod.GET)
	       public String addItem(Model model,@PathVariable (value = "productId") String productId, HttpServletRequest request, HttpSession session) {
	        session = request.getSession(true);
	        System.out.println(productDao.getProductById(productId));
	        Product product = productDao.getProductById(productId);
	       
	        if (product == null) {
	            throw new IllegalArgumentException(new Exception());
	        }
	        if(product.getUnitInStock()>0)
	        {
			if (session.getAttribute("cart") == null) {
				List<CartItem> cart = new ArrayList<CartItem>();
				cart.add(new CartItem(product, 1));
				product.setUnitInStock(product.getUnitInStock()-1);
				productDao.editProduct(product);
				 session.setMaxInactiveInterval(21600);
				session.setAttribute("cart", cart);
			} else {
				List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
				int index = this.exists(productId, cart);
				if (index == -1) {
					cart.add(new CartItem(product, 1));
					product.setUnitInStock(product.getUnitInStock()-1);
					productDao.editProduct(product);
					
					} else {
					int quantity = cart.get(index).getQuantity() + 1;
					cart.get(index).setQuantity(quantity);
					product.setUnitInStock(product.getUnitInStock()-1);
					productDao.editProduct(product);
					//productDao.editProduct(product);
				}
				session.setMaxInactiveInterval(21600);
				session.setAttribute("cart", cart);
			}
			CartItem cart=new CartItem(); 
		    model.addAttribute("command",cart);
		}
	        else
	        {
	        	JOptionPane.showMessageDialog(null, "No left out Stock");	
	        }
	return "cart1";
			}
		
		
		
		
		@RequestMapping(value="/remove/{id}", method = RequestMethod.GET)
	       public String removeItem(Model model,@PathVariable (value = "id") String id, HttpServletRequest request, HttpSession session) {
	       session = request.getSession(true);
	        System.out.println(productDao.getProductById(id));
	        Product product = productDao.getProductById(id);
	        
	        

				List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
				int index = this.exists(id, cart);
				int quantity = cart.get(index).getQuantity();
				if (quantity!=1) {
					
					int quantity1 = cart.get(index).getQuantity() -1;
					cart.get(index).setQuantity(quantity1);
					product.setUnitInStock(product.getUnitInStock()+1);
					productDao.editProduct(product);
					} else {
						product.setUnitInStock(product.getUnitInStock()+1);
						productDao.editProduct(product);
						cart.remove(index);
						
				}
				session.setAttribute("cart", cart);
	        
				CartItem cart1=new CartItem(); 
			    model.addAttribute("command",cart1);
			
			
			return "cart1";
		  
	}
			
		private int exists(String id, List<CartItem> cart) {
			for (int i = 0; i < cart.size(); i++) {
				 if (cart.get(i).getProduct().getProductId().equalsIgnoreCase(id)) {
						return i;
					}
			
			}
			return -1;
		}
		@RequestMapping(value="/viewCartItems",method = RequestMethod.GET)
		public String getCartItems() {
			
		    return "cart1";
		    
		}
		
		@RequestMapping(value="customerInformation")
		public String addCustomerDetails(Model model) {
			    Orders orders = new Orders();
			    model.addAttribute("order1",orders);
			return "customerInfo";
		}
		 
		@RequestMapping(value="/submitForm",method = RequestMethod.POST)  
	    // @ModelAttribute binds form data to the object  
	    public String submitForm( @Valid @ModelAttribute("order1") Orders orders, BindingResult br,HttpServletRequest request, HttpSession session)  
	    {  
			  session = request.getSession(true);
	    	 if(br.hasErrors())  
	         {  
	             return "customerInfo";  
	         }  
	    	 else 
    		 {
    		 
	    
    		 
			List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    		 
    		 String name=(String)request.getParameter("customerName");
    		 String address=(String)request.getParameter("customerAddress");
    		 String email=(String)request.getParameter("customerEmail");
    		 String phone=(String)request.getParameter("customerPhone");
    		 System.out.println(name+address+email);
    		 Orders order=new Orders();
    		 order.setCustomerName(name);
    		 order.setCustomerEmail(email);
    		 order.setCustomerAddress(address);
    		 order.setCustomerPhone(phone);
    		 orderDao.addCustomerDetails(order);
    		 String orderId=order.getId();
    		 CustomerDao dao=new CustomerDao();
    		//Customer cust=dao.findCustomer(phone);
    		 System.out.println(orderId);
    		 for(int i=0;i<cart.size();i++)
    		 {
    			 String productId=cart.get(i).getProduct().getProductId();
    			 Product pro=productDao.getProductById(productId);
    			 System.out.println(productId);
    			 System.out.println("-------------------------------"+i);
    			if(pro.getUnitInStock()>0) 
    			{
    			 
    			 OrderDetails orderDetails1=new OrderDetails();
    			 orderDetails1.setOrderId(orderId);
    			 orderDetails1.setOrder(order);
    			 orderDetails1.setProduct(pro);
    			 orderDetails1.setProductId(productId);
    			 orderDetails1.setOrderid(new OrderDetails(productId,orderId));
    			 orderDetails1.setPrice(cart.get(i).getProduct().getProductPrice());
    			 orderDetails1.setQuantity(cart.get(i).getQuantity());
    			 orderDetails1.setPhoneNumber(phone);
    			 orderDetails. addCustomerDetails(orderDetails1);
    			}
    			else{
    				JOptionPane.showMessageDialog(null, "No left out Stock");
    			}
    			 
    			}
    		 session.removeAttribute("cart");
       		
    		
    		 
    		 }
	    	return "thanks"; 
    }
		
	}
	    
