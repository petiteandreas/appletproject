package com.andriidnikitin.appletapp.commons.exceptions;


public class AppletProjectServiceException extends
	AppletProjectException {
	
	public AppletProjectServiceException(Exception e) {
		super(e);
	}

	public AppletProjectServiceException() {
	}

	public AppletProjectServiceException(String string) {
		super(string);
	}

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

}
