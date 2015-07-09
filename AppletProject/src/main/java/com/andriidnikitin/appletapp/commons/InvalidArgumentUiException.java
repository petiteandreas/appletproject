package com.andriidnikitin.appletapp.commons;

public class InvalidArgumentUiException extends AppletProjectException {

	public InvalidArgumentUiException(AppletProjectException e) {
		super(e); 
	}

	public InvalidArgumentUiException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6853457380450242490L;

}
