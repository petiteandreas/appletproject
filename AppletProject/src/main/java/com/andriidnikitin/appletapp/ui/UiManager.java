package com.andriidnikitin.appletapp.ui;

import java.util.List;

import javax.swing.JPanel;

import com.andriidnikitin.appletapp.bl.BusinessService;
import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectServiceException;
import com.andriidnikitin.appletapp.commons.exceptions.InvalidArgumentUiException;

public class UiManager {
	
	private final BusinessService service = new 
			BusinessService();

	private final InputFormPanel inputForm = new InputFormPanel(this);
	
	private final MainPagePanel mainPage = new MainPagePanel(this); 
	
	private static final JPanel EMPTY = new JPanel(); 
	
	private ContainingApplet container;
	
	public UiManager(ContainingApplet launchingApplet) {
		
		container = launchingApplet;
		
		container.setContent(mainPage);
	}

	public static void showErrorScreen(String string) {
				

	}
	
	public void openMainPage(){	
		
		closeAll();

		container.setContent(mainPage);
	}
	
	public void openInputForm(){

		closeAll();

		container.setContent(inputForm);
	}
	
	private void closeAll() {

		container.setContent(EMPTY);
		
	}

	public List<Document> loadDocuments(String filePath) throws InvalidArgumentUiException{
		try {
			return service.loadAllDocumentsFromExternalRepository(filePath);
		} catch (AppletProjectServiceException e) {
			throw new InvalidArgumentUiException(e); 
		} 
	}
}
