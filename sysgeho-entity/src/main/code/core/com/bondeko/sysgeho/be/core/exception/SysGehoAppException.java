/**
 * 
 */
package com.bondeko.sysgeho.be.core.exception;

public class SysGehoAppException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SysGehoAppException() {
		 
	}

	/**
	 * @param message
	 *            : message d'exception
	 */
	public SysGehoAppException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public SysGehoAppException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            : message d'exception
	 * @param cause
	 */
	public SysGehoAppException(String message, Throwable cause) {
		super(message, cause);
	}

	// @Override
	// public String toString() {
	// return super.toString();
	// }

}
