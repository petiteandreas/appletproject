package com.andriidnikitin.appletapp.bl;

import java.io.PrintStream;
import java.util.List;

import com.andriidnikitin.appletapp.commons.AppletProjectServiceException;

public interface DocumentService {
	
	boolean addDocument(Document doc) throws AppletProjectServiceException;
		
	boolean containsDoc(Document doc) throws AppletProjectServiceException;

	void printDocument(PrintStream out, Document doc);

	List<Document> addDocuments(List<Document> list) throws AppletProjectServiceException;

	boolean containsAllDocs(List<Document> validDataset) throws AppletProjectServiceException;
}
