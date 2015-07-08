package com.andriidnikitin.appletapp.dao;

import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;

public interface FileManageable {
	
	public void setFileForReading(String path) throws AppletProjectPersistenceException;
	
	public void setFileForWriting(String file) throws AppletProjectPersistenceException;
	
}
