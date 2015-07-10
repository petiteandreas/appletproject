package com.andriidnikitin.appletapp.bl;

import java.util.List;

import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectServiceException;
import com.andriidnikitin.appletapp.dao.Repository;


/**
 * This class is a facade for business logic
 * @author Андрей
 *
 */
public class BusinessService {	
	
	private DocumentService service;
	
	private RepositoryHolder holder; 
	//TODO - replace with Spring injection
	
	public BusinessService(){
		
		service = new DocumentServiceWithLocalAndExternalRepositories();
		 
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
		Repository newRepository = holder.getExternalRepoForReading(filepath);
		service.setExternalRepo(newRepository);
		return service.loadAllDocumentsFromExternalRepository();
	}

	public List<Document> persistDocuments(List<Document> list, String filepath)
			throws AppletProjectServiceException {
		Repository newRepository = holder.getExternalRepoForWriting(filepath);
		service.setExternalRepo(newRepository);
		return service.persistDocuments(list);
	}

	public boolean containsAnyDoc(List<Document> data)
			throws AppletProjectServiceException {
		return service.containsAnyDoc(data);
	}		
}
