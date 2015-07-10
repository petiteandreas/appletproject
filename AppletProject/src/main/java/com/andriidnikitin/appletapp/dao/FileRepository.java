package com.andriidnikitin.appletapp.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;
import com.andriidnikitin.appletapp.dao.infrastructure.CsvDocumentParser;

public class FileRepository implements Repository, FileController {	
	
	private File fileForReading;

	private File fileForWriting;
	
	@Override
	public void persistDocuments(List<Document> docs)
			throws AppletProjectPersistenceException {
		synchronized (fileForWriting) {
			if (fileForWriting == null) {
				throw new  AppletProjectPersistenceException("File for writing was not chosen!");
			}	        
			CsvDocumentParser.writeDocumentsToFile(docs, fileForWriting);
	    }

	}

	public Document getDocument(String passportSerial, String passportId)
			throws AppletProjectPersistenceException{
		synchronized (fileForReading) {
			Document result = null;
			if (fileForReading == null){
				throw new  AppletProjectPersistenceException("File for reading was not chosen!");
			}
			return result;
		}
	}

	@Override
	public void setFileForReading(String path) throws AppletProjectPersistenceException {
		synchronized (fileForReading) {
			setFile(path, fileForReading);		
		}
	}

	@Override
	public void setFileForWriting(String path) throws AppletProjectPersistenceException {
		synchronized (fileForReading) {
			setFile(path, fileForWriting);		
		}
	}

	@Override
	public boolean containsAllDocs(List<Document> docs) throws AppletProjectPersistenceException {	
		 throw new AppletProjectPersistenceException("This operation is not supported");
	}

	@Override
	public List<Document> loadAllDocuments() throws AppletProjectPersistenceException {
		synchronized (fileForReading) {
			return CsvDocumentParser.readAllDocumentsFromFile(fileForReading);		
		}
	}
	
	private void setFile(String path, File file) throws AppletProjectPersistenceException {
		if (!fileIsAlreadyOpened(file, path)){
			file = new File(path);
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new AppletProjectPersistenceException(e);
			}
		}
	}
	
	private boolean fileIsAlreadyOpened(File file, String path){
		if (file == null){
			return false;
		}
		return file.getPath().equals(path);
	}

	@Override
	public boolean containsAnyDoc(List<Document> data)
			throws AppletProjectPersistenceException {
		 throw new AppletProjectPersistenceException("This operation is not supported");
	}

}
