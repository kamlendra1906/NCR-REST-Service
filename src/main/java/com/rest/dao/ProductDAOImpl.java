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
public class ProductDAOImpl implements IProductDAO {
	
	

	/* (non-Javadoc)
	 * @see com.rest.dao.IProductDAO#getProduct(long)
	 */
	@Override
	public Product getProduct(long productId) throws ServiceException {
		if(productId <= 0) throw new ServiceException("invalid product id");
		Product p = ProductDB.getProduct(productId);
		if(p == null) throw new ServiceException("product not found");
		return p;
	}


	/* (non-Javadoc)
	 * @see com.rest.dao.IProductDAO#registerProduct(com.rest.domain.Product)
	 */
	@Override
	public Product registerProduct(Product product) throws ServiceException {
		if(product == null) throw new ServiceException("Product is null");
		return ProductDB.registerProduct(product);
		
	}

	/* (non-Javadoc)
	 * @see com.rest.dao.IProductDAO#updateProduct(com.rest.domain.Product)
	 */
	@Override
	public Product updateProduct(Product product) throws ServiceException {
		if(product == null) throw new ServiceException("Product is null");
		return ProductDB.updateProduct(product);
	}

	/* (non-Javadoc)
	 * @see com.rest.dao.IProductDAO#deleteProduct(com.rest.domain.Product)
	 */
	@Override
	public Product deleteProduct(long productId) throws ServiceException {
		if(productId <= 0) throw new ServiceException("invalid product id");
		return ProductDB.deleteProduct(productId);
	}

	/* (non-Javadoc)
	 * @see com.rest.dao.IProductDAO#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() throws ServiceException {
		return ProductDB.getAllProducts();
	}

	/* (non-Javadoc)
	 * @see com.rest.dao.IProductDAO#getAllProductsByType(com.rest.domain.ProductType)
	 */
	@Override
	public List<Product> getAllProductsByType(ProductType type) throws ServiceException {
		if(type == null) throw new ServiceException("type is null");
		return ProductDB.getAllProductByType(type);
	}

	/* (non-Javadoc)
	 * @see com.rest.dao.IProductDAO#getAllProductsByName(java.lang.String)
	 */
	@Override
	public List<Product> getAllProductsByName(String pattern) throws ServiceException {
		if(pattern == null || pattern.length() == 0) throw new ServiceException("Pattern is empty or null");
		return ProductDB.getAllProductByNamePattern(pattern);
	}
}