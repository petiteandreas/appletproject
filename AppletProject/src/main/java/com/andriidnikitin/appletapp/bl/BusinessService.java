package com.andriidnikitin.appletapp.bl;

import java.util.List;

import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;
import com.andriidnikitin.appletapp.commons.AppletProjectServiceException;
import com.andriidnikitin.appletapp.dao.ManagerOfFileRepository;


/**
 * This class is a facade for business logic
 * @author Андрей
 *
 */
public class BusinessService {	
	
	private DocumentService service;
	
	private ManagerOfFileRepository repo; 
	
	public BusinessService(){
		
		ManagerOfFileRepository repo = new ManagerOfFileRepository();
		
		DocumentService service = new DocumentServiceWithLocalAndExternalRepositories();
		
		service.setExternalRepo(repo);
		 
	}
	
	public boolean containsDoc(Document doc)
			throws AppletProjectServiceException {
		return service.containsDoc(doc);
	}

	public boolean containsAllDocs(List<Document> validDataset)
			throws AppletProjectServiceException {
		return service.containsAllDocs(validDataset);
	}

	public List<Document> addDocuments(List<Document> list)
			throws AppletProjectServiceException {
		return service.addDocuments(list);
	}

	public List<Document> loadAllDocumentsFromExternalRepository(String filepath)
			throws AppletProjectServiceException {
		try {
			repo.setFileForReading(filepath);
		} catch (AppletProjectPersistenceException e) {
			throw new AppletProjectServiceException(e);
		}
		return service.loadAllDocumentsFromExternalRepository();
	}

	public List<Document> persistDocuments(List<Document> list, String filepath)
			throws AppletProjectServiceException {
		try {
			repo.setFileForWriting(filepath);
		} catch (AppletProjectPersistenceException e) {
			throw new AppletProjectServiceException(e);
		}
		return service.persistDocuments(list);
	}

	public boolean containsAnyDoc(List<Document> data)
			throws AppletProjectServiceException {
		return service.containsAnyDoc(data);
	}		
}
