/**
 * 
 */
package com.rest.domain;

import java.io.Serializable;

/**
 * Product class.
 * @author kamlendrak
 *
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long productId;
	private String name;
	private String description;
	private double unitPrice;
	private ProductType type;
	
	public Product() {
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the type
	 */
	public ProductType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ProductType type) {
		this.type = type;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}