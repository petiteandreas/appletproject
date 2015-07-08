package com.andriidnikitin.appletapp;

import static org.junit.Assert.*;
import static com.andriidnikitin.appletapp.commons.TestUtil.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.dao.RepositoryManagable;
import com.andriidnikitin.appletapp.dao.FileManager;
import com.andriidnikitin.appletapp.dao.infrastructure.DocumentWrapper;

public class FileTest {

	@Test
	public void wrapperWrapsDocumentsToValidCvsTest(){
		
		List<Document> list = generateSampleSetOfValidDocs();     //given
		RepositoryManagable manager = new FileManager();
		
		File wrappedFile = DocumentWrapper.wrap(list); //when
				
		assertTrue(manager.isValidCsvDocumentFile(wrappedFile)); //then		
	}
}
