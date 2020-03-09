package com.ecommerce.model;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

	
@Entity
public class Product  implements Serializable{
	private static final long serialVersionUID = -1000119078147252957L;
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid" )
	@Column(name="productId")
private String productId;
    
	@NotEmpty(message="The product name must not be null.")
    private String productName;

    @NotEmpty(message = "The product Category must not be null.")
    private String productCategory;
    
    @NotEmpty(message = "The product Description must not be null.")
    private String productDescription;
    
    @NotNull(message="Price must be Greater than zero")
    @Min(value = 1, message = "The product price must be atleast 1.")
    private double productPrice;
   
    @NotNull(message="The Product Condition  value  must not be either 0(used) | 1(new).")
    private boolean productCondition;
    
    @NotNull(message="The Active Status value  must not be either 0(Inactive) | 1(active).")
    private boolean productStatus ;

    @Min(value = 1, message = "The product unit must be atleast 1.")
    private int unitInStock;
    
    @NotEmpty (message = "The product  Manufacturer name must not be null.")
    private String productManufacturer;

    @Transient
    private List<MultipartFile> productImage;
    @Transient
    private String append;
    
    public Product()
	{}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(boolean productCondition) {
        this.productCondition = productCondition;
    }

    public boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public List<MultipartFile> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<MultipartFile> productImage) {
        this.productImage = productImage;
    }
    public String getAppend() {
		return append;
	}

	public void setAppend(String append) {
		this.append = append;
	}
}

    