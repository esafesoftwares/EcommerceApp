package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Accounts;
import com.ecommerce.model.Customer;
import com.ecommerce.model.OrderDetails;
import com.ecommerce.model.Product;

@Repository
@Transactional

public class CustomerDao {
	

	    @Autowired
	    private SessionFactory sessionFactory;

	    public void addProduct(Customer cust) {
	        Session session = sessionFactory.getCurrentSession();
	        session.save(cust);
	        session.flush();
	    }

	   public List<Product> getorde(Customer cust) {
		   Session session = sessionFactory.getCurrentSession();
	        Query query=session.createQuery("select  product from OrderDetails where phoneNumber=?");
	        Query query1=session.createQuery("select orderId from OrderDetails where phoneNumber=?");
	        query1.setParameter(0,cust.getPhoneNumber());

	        query.setParameter(0,cust.getPhoneNumber());
	        System.out.println(cust.getPhoneNumber());
	        //query.executeUpdate();
	        List<Product> products = query.list();
	       System.out.println(query.list());
	        session.flush();

	        return products;
	   }
	   public void getOrderId(Customer cust)
	   {
		   Session session = sessionFactory.getCurrentSession();
	        Query query1=session.createQuery("select orderId from OrderDetails where phoneNumber=?");
	        query1.setParameter(0,cust.getPhoneNumber());
	        System.out.println(query1);
	   }

	    public List<Customer> getAllProducts() {
	        Session session = sessionFactory.getCurrentSession();
	        Query query = session.createQuery("from Customer");
	        List<Customer> products = query.list();
	        session.flush();

	        return products;
	    }

	    
	    public void editProduct (Customer cust) {
	        Session session = sessionFactory.getCurrentSession();
	       // System.out.println(product.getProductId());

	        Query q=session.createQuery(
	      "update Customer set userName=?,"
	      + "password=?,"
	      + "customerName=?,"
	      + "customerEmail=?,"
	     
	      + "where phoneNumber=?"
	        		);
	        q.setParameter(0,cust.getUserName());
	        q.setParameter(1,cust.getPassword());
	        q.setParameter(2,cust.getCustomerName());
	        q.setParameter(3,cust.getCustomerEmail());
	        q.setParameter(4,cust.getPhoneNumber());
	        
	        q.executeUpdate();
	        
	        session.flush();
	    }

	    public Customer findCustomer(String phoneNumber ) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Customer.class);
	        crit.add(Restrictions.eq("phoneNumber", phoneNumber));
	        return (Customer) crit.uniqueResult();
	    }
	    
	}


