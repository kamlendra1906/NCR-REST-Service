/**
 * 
 */
package com.rest.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dao.IProductDAO;
import com.rest.dao.ProductDAOImpl;
import com.rest.domain.Product;
import com.rest.domain.ProductType;
import com.rest.exception.ErrorResponse;
import com.rest.exception.ServiceException;

/**
 * @author kamlendrak
 *
 */
@RestController
public class ProductService {
	
	private IProductDAO productDao;
	
	public ProductService() {
		productDao = new ProductDAOImpl();
	}
	
	@RequestMapping(path="/getProduct", method=RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@RequestParam(name="productId") long productId) throws ServiceException {
		Product p = productDao.getProduct(productId);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	@RequestMapping(path="/registerProduct", method=RequestMethod.POST)
	public ResponseEntity<Product> registerProduct(@RequestBody Product product) throws ServiceException {
		Product p = productDao.registerProduct(product);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	@RequestMapping(path="/updateProduct", method=RequestMethod.POST)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ServiceException {
		Product p = productDao.updateProduct(product);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	@RequestMapping(path="/deleteProduct", method=RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@RequestParam(name="productId") long productId) throws ServiceException {
		Product p = productDao.deleteProduct(productId);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	@RequestMapping(path="/getAllProducts", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() throws ServiceException {
		List<Product> products = productDao.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(path="/getProductsByType", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> findProdctsByType(@RequestParam(name="type") ProductType type) throws ServiceException {
		List<Product> products = productDao.getAllProductsByType(type);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(path="/getProductsByNamePattern", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> findProductsByNamePattern(@RequestParam(name="pattern") String pattern) throws ServiceException {
		List<Product> products = productDao.getAllProductsByName(pattern);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}