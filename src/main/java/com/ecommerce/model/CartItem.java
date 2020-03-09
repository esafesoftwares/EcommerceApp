package com.ecommerce.model;

public class CartItem {
	
	 private String cartId;
	
	private Product product;
	double Price;
	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	private int quantity;

	
	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}


	
	
	public int getQuantity() {
		return quantity;
	}

	

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartItem() {
	}

	public CartItem(Product product, int quantity) {
		
		this.setProduct(product);
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	}
