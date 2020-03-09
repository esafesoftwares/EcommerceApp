package com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Customer implements Serializable {
	  private static final long serialVersionUID = -2054386655979281968L;
	  @NotEmpty(message="The User name must not be null.")
	  private String userName;
	  @NotEmpty(message="The Password must not be null.")
	  private String password;
	  @NotEmpty(message="The Customer name must not be null.")
	  private String customerName;
	  @Pattern(regexp="[^@]+@[^@]+\\.[a-zA-Z]{2,6}",message="required correct format Example abc@gmail.com")
	  private String customerEmail;
	  @Id
	  @Pattern(regexp="\\d{10}",message="Phone Number Must Be Exactly 10 Digits")
	  private String phoneNumber;
	  
	  public Customer()
	  {}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	  

}
