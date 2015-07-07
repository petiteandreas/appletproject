package com.andriidnikitin.appletapp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.bl.DocumentService;
import com.andriidnikitin.appletapp.bl.DocumentServiceImpl;
import com.andriidnikitin.appletapp.commons.AppletProjectUnableToAddException;

import static  com.andriidnikitin.appletapp.commons.TestUtil.*;

public class DocumentServiceTest {

	@Test
	public void addCorrectDataAndCheckAddingTest(){
				
		DocumentService service = new DocumentServiceImpl();//given
		
		Document  sampleValidDoc = generateValidSampleData();	//when			
				
		try {												//then						
			assertTrue(service.addDocument(sampleValidDoc));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}			
		
		try {												//and				
			assertTrue(service.containsDoc(sampleValidDoc));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}	
	
	@Test
	public void testValidation(){

		DocumentService service = new DocumentServiceImpl();//given
		
		Document  sampleValidDoc = generateValidSampleData(); //when
		List<Document> invalidObjects = generateInvalidDataset();
		
		try {													//then
			assertTrue(service.documentIsValid(sampleValidDoc));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}				
		
		try {												
			for (Document doc: invalidObjects){	
				service.printDocument(System.out, doc);
					assertFalse(
							service.documentIsValid(doc));			
			}
		}  catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void checkDuplicationsTest(){
		
		DocumentService service = new DocumentServiceImpl();//given
		Document originalObject = generateValidSampleData();
		
		try {												
			service.addDocument(originalObject);
		} catch (Exception e) {			
			e.printStackTrace();
			fail();
		}		

		Document duplicatedObject = originalObject;//when	
		
		
		try {										 //then								
			assertTrue(service.containsDoc(duplicatedObject));
			service.addDocument(duplicatedObject);
			fail();
		} catch (AppletProjectUnableToAddException e) {			
			return;
		} catch (Exception e) {	
			fail();
		}
		
	}
	
	@Test
	public void addValidMultipleDataTest(){
		DocumentService service = new DocumentServiceImpl(); //given
		
		List<Document> list = new ArrayList<Document>(); 
		
		Document newDocument = generateValidSampleData();
		newDocument.setPassportId("ZZ");
		newDocument.setName("Igor");

		List<Document> failedToAdd = service.addDocuments(list); //when
		
		failedToAdd.isEmpty();//then		
		
	}
	
	@Test
	public void addInvalidMultipleDataTest(){
		DocumentService service = new DocumentServiceImpl(); //given
		
		List<Document> listOfInvalidData = generateInvalidDataset(); 			

		List<Document> failedToAdd = service.addDocuments(listOfInvalidData); //when
		
		failedToAdd.equals(listOfInvalidData);//then		
		
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