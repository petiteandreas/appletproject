package com.andriidnikitin.appletapp.dao.infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectPersistenceException;

public class CsvDocumentParser {	
	
	public static void writeDocumentsToFile(List<Document> documents, File file){
		
	}
		
	public static List<Document> readAllDocumentsFromFile(File file) 
			throws AppletProjectPersistenceException{
		List<Document> list;
		
		CsvToBean<Document> csv = new CsvToBean<Document>();
	    CSVReader csvReader;
		try {
			csvReader = new CSVReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new AppletProjectPersistenceException(e);
		}
	       
	    //Set column mapping strategy
	    list = csv.parse(setColumMapping(), csvReader);	     
	    
	    return list;
	    
	   }
	    
	   private static ColumnPositionMappingStrategy<Document> setColumMapping(){
	      ColumnPositionMappingStrategy<Document> strategy = 
	    		  new ColumnPositionMappingStrategy<Document>();
	      strategy.setType(Document.class);
	      String[] columns = new String[] {"id", "firstName", "lastName", "country", "age"};
	      strategy.setColumnMapping(columns);
	      return strategy;
	   }
}
