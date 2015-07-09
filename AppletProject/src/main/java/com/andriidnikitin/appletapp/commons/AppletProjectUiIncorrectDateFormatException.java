package com.andriidnikitin.appletapp.commons;

import java.text.ParseException;

public class AppletProjectUiIncorrectDateFormatException extends InvalidArgumentUiException {

	public AppletProjectUiIncorrectDateFormatException(AppletProjectException e) {
		super(e);
	}

	public AppletProjectUiIncorrectDateFormatException(String string) {
		super(string);
	}

	public AppletProjectUiIncorrectDateFormatException(ParseException e) {
		super(e);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
