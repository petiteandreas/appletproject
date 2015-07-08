package com.andriidnikitin.appletapp.dao;

import java.io.File;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;

public interface RepositoryManagable {
	
	public void persistDocument(Document doc) throws AppletProjectPersistenceException;
	
	/**
	 * 
	 * @param passportSerial - is serial element of passport code - in format XY
	 * @param passportId - is numeric code of passport code - in format NNNNNN
	 * @return doc with such parameters 
	 * @throws AppletProjectDocumentNotFoundException if element you are seeking does not exist
	 */
	public Document getDocument(String passportSerial, String passportId) 
			throws AppletProjectPersistenceException;

	public boolean isValidCsvDocumentFile(File wrappedFile);
	
	//TODO - update, delete, getall, get filtered
	
	

}
