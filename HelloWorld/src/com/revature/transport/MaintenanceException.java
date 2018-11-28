package com.revature.transport;

public class MaintenanceException extends Exception {

	public MaintenanceException() {
	}

	public MaintenanceException(String arg0) {
		super(arg0);
	}

	public MaintenanceException(Throwable cause) {
		super(cause);
	}

	public MaintenanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaintenanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
