package com.ecommerce.dao;


import com.ecommerce.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class  ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        session.flush();
    }

    public Product getProductById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    public void deleteProduct (String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
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