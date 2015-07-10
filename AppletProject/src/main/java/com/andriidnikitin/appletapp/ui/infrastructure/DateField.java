package com.andriidnikitin.appletapp.ui.infrastructure;

import java.awt.TextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectUiIncorrectDateFormatException;

public class DateField extends TextField {

	private static final long serialVersionUID = 1L;
	
	public Date getDate() throws AppletProjectUiIncorrectDateFormatException{

	String content = this.getText();
		
	if(content.isEmpty())
        throw new AppletProjectUiIncorrectDateFormatException("Cannot parse to date - empty field");
    else {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
            return simpleDateFormat.parse(content);
            
         } catch (ParseException e) {    
        	throw new AppletProjectUiIncorrectDateFormatException(e);
         }      
        	
        }
    }   
}
