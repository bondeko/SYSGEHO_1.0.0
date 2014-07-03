/**
 * 
 */
package com.bondeko.sysgeho.be.core.exception;

public class SysGehoPersistenceException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SysGehoPersistenceException() {
	}

	/**
	 * @param message
	 *            : message d'exception
	 */
	public SysGehoPersistenceException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public SysGehoPersistenceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            : message d'exception
	 * @param cause
	 */
	public SysGehoPersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	// @Override
	// public String toString() {
	// return super.toString();
	// }
}
