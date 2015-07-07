package com.andriidnikitin.appletapp.dao;

import java.io.File;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.AppletProjectElementNotFoundException;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;

public interface FileManager {
	
	public void persistDocument(Document doc) throws AppletProjectPersistenceException;
	
	/**
	 * 
	 * @param passportSerial - is serial element of passport code - in format XY
	 * @param passportId - is numeric code of passport code - in format NNNNNN
	 * @return doc with such parameters 
	 * @throws AppletProjectElementNotFoundException if element you are seeking does not exist
	 */
	public Document getDocument(String passportSerial, String passportId) throws AppletProjectPersistenceException, AppletProjectElementNotFoundException;

	public boolean isValidCsvDocumentFile(File wrappedFile);
	
	//TODO - update, delete, getall, get filtered
	
	

}
