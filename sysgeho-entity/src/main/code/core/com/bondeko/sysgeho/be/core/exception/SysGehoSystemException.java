package com.bondeko.sysgeho.be.core.exception;


public class SysGehoSystemException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SysGehoSystemException() {
		 
	}

	/**
	 * @param message
	 *            : message d'exception
	 */
	public SysGehoSystemException(String message) {
		super(message);
		 
	}

	/**
	 * @param cause
	 */
	public SysGehoSystemException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 *            : message d'exception
	 * @param cause
	 */
	public SysGehoSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	// @Override
	// public String toString() {
	// return super.toString();
	// }
}
