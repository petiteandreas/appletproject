package com.andriidnikitin.appletapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;

public class LocalRepository implements RepositoryManageable {
	
	private List<Document> elements; 

	
	
	public LocalRepository() {
		super();
		this.elements = new ArrayList<Document>();
	}		

	@Override
	public void persistDocuments(List<Document> docs)
			throws AppletProjectPersistenceException {
		elements.addAll(docs);		
	}

	@Override
	public List<Document> loadAllDocuments()
			throws AppletProjectPersistenceException {
		return elements;
	}

	@Override
	public boolean containsAllDocs(List<Document> docs)
			throws AppletProjectPersistenceException {
		for (Document doc: docs){
			if (!docs.contains(doc)){
				return false;
			}
		}
		return true;
	}
	
}
