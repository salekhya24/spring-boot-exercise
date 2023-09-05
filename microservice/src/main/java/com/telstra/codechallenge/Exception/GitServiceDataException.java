package com.telstra.codechallenge.Exception;

public class GitServiceDataException extends GitServiceException {

    
	private static final long serialVersionUID = 1L;

	public GitServiceDataException(String message) {
        super(message);
    }

    public GitServiceDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
