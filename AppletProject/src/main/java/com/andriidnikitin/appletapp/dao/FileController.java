package com.andriidnikitin.appletapp.dao;

import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectPersistenceException;

public interface FileController {
	
	public void setFileForReading(String path) throws AppletProjectPersistenceException;
	
	public void setFileForWriting(String file) throws AppletProjectPersistenceException;
	
}
