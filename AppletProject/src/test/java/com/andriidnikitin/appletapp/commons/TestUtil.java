package com.andriidnikitin.appletapp.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.andriidnikitin.appletapp.bl.Document;

public class TestUtil {
	
	@SuppressWarnings("deprecation")
	public static Document generateValidSampleData(){

		Document sampleValidDoc = new Document();

		sampleValidDoc.setSurname("Nikitin-Markov");
		sampleValidDoc.setName("Andrii");
		sampleValidDoc.setPatronym("Dmytrovich");
		sampleValidDoc.setBirthday(new Date(94,15,11));
		sampleValidDoc.setBirthplaceCity("Vyshneve");
		sampleValidDoc.setBirthplaceArea("Kyiv-Sviatoshinsky");
		sampleValidDoc.setBirthplaceRegion("Kyiv");
		sampleValidDoc.setDateOfRegistrating(new Date(110,15,11));
		sampleValidDoc.setPassportSerial("SA");
		sampleValidDoc.setPassportId("123456");
		sampleValidDoc.setRegistrator("Regional Registrator");
		sampleValidDoc.setRegistratorDepartment("Kyiv-Sviatoshyn");
		
		return sampleValidDoc;
	}
	
	@SuppressWarnings("deprecation")
	public static List<Document> generateInvalidDataset() {
		
		Document validObject = generateValidSampleData();
		
		List<Document> result = new ArrayList<Document>();
		
		List<String> invalidStrings = new ArrayList<String>();
		
		invalidStrings.add(" ");
		invalidStrings.add("A b");
		invalidStrings.add("dummy");
		invalidStrings.add("1234A");
		invalidStrings.add("Dummy&");
		
		for (String invalidString: invalidStrings){
			
			validObject = generateValidSampleData();
			validObject.setSurname(invalidString);
			result.add(validObject);
			

			validObject = generateValidSampleData();
			validObject.setName(invalidString);
			result.add(validObject);

			validObject = generateValidSampleData();
			validObject.setPatronym((invalidString == null) ? invalidString : "1234");
			result.add(validObject);
						
		}
		
		Date invalidBirthdayAfterToday = new Date();
		invalidBirthdayAfterToday.setYear(116);
		Document invalidObject = generateValidSampleData();
		invalidObject.setBirthday(invalidBirthdayAfterToday);
		result.add(invalidObject);
		
		Date invalidRegistrationDateAfterToday = new Date();
		invalidRegistrationDateAfterToday.setYear(116); 
		invalidObject = generateValidSampleData();
		invalidObject.setDateOfRegistrating(invalidRegistrationDateAfterToday);
		result.add(invalidObject);
		
		long day = 24 * 60 * 60 * 1000;  
		invalidObject = generateValidSampleData();
		Date invalidRegistrationDateBeforeBirthday = invalidObject.getBirthday();
		long invalidRegistrationTime = invalidRegistrationDateBeforeBirthday.getTime() - day;		
		invalidObject.setDateOfRegistrating(new Date(invalidRegistrationTime));
		result.add(invalidObject);	
		
		return result;
	}
	

	public static List<Document> generateValidDataset() {
		
		List<Document> list = new ArrayList<Document>();

		Document newDocument = generateValidSampleData();
		newDocument.setPassportId("123459");
		newDocument.setName("Igor");
		list.add(newDocument);
		list.add(generateValidSampleData());
		return list ;		
	}
	
public static List<Document> generateCorruptedDataset() {
		return generateInvalidDataset().subList(0, 2) ;		
	}
	
	public static <T> boolean listsAreEqual(List<T> arg0, List<T> arg1){     
	   return ((arg0.containsAll(arg1)) && (arg1.containsAll(arg0)));
	}
}
