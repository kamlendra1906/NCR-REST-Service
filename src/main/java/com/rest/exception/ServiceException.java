/**
 * 
 */
package com.rest.exception;

/**
 * @author kamlendrak
 *
 */
public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String string) {
		super(string);
	}
}