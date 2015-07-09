package com.andriidnikitin.appletapp.ui.infrastructure;

import java.awt.TextField;

public class DateField extends TextField {

	private static final long serialVersionUID = 1L;
	
	private TextField day, month, year;
	
	public DateField(){
		day = new TextField(2);
		month = new TextField(2);
		year = new TextField(4);
	}
	
	
	

}
