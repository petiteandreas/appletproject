package com.andriidnikitin.appletapp.ui;

import java.util.List;

import com.andriidnikitin.appletapp.bl.BusinessService;
import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.AppletProjectServiceException;
import com.andriidnikitin.appletapp.commons.InvalidArgumentUiException;

public class UiManager {
	
	private final BusinessService service = new 
			BusinessService();

	private final InputFormApplet inputForm = new InputFormApplet();
	
	private final MainPageApplet mainPage = new MainPageApplet(); 
	
	public UiManager(){
		
		inputForm.setVisible(false);
		
		mainPage.setVisible(false); 
		
	}

	public static void showErrorScreen(String string) {
		// TODO Replace with a real code of calling error message 
		
	}
	
	public void openMainPage(){		
		;
	}

	public void openInputForm(){
		//TODO - Auto-generated method stub		
	}
	
	public List<Document> loadDocuments(String filePath) throws InvalidArgumentUiException{
		try {
			return service.loadAllDocumentsFromExternalRepository(filePath);
		} catch (AppletProjectServiceException e) {
			throw new InvalidArgumentUiException(e); 
		} 
	}
}
