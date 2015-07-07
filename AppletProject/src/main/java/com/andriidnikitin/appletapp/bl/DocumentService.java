package com.andriidnikitin.appletapp.bl;

import java.io.PrintStream;
import java.util.List;

import com.andriidnikitin.appletapp.commons.AppletProjectInvalidDocException;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;
import com.andriidnikitin.appletapp.commons.AppletProjectUnableToAddException;

public interface DocumentService {
	
	boolean addDocument(Document doc) throws AppletProjectUnableToAddException;
	
	boolean documentIsValid(Document doc) throws AppletProjectInvalidDocException;
	
	boolean containsDoc(Document doc) throws AppletProjectPersistenceException;

	void printDocument(PrintStream out, Document doc);

	List<Document> addDocuments(List<Document> list);

	boolean containsAllDocs(List<Document> validDataset) throws AppletProjectPersistenceException;
}
