package com.nttdata.person.exceptions;

public class NotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String errorCode;
	private final String errorMessage;
	private static final int STATUS_CODE = 404; // HTTP STATUS 404/500
	private final String requestId;

	public NotFoundException(String errorCode, String errorMessage, String requestId, Exception e) {
		super(errorMessage, e);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.requestId = requestId;
	}

	public NotFoundException(String errorCode, String errorMessage, String requestId) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.requestId = requestId;
	}

	public NotFoundException(String errorCode, String errorMessage, Exception e) {
		super(errorMessage, e);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.requestId = null;
	}

	public NotFoundException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.requestId = null;
	}

	public NotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorCode = null;
		this.errorMessage = errorMessage;
		this.requestId = null;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public int getStatusCode() {
		return STATUS_CODE;
	}

	public String getRequestId() {
		return requestId;
	}
}
