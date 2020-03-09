package com.ecommerce.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.OrderDetails;

@Repository
@Transactional
public class OrderDetailsDao {
	@Autowired
    private SessionFactory sessionFactory;
	 public void addCustomerDetails(OrderDetails order) {
	        Session session = sessionFactory.getCurrentSession();
	       
	        session.persist(order);
	        session.flush();
	    }


}
