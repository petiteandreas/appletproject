package com.andriidnikitin.appletapp.dao;

import java.io.File;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;

public class FileManager implements RepositoryManagable {

	@Override
	public void persistDocument(Document doc)
			throws AppletProjectPersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public Document getDocument(String passportSerial, String passportId)
			throws AppletProjectPersistenceException,
			AppletProjectPersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidCsvDocumentFile(File wrappedFile) {
		// TODO Auto-generated method stub
		return false;
	}

}
