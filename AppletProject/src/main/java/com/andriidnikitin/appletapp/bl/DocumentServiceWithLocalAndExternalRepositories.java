package com.andriidnikitin.appletapp.bl;

import java.util.ArrayList;
import java.util.List;

import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;
import com.andriidnikitin.appletapp.commons.AppletProjectServiceException;
import com.andriidnikitin.appletapp.dao.ManagerOfFileRepository;
import com.andriidnikitin.appletapp.dao.RepositoryManageable;
import com.andriidnikitin.appletapp.dao.LocalRepository;

import static com.andriidnikitin.appletapp.bl.DocumentValidator.*;

public class DocumentServiceWithLocalAndExternalRepositories implements DocumentService {

	private RepositoryManageable externalRepoManager;//TODO - inject with spring
	
	private RepositoryManageable localRepoManager;
		
	public DocumentServiceWithLocalAndExternalRepositories() {
		super();
		//TODO - fix
		externalRepoManager = new LocalRepository();//ManagerOfFileRepository();
		localRepoManager = new LocalRepository();
	}		
	
			
	@Override
	public boolean containsDoc(Document doc) throws AppletProjectServiceException {	
		
		if (doc == null) {
			return false;
		}
		List<Document> list = new ArrayList<Document>();
		return (containsAllDocs(list));
	}
	
	/**
	 * @param list is list of new documents that should be added
	 * @return list of documents that were not added 
	 * @throws AppletProjectServiceException 
	*/
	@Override
	public List<Document> addDocuments(List<Document> list) 
			throws AppletProjectServiceException {
		return persistToStorage(list, localRepoManager);		
	}
	
	/**
	 * @param list is list of new documents that should be persisted
	 * @return list of documents that were not added 
	 * @throws AppletProjectServiceException 
	*/
	@Override
	public List<Document> persistDocuments(List<Document> list) 
			throws AppletProjectServiceException {
		return persistToStorage(list, externalRepoManager);		
	}

	private List<Document> persistToStorage(List<Document> list, RepositoryManageable repo)
			throws AppletProjectServiceException {
		List<Document> fails = new ArrayList<Document>();
		List<Document> validDocs = new ArrayList<Document>();
		for (Document doc: list){
			if (!validateDoc(doc)) 
				fails.add(doc);
			else validDocs.add(doc);
		}
		try {
			externalRepoManager.persistDocuments(validDocs);
			localRepoManager.persistDocuments(validDocs);
		} catch (AppletProjectPersistenceException e) {
			// TODO Auto-generated catch block
			throw new AppletProjectServiceException(e);
		}
		return fails;
	}

	/**
	 * @param data is list of documents that should be checked - whether 
	 * they are already persisted
	 * 
	 * @return true if they all are already persisted
	 */
	@Override
	public boolean containsAllDocs(List<Document> data) 
			throws AppletProjectServiceException {		
		try {
			return localRepoManager.containsAllDocs(data);
		} catch (AppletProjectPersistenceException e) {			
			throw new AppletProjectServiceException(e);
		}
		
	}

	@Override
	public List<Document> loadAllDocumentsFromExternalRepository()
			throws AppletProjectServiceException {		
		try {
			return externalRepoManager.loadAllDocuments();
		} catch (AppletProjectPersistenceException e) {
			throw new AppletProjectServiceException(e);
		}
	}

}