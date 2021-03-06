package com.andriidnikitin.appletapp.bl;

import java.util.List;

import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectServiceException;
import com.andriidnikitin.appletapp.dao.Repository;

public interface DocumentService {
			
	boolean containsDoc(Document doc) throws AppletProjectServiceException;
	
	boolean containsAllDocs(List<Document> validDataset) throws AppletProjectServiceException;

	List<Document> addDocuments(List<Document> list)
			throws AppletProjectServiceException;
	
	List<Document> loadAllDocumentsFromExternalRepository()
			throws AppletProjectServiceException;

	List<Document> persistDocuments(List<Document> list)
			throws AppletProjectServiceException;

	boolean containsAnyDoc(List<Document> data)
			throws AppletProjectServiceException;

	DocumentServiceWithLocalAndExternalRepositories setExternalRepo(
			Repository repo);
}
