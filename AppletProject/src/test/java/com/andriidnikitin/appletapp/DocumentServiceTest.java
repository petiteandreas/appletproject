package com.andriidnikitin.appletapp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.bl.DocumentService;
import com.andriidnikitin.appletapp.bl.DocumentServiceWithLocalAndExternalRepositories;
import com.andriidnikitin.appletapp.commons.AppletProjectServiceException;

import static  com.andriidnikitin.appletapp.commons.TestUtil.*;
import static com.andriidnikitin.appletapp.bl.DocumentValidator.*;

public class DocumentServiceTest {

	@Test
	public void addCorrectDataAndCheckAddingTest(){
				
		DocumentService service = new DocumentServiceWithLocalAndExternalRepositories();//given
		
		List<Document> docs = new ArrayList<Document>();	//when	
		docs.add(generateSampleValidDoc());
				
		try {												//then						
			service.addDocuments(docs);
		} catch (Exception e) {
			fail();
		}			
		
		try {												//and				
			assertTrue(service.containsAllDocs(docs));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}	
	
	@Test
	public void testValidation(){
		
		Document  sampleValidDoc = generateSampleValidDoc(); //given
		List<Document> invalidObjects = generateSampleSetOfValidDocs();//when
		
		try {													//then
			assertTrue(validateDoc(sampleValidDoc));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}				
		
		try {												
			for (Document doc: invalidObjects){	
					assertFalse(validateDoc(doc));			
			}
		}  catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void checkDuplicationsTest(){
		
		DocumentService service = new DocumentServiceWithLocalAndExternalRepositories();//given		
		List<Document> docs = new ArrayList<Document>();	
		docs.add(generateSampleValidDoc());
		
		try {												
			service.addDocuments(docs);
		} catch (Exception e) {			
			e.printStackTrace();
			fail();
		}		

		List<Document> duplicatedDocs = docs;//when	
		
		
		try {										 //then								
			assertTrue(service.containsAllDocs(duplicatedDocs));			
			assertTrue(listsAreEqual(duplicatedDocs, service.addDocuments(duplicatedDocs)));
		} catch (AppletProjectServiceException e) {			
			return;
		} catch (Exception e) {	
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void addValidMultipleDataTest(){
		DocumentService service = new DocumentServiceWithLocalAndExternalRepositories(); //given
		
		List<Document> list = new ArrayList<Document>(); 
		
		Document newDocument = generateSampleValidDoc();
		newDocument.setPassportId("ZZ");
		newDocument.setName("Igor");

		List<Document> failedToAdd;
		try {
			failedToAdd = service.addDocuments(list);//when				
			failedToAdd.isEmpty();//then	
		} catch (AppletProjectServiceException e) {
			fail();
		} 
		
	}
	
	@Test
	public void addInvalidMultipleDataTest(){
		DocumentService service = new DocumentServiceWithLocalAndExternalRepositories(); //given
		
		List<Document> listOfInvalidData = generateSampleSetOfValidDocs(); 			

		List<Document> failedToAdd;
		try {
			failedToAdd = service.addDocuments(listOfInvalidData); //when			
			assertTrue(listsAreEqual(failedToAdd,listOfInvalidData));//then	
		} catch (AppletProjectServiceException e) {
			fail();
		}	
		
	}
	
	/*
	@Test
	public void testRegexValidation(){
		String numericRegex = "^[0-9]+$"; 
		String letterRegex = "^[a-zA-Zà-ÿÀ-ß]+$";
		
		if (!"XY".matches(letterRegex))
			fail();
		if (!"123456".matches(numericRegex))
			fail();
	}
	*/
	
	////////////////////////private methods begin/////////////////////////////////////////
	
	//TODO - use Mockito.Matchers instead 
	// - http://mockito.googlecode.com/hg-history/1.6/javadoc/org/mockito/Matchers.html
}