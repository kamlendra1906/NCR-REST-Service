/**
 * 
 */
package com.rest.dao;

import java.util.List;

import com.rest.domain.Product;
import com.rest.domain.ProductType;
import com.rest.exception.ServiceException;

/**
 * @author kamlendrak
 *
 */
public interface IProductDAO {

	/**
	 * Returns the product with given productId.
	 * @param productId
	 * @return
	 * @throws ServiceException
	 */
	public Product getProduct(long productId) throws ServiceException;
	
	/**
	 * Register the given product.
	 * @param product
	 * @return
	 * @throws ServiceException
	 */
	public Product registerProduct(Product product) throws ServiceException;
	
	/**
	 * Update the product.
	 * @param product
	 * @return
	 * @throws ServiceException
	 */
	public Product updateProduct(Product product) throws ServiceException;
	
	/**
	 * Delete the product.
	 * @param productId
	 * @return
	 * @throws ServiceException
	 */
	public Product deleteProduct(long productId) throws ServiceException;
	
	/**
	 * Returns all the products.
	 * @return
	 * @throws ServiceException
	 */
	public List<Product> getAllProducts() throws ServiceException;
	
	/**
	 * Returns all the products of given type.
	 * @param type
	 * @return
	 * @throws ServiceException
	 */
	public List<Product> getAllProductsByType(ProductType type) throws ServiceException;
	
	/**
	 * Returns all the products matching the given pattern.
	 * @param pattern
	 * @return
	 * @throws ServiceException
	 */
	public List<Product> getAllProductsByName(String pattern) throws ServiceException;
}
