package com.telstra.codechallenge.Exception;

public class GitServiceConfigurationException extends GitServiceException {

   
	private static final long serialVersionUID = 1L;

	public GitServiceConfigurationException(String message) {
        super(message);
    }

    public GitServiceConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
