package com.andriidnikitin.appletapp.bl;

/**
 * Singletone class that holds file repositories and controls access to files.
 * @author Андрей
 *
 */
public class RepositoryHolder {
	
	private final static RepositoryHolder INSTANCE = new RepositoryHolder();	

	protected RepositoryHolder() {
		
	}
	
	public RepositoryHolder getInstance(){
		return INSTANCE;
	}
	
}
