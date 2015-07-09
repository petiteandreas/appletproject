package com.andriidnikitin.appletapp;

import static com.andriidnikitin.appletapp.commons.TestUtil.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.andriidnikitin.appletapp.bl.Document;

import static com.andriidnikitin.appletapp.bl.DocumentValidator.*;

public class DocumentCsvParserTest {
	
	
	/*@Test
	public void parsesValidDataTest(){
		
		Document doc = generateSampleValidDoc();//given
		
		try {									//when	
			String result = stringifyDoc(doc);
			doc = unstringifyDoc(result);
		} catch (AppletProjectInvalidDocException e1){
			e1.printStackTrace();
			fail();
		} catch (AppletProjectInvalidFileException e2){
			e2.printStackTrace();
			fail();
		}
		
		try {									//then			
			assertTrue(validateDoc(doc));
		} catch (AppletProjectInvalidDocException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void alertsImportingCorruptedDataTest(){
		List<String> corruptedDataset = generateSampleSetOfCorruptedStrigifiedDocs();//given
		int failed = 0;
		for (String str: corruptedDataset){	//when	
			try {
				unstringifyDoc(str);
				} catch (AppletProjectInvalidFileException e) {
						failed++;
				}
			}	
			assertEquals(failed, corruptedDataset.size());//then
		}	
		*/
}
