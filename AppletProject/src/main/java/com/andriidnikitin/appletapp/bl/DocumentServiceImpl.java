package com.andriidnikitin.appletapp.bl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.andriidnikitin.appletapp.commons.AppletProjectException;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;
import com.andriidnikitin.appletapp.commons.AppletProjectServiceException;
import com.andriidnikitin.appletapp.dao.RepositoryManagable;
import com.andriidnikitin.appletapp.dao.FileManagerListStub;

import static com.andriidnikitin.appletapp.bl.DocumentValidator.*;

public class DocumentServiceImpl implements DocumentService {

	private RepositoryManagable manager;//TODO - inject with spring
		
	public DocumentServiceImpl() {
		super();
		manager = new FileManagerListStub();
	}

	@Override
	public boolean addDocument(Document doc)
			throws AppletProjectServiceException {		
		try {
			if (this.containsDoc(doc)){
				throw new AppletProjectServiceException( "Unable to add already existing doc" + doc);
			}
			if (!validateDoc(doc)){
				return false;
			}
			manager.persistDocument(doc);
		} catch (AppletProjectException e) {
			throw new AppletProjectServiceException(e);
		}
		
		return true;
		
	}
		
		
	@Override
	public boolean containsDoc(Document doc) throws AppletProjectServiceException {	
		if (doc == null) {
			return false;
		}
		try {
				return (null != manager.getDocument(doc.getPassportSerial(), doc.getPassportId()));
		} catch (AppletProjectPersistenceException e) {
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
	 * @throws AppletProjectServiceException 
	*/
	@Override
	public List<Document> addDocuments(List<Document> list) throws AppletProjectServiceException {
		List<Document> fails = new ArrayList<Document>();
		for (Document doc: list){
				try {
					if (!addDocument(doc)){
						fails.add(doc);
					}					
				} catch (AppletProjectServiceException e){
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
			throws AppletProjectServiceException {
		for (Document doc: validDataset){
			if (!containsDoc(doc)){
				return false;
			}
		}
		return true;
		
	}

}
