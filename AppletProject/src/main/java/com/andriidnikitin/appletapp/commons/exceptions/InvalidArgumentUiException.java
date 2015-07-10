package com.andriidnikitin.appletapp.commons.exceptions;

import java.text.ParseException;

public class InvalidArgumentUiException extends AppletProjectException {

	public InvalidArgumentUiException(AppletProjectException e) {
		super(e); 
	}

	public InvalidArgumentUiException(String string) {
		super(string);
	}

	public InvalidArgumentUiException(ParseException e) {
		super(e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6853457380450242490L;

}
