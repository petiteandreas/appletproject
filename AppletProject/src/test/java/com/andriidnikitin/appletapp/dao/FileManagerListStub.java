package com.andriidnikitin.appletapp.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.AppletProjectElementNotFoundException;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;

public class FileManagerListStub implements FileManager {
	
	private List<Document> elements; 

	
	
	public FileManagerListStub() {
		super();
		this.elements = new ArrayList<Document>();
	}

	@Override
	public void persistDocument(Document doc)
			throws AppletProjectPersistenceException {
		elements.add(doc);
	}

	@Override
	public Document getDocument(String passportSerial, String passportId) throws AppletProjectElementNotFoundException {
		if ((passportSerial != null) &&  (passportId != null)){
			for (Document temp: elements){
				if ((passportId.equals(temp.getPassportId()) && 
						(passportSerial.equals(temp.getPassportSerial()))))
								return temp;
			}
		}
		throw new AppletProjectElementNotFoundException();
	}

	@Override
	public boolean isValidCsvDocumentFile(File wrappedFile) {
		// TODO Auto-generated method stub
		return false;
	}

}
