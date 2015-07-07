package com.andriidnikitin.appletapp;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.bl.DocumentService;
import com.andriidnikitin.appletapp.bl.DocumentServiceImpl;
import com.andriidnikitin.appletapp.commons.AppletProjectInvalidDocException;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;

import static  com.andriidnikitin.appletapp.commons.TestUtil.*;
import static com.andriidnikitin.appletapp.bl.DocumentValidator.*;
import static org.junit.Assert.*;


public class DocumentServiceMultipleDataTest {
	
	@Test
	public void addValidMultipleDataTest(){
		
		DocumentService service = new DocumentServiceImpl(); //given
		
		List<Document> list = generateValidDataset(); 
		
		List<Document> failedToAdd = service.addDocuments(list); //when
		
		assertTrue(failedToAdd.isEmpty());//then		
		
	}
	
	@Test
	public void addInvalidMultipleDataTest(){
			
		DocumentService service = new DocumentServiceImpl(); //given
		
		List<Document> listOfInvalidData = generateInvalidDataset(); 			

		List<Document> failedToAdd = service.addDocuments(listOfInvalidData); //when
		
		assertTrue(listsAreEqual(failedToAdd, listOfInvalidData));//then		
		 
	}
	
	@Test
	public void addMixedMultipleDataTest(){
			
		DocumentService service = new DocumentServiceImpl(); 				//given
		
		List<Document> validDataset = generateValidDataset();
		List<Document> invalidDataset = generateInvalidDataset();
		
		List<Document> listOfData = new ArrayList<Document>();		
		listOfData.addAll(validDataset);		
		listOfData.addAll(invalidDataset);

		List<Document> failedToAdd = service.addDocuments(listOfData);    //when
		
		assertTrue(listsAreEqual(failedToAdd, invalidDataset));				//then
		try {
			assertTrue(service.containsAllDocs(validDataset));
		} catch (AppletProjectPersistenceException e) {			
			e.printStackTrace();
			fail();
		}
		 
	}
	
	@Test
	public void addNoDataTest(){
		
		DocumentService service = new DocumentServiceImpl(); 				//given
		
		List<Document> emptyListData = new ArrayList<Document>(); 			

		List<Document> failedToAdd = service.addDocuments(emptyListData); //when
		
		assertTrue(failedToAdd.isEmpty());									//then		
		
	}
	
	@Test
	public void testingOfUtilFunctionality(){
		
		List<String> list1 = new ArrayList<String>();	//given
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new ArrayList<String>();
		
		for (int i=0; i<10; i++){ 						//when
			list1.add("element"+i);
			list2.add("element"+i);
			list3.add("element");
			list4.add("element"+i);
		}
		list4.remove(0);
		
		assertTrue(listsAreEqual(list1, list2));		//then
		assertTrue(listsAreEqual(list1, list2));
		assertFalse(listsAreEqual(list1, list3));
		assertFalse(listsAreEqual(list1, list4));
		assertFalse(listsAreEqual(list1, list5));
		

		for (Document doc: generateValidDataset()){
			try {
				assertTrue(validateDoc(doc));
			} catch (AppletProjectInvalidDocException e) {				
				e.printStackTrace();
				fail(); 
			} 
		}
	}
}
