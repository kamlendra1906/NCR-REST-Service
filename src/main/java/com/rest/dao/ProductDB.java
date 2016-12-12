/**
 * 
 */
package com.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.rest.domain.Product;
import com.rest.domain.ProductType;
import com.rest.exception.ServiceException;

/**
 * Class represents DB for products.
 * @author kamlendrak
 *
 */
public class ProductDB {

	private static List<Product> products = new ArrayList<>();
	
	static {
		loadProducts();
	}

	private static void loadProducts() {
		Product p = new Product();
		p.setProductId(1);
		p.setDescription("P1 Description");
		p.setName("P1 demo product");
		p.setType(ProductType.BEVERAGES);
		p.setUnitPrice(2.0d);
		products.add(p);
		
		p = new Product();
		p.setProductId(2);
		p.setDescription("P2 Description");
		p.setName("P2 demo product");
		p.setType(ProductType.ELECTRONICS);
		p.setUnitPrice(3.0d);
		products.add(p);
		
		p = new Product();
		p.setProductId(3);
		p.setDescription("P3 Description");
		p.setName("P3 demo product");
		p.setType(ProductType.FOOD);
		p.setUnitPrice(3.0d);
		products.add(p);
		
		p = new Product();
		p.setProductId(4);
		p.setDescription("P4 iphone Description");
		p.setName("P4 iphone demo product");
		p.setType(ProductType.ELECTRONICS);
		p.setUnitPrice(750.0d);
		products.add(p);
		
		p = new Product();
		p.setProductId(5);
		p.setDescription("P5 xbox Description");
		p.setName("P5 xbox demo product");
		p.setType(ProductType.ELECTRONICS);
		p.setUnitPrice(350.0d);
		products.add(p);
	}
	
	/**
	 * Gets the product for given product id.
	 * @param productId
	 * @return
	 * @throws ServiceException
	 */
	public static Product getProduct(long productId) throws ServiceException {
		Product result = null;
		for(Product p : products) {
			if(p != null && p.getProductId() == productId) {
				result = p;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Adds the given product to DB.
	 * @param product
	 * @return
	 * @throws ServiceException
	 */
	public static Product registerProduct(Product product) throws ServiceException {
		for(Product p : products) {
			if(p != null) {
				if(p.getProductId() == product.getProductId()) throw new ServiceException("productId is not unique");
				if(p.getName().equalsIgnoreCase(product.getName())) throw new ServiceException("product name is not unique");
			}
		}
		products.add(product);
		return product;
	}
	
	/**
	 * Updates the given product.
	 * @param product
	 * @return
	 * @throws ServiceException
	 */
	public static Product updateProduct(Product product) throws ServiceException {
		for(Product p : products) {
			if(p != null && p.getProductId() == product.getProductId()) {
				p.setDescription(product.getDescription());
				p.setName(product.getName());
				p.setProductId(product.getProductId());
				p.setType(product.getType());
				p.setUnitPrice(product.getUnitPrice());
				return p;
			}
		}
		throw new ServiceException("product doesn't exist");
	}
	
	/**
	 * Deletes the product.
	 * @param productId
	 * @return
	 * @throws ServiceException
	 */
	public static Product deleteProduct(long productId) throws ServiceException {
		for(int i=0;i<products.size();i++) {
			Product p = products.get(i);
			if(p != null && p.getProductId() == productId) {
				products.set(i, null);
				return p;
			}
		}
		throw new ServiceException("Product not found");
	}
	
	/**
	 * Returns all the products in DB.
	 * @return
	 * @throws ServiceException
	 */
	public static List<Product> getAllProducts() throws ServiceException {
		List<Product> result = new ArrayList<>();
		for(Product p : products) {
			if(p != null) {
				result.add(p);
			}
		}
		return result;
	}
	
	/**
	 * Returns all the product of a given type.
	 * @param type
	 * @return
	 * @throws ServiceException
	 */
	public static List<Product> getAllProductByType(ProductType type) throws ServiceException {
		List<Product> result = new ArrayList<>();
		for(Product p : products) {
			if(p.getType() == type) result.add(p);
		}
		return result;
	}
	
	/**
	 * Returns all the products whose name matches the given pattern.
	 * @param strPattern
	 * @return
	 * @throws ServiceException
	 */
	public static List<Product> getAllProductByNamePattern(String strPattern) throws ServiceException {
		List<Product> result = new ArrayList<>(); 
		for(Product p : products) {
			if(Pattern.matches(strPattern, p.getName())) result.add(p);
		}
		return result;
	}
}
