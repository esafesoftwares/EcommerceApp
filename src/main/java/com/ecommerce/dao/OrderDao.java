package com.ecommerce.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.CartItem;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Product;

@Repository
@Transactional
public class  OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    
    
    private int getMaxOrderNum() {
        String sql = "Select max(o.orderNum) from " + Orders.class.getName() + " o ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql);
        Integer value = (Integer) query.uniqueResult();
        if (value == null) {
            return 0;
        }
        return value;
    }

    public void addCustomerDetails(Orders order) {
        Session session = sessionFactory.getCurrentSession();
        int orderNum = this.getMaxOrderNum() + 1;
        //Orders order1 = new Orders();
 
        //order.setId(UUID.randomUUID().toString());
        order.setOrderNum(orderNum);
        order.setOrderDate(new Date());
        session.save(order);
        session.flush();
    }

    public Orders getOrderById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Orders order = (Orders) session.get(Orders.class, id);
        session.flush();

        return order;
    }

    public List<Orders> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Orders");
        List<Orders> orders = query.list();
        session.flush();

        return orders;
    }

    public void deleteProduct (String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getOrderById(id));
        session.flush();
    }
    public void editProduct (Product product) {
        Session session = sessionFactory.getCurrentSession();
       // System.out.println(product.getProductId());

        Query q=session.createQuery(
      "update Product set productName=?,"
      + "productCategory=?,"
      + "productDescription=?,"
      + "productPrice=?,"
      + "productCondition=?,"
      + "productStatus=?,"
      + "unitInStock=?,"
      + "productManufacturer=?"
      + "where productId=?"
        		);
        q.setParameter(0,product.getProductName());
        q.setParameter(1,product.getProductCategory());
        q.setParameter(2,product.getProductDescription());
        q.setParameter(3,product.getProductPrice());
        q.setParameter(4,product.getProductCondition());
        q.setParameter(5,product.getProductStatus());
        q.setParameter(6,product.getUnitInStock());
        q.setParameter(7,product.getProductManufacturer());
        q.setParameter(8,product.getProductId());
               
        System.out.println(product.getProductId());
        q.executeUpdate();
        
        session.flush();
    }
}