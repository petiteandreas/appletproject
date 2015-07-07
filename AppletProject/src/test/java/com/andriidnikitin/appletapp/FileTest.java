package com.andriidnikitin.appletapp;

import static org.junit.Assert.*;
import static com.andriidnikitin.appletapp.commons.TestUtil.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.dao.CsvDocumentWrapper;
import com.andriidnikitin.appletapp.dao.FileManager;
import com.andriidnikitin.appletapp.dao.FileManagerImpl;

public class FileTest {

	@Test
	public void wrapperWrapsDocumentsToValidCvsTest(){
		
		List<Document> list = generateValidDataset();     //given
		FileManager manager = new FileManagerImpl();
		
		File wrappedFile = CsvDocumentWrapper.wrap(list); //when
				
		assertTrue(manager.isValidCsvDocumentFile(wrappedFile)); //then		
	}
}
