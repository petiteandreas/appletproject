package com.andriidnikitin.appletapp.bl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.andriidnikitin.appletapp.commons.AppletProjectElementNotFoundException;
import com.andriidnikitin.appletapp.commons.AppletProjectException;
import com.andriidnikitin.appletapp.commons.AppletProjectInvalidDocException;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;
import com.andriidnikitin.appletapp.commons.AppletProjectUnableToAddException;
import com.andriidnikitin.appletapp.dao.FileManager;
import com.andriidnikitin.appletapp.dao.FileManagerListStub;

import static com.andriidnikitin.appletapp.bl.DocumentValidator.*;

public class DocumentServiceImpl implements DocumentService {

	private FileManager manager;//TODO - inject with spring
		
	public DocumentServiceImpl() {
		super();
		manager = new FileManagerListStub();
	}

	@Override
	public boolean addDocument(Document doc)
			throws AppletProjectUnableToAddException {		
		try {
			if (this.containsDoc(doc)){
				throw new AppletProjectUnableToAddException(doc + "already exists");
			}
			if (!documentIsValid(doc)){
				return false;
			}
			manager.persistDocument(doc);
		} catch (AppletProjectException e) {
			throw new AppletProjectUnableToAddException(e);
		}
		
		return true;
		
	}

	@Override
	public boolean documentIsValid(Document doc)
			throws AppletProjectInvalidDocException {
				
		if (doc == null)
			return false;
		
		return validateDoc(doc);
	}
		
		
	@Override
	public boolean containsDoc(Document doc) throws AppletProjectPersistenceException {	
		if (doc == null) {
			return false;
		}
		try {
			return (null != manager.getDocument(doc.getPassportSerial(), doc.getPassportId()));
		} catch (AppletProjectElementNotFoundException e) {
			return false;
		}
	}

	@Override
	public void printDocument(PrintStream out, Document doc) {
		out.println("(+)-----------------------(+)");
		out.println(doc.getSNP());
		out.println("born on " + doc.getBirthday());
		out.println("in " + doc.getBirthplaceCity() + ", " + doc.getBirthplaceArea() 
				+  " area, " + doc.getBirthplaceRegion() + " region");
		out.println("passport " + doc.getPassportSerial() + doc.getPassportId());
		out.println("received from " + doc.getRegistrator() + ", " + 
		doc.getRegistratorDepartment() + " department");
		out.println("on " + doc.getDateOfRegistrating());
		out.println("(+)-----------------------(+)");
		
	}

	/**
	 * @param list is list of new documents that should be added
	 * @return list of documents that were not added 
	*/
	@Override
	public List<Document> addDocuments(List<Document> list) {
		List<Document> fails = new ArrayList<Document>();
		for (Document doc: list){
			try {
				if (!addDocument(doc)){
					fails.add(doc);
				}
			} catch (AppletProjectUnableToAddException e){
				fails.add(doc);
			}
		}
		return fails;		
	}

	/**
	 * @param validDataset is list of documents that should be checked - whether 
	 * they are already persisted
	 * 
	 * @return true if they all are already persisted
	 */
	@Override
	public boolean containsAllDocs(List<Document> validDataset) 
			throws AppletProjectPersistenceException {
		for (Document doc: validDataset){
			if (!containsDoc(doc)){
				return false;
			}
		}
		return true;
		
	}

}
