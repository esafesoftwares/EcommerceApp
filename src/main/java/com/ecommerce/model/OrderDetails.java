package com.ecommerce.model;
import java.io.Serializable;
 

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

 

	 
	@Entity
public class OrderDetails implements Serializable {
	 
	    private static final long serialVersionUID = 755074592884318353L;
	    @Id @GeneratedValue(generator="system-uuid")
		@GenericGenerator(name="system-uuid", strategy = "uuid" )
	    private String id;
	    private Orders orderdata;
	    private OrderDetails orderids;
	    private Product product;
	    private int quantity;
	    private double price;
	   
	    private String productId;
		 private String orderId;
		 private String phoneNumber;
		 
		 @ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name = "phoneNumber", nullable = false,//
		    foreignKey = @ForeignKey(name = "PhoneNumber") )
	 public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
	public OrderDetails()
	 {}
	    public String getId() {
	        return id;
	    }
	 
	    public void setId(String id) {
	        this.id = id;
	    }
	 
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "orderId", nullable = false,//
	    foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK") )
	    public Orders getOrder() {
	        return orderdata;
	    }
	 
	    public void setOrder(Orders order) {
	        this.orderdata = order;
	    }
	 
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "productId", nullable = false, //
	    foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK") )
	    public Product getProduct() {
	        return product;
	    }
	 
	    public OrderDetails getOrderid() {
			return orderids;
		}

		public void setOrderid(OrderDetails orderid) {
			this.orderids = orderid;
		}

		public void setProduct(Product product) {
	        this.product = product;
	    }

	    
	    public int getQuantity() {
	        return quantity;
	    }
	 
	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	 
	    public double getPrice() {
	        return price;
	    }
	 
	    public void setPrice(double price) {
	        this.price = price;
	    }
	 

	public OrderDetails(String productId, String orderId2) {
		super();
		this.productId = productId;
		this.orderId = orderId2;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
    
}