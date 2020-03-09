package com.ecommerce.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
 
@Entity
public class Orders implements Serializable{
	
	private static final long serialVersionUID = -2576670215015463100L;
	@Id@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid" )
 	@Column(name="order_id",nullable=false)
    private String order_id;
	
	private Date orderDate;

    private int orderNum;
	
	
    @NotEmpty(message="The Customer name must not be null.")
    private String customerName;
	
    @NotEmpty(message="The Customer Address must not be null.")
    private String customerAddress;
	
    @Pattern(regexp="[^@]+@[^@]+\\.[a-zA-Z]{2,6}",message="required correct format Example abc@gmail.com")
	private String customerEmail;
	
    @Pattern(regexp="\\d{10}",message="Phone Number Must  Be exactly 10 Digits")
    private String customerPhone;

	public Orders()
	{}


    public String getId() {
        return order_id;
    }
 
    public void setId(String id) {
        this.order_id= id;
    }
  
     public Date getOrderDate() {
        return orderDate;
    }
 
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public int getOrderNum() {
        return orderNum;
    }
 
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
 
    
    public String getCustomerName() {
        return customerName;  
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
 
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
 
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
 
   
    public String getCustomerPhone() {
        return customerPhone;
    }
 
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
}