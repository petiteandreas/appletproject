package com.andriidnikitin.appletapp.bl;

import java.util.LinkedList;
import java.util.List;

import com.andriidnikitin.appletapp.commons.StringParser;
import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectPersistenceException;
import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectServiceException;
import com.andriidnikitin.appletapp.dao.FileRepository;
import com.andriidnikitin.appletapp.dao.Repository;

/**
 * Singletone class that holds file repositories and controls access to files.
 * @author Андрей
 *
 */
public class RepositoryHolder {

	private static final List<String> readingFiles = new LinkedList<String>();
	
	private static final List<String> writingFiles = new LinkedList<String>(); 
	
	private final static RepositoryHolder INSTANCE = new RepositoryHolder();	

	protected RepositoryHolder() {
		
	}
	
	public static RepositoryHolder getInstance(){
		return INSTANCE;
	}
	
	
	/**
	 * 
	 * @param filepath is a path to file for reading.
	 * @return is new repository. Null if this file is already in use. 
	 * @throws AppletProjectServiceException when filename is invalid
	 */
	public static Repository getExternalRepoForReading(String filepath) 
			throws AppletProjectServiceException {
		try {
			checkFilepath(filepath);
			if (readingFiles.contains(filepath)){
				return null;
			}
			FileRepository repo = new FileRepository();
			repo.setFileForReading(filepath);
			return repo;
		} catch (AppletProjectPersistenceException e) {
			throw new AppletProjectServiceException(e);
		}
	}
	
	

	/**
	 * 
	 * @param filepath is a path to file for writing.
	 * @return is new repository. Null if this file is already in use. 
	 * @throws AppletProjectServiceException when filename is invalid
	 */
	public static Repository getExternalRepoForWriting(String filepath) 
			throws AppletProjectServiceException {
		try {
			checkFilepath(filepath);
			if (writingFiles.contains(filepath)){
				return null;
			}
			FileRepository repo = new FileRepository();
			repo.setFileForWriting(filepath);
			return repo;
		} catch (AppletProjectPersistenceException e) {
			throw new AppletProjectServiceException(e);
		}
	}
	
	public static void releaseFileForReading(String filePath) 
				throws 	AppletProjectServiceException{
		try{
			readingFiles.remove(filePath);
		}	catch (NullPointerException e) {
			throw new AppletProjectServiceException("Unable to release. Such file does "
					+ "not exist - [" + filePath + "]");
		}
	}	

	public static void releaseFileForWriting(String filePath)
				throws AppletProjectServiceException{
		try{
			writingFiles.remove(filePath);
		}	catch (NullPointerException e) {
			throw new AppletProjectServiceException("Unable to release. Such file does "
					+ "not exist - [" + filePath + "]");
		}
	}

	private static void checkFilepath(String filePath) throws AppletProjectServiceException {
		if (!StringParser.isValidFilename(filePath)){
			throw new AppletProjectServiceException("Invalid filename - [" + filePath + "]");
		}	
		
		
	}	
}
