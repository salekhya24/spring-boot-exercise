package com.telstra.codechallenge.Exception;

public class GitServiceConnectionException extends GitServiceException {

   
	private static final long serialVersionUID = -730209668968270899L;

	public GitServiceConnectionException(String message) {
        super(message);
    }

    public GitServiceConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
