package com.andriidnikitin.appletapp.dao;

import java.util.List;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectPersistenceException;

public interface Repository {
		
	void persistDocuments(List<Document> docs)
			throws AppletProjectPersistenceException;

	List<Document> loadAllDocuments() throws AppletProjectPersistenceException;

	boolean containsAllDocs(List<Document> docs)
			throws AppletProjectPersistenceException;

	boolean containsAnyDoc(List<Document> data) throws AppletProjectPersistenceException;
	
	
	
	

}
