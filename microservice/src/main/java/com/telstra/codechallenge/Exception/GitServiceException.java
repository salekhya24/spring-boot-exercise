package com.telstra.codechallenge.Exception;

public class GitServiceException extends RuntimeException {

   
	private static final long serialVersionUID = 1L;

	public GitServiceException(String message) {
        super(message);
    }

    public GitServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

