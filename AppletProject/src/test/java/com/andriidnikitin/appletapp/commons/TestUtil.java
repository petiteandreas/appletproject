package com.andriidnikitin.appletapp.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectServiceException;
public class TestUtil {
	
	private static final String UNPARSEABLE_TO_DATE = "rvt5bb56vbu";

	@SuppressWarnings("deprecation")
	public static Document generateSampleValidDoc(){

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
		sampleValidDoc.setRegistrar("Regional Registrator");
		sampleValidDoc.setRegistrarDepartment("Kyiv-Sviatoshyn");
		
		return sampleValidDoc;
	}
	
	@SuppressWarnings("deprecation")
	public static List<Document> generateSampleSetOfInvalidDocs() {
		
		Document validObject = generateSampleValidDoc();
		
		List<Document> result = new ArrayList<Document>();
		
		List<String> invalidStrings = new ArrayList<String>();
		
		invalidStrings.add(" ");
		invalidStrings.add("A b");
		invalidStrings.add("dummy");
		invalidStrings.add("1234A");
		invalidStrings.add("Dummy&");
		
		for (String invalidString: invalidStrings){
			
			validObject = generateSampleValidDoc();
			validObject.setSurname(invalidString);
			result.add(validObject);
			

			validObject = generateSampleValidDoc();
			validObject.setName(invalidString);
			result.add(validObject);

			validObject = generateSampleValidDoc();
			validObject.setPatronym((invalidString == null) ? invalidString : "1234");
			result.add(validObject);
						
		}
		
		Date invalidBirthdayAfterToday = new Date();
		invalidBirthdayAfterToday.setYear(116);
		Document invalidObject = generateSampleValidDoc();
		invalidObject.setBirthday(invalidBirthdayAfterToday);
		result.add(invalidObject);
		
		Date invalidRegistrationDateAfterToday = new Date();
		invalidRegistrationDateAfterToday.setYear(116); 
		invalidObject = generateSampleValidDoc();
		invalidObject.setDateOfRegistrating(invalidRegistrationDateAfterToday);
		result.add(invalidObject);
		
		long day = 24 * 60 * 60 * 1000;  
		invalidObject = generateSampleValidDoc();
		Date invalidRegistrationDateBeforeBirthday = invalidObject.getBirthday();
		long invalidRegistrationTime = invalidRegistrationDateBeforeBirthday.getTime() - day;		
		invalidObject.setDateOfRegistrating(new Date(invalidRegistrationTime));
		result.add(invalidObject);	
		
		result.addAll(generateSampleSetOfCorruptedDocs());
		
		return result;
	}
	

	public static List<Document> generateSampleSetOfValidDocs() {
		
		List<Document> list = new ArrayList<Document>();

		Document newDocument = generateSampleValidDoc();
		newDocument.setPassportId("123459");
		newDocument.setName("Igor");
		list.add(newDocument);
		list.add(generateSampleValidDoc());
		return list ;		
	}
	
public static List<Document> generateSampleSetOfCorruptedDocs() {
		List<Document> list = new ArrayList<Document>();
		Document invalidDoc;

		invalidDoc = generateSampleValidDoc();
		invalidDoc.setBirthday(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setBirthplaceArea(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setBirthplaceCity(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setBirthplaceRegion(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setDateOfRegistrating(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setName(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setPassportId(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setPassportSerial(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setPatronym(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setRegistrar(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setRegistrarDepartment(null);
		list.add(invalidDoc);
		
		invalidDoc = generateSampleValidDoc();
		invalidDoc.setSurname(null);
		list.add(invalidDoc);
		
		list.add(null);
		
		return list;
	}
	
	public static <T> boolean listsAreEqual(List<T> arg0, List<T> arg1){     
		if (!((arg0 == null) && (arg1 == null))){
			return ((arg0.containsAll(arg1)) && (arg1.containsAll(arg0)) 
					&& (arg0.size() == arg1.size()));
		}
		return false;
	}
	
	public static List<String> generateSampleSetOfCorruptedStrigifiedDocs() {
		List<String> list = new LinkedList<String>();
		String stringifiedValidDoc = null;
		
		try {
			stringifiedValidDoc = stringifyDoc(generateSampleValidDoc());
		} catch (AppletProjectServiceException e) {
			e.printStackTrace();
		}
		
		addElementsWithNullFields(list, stringifiedValidDoc);

		addRecordsWithInvalidDates(list, stringifiedValidDoc);
				
		list.add(null);
		
		return list;
	}

	public static String stringifyDoc(Document doc) throws AppletProjectServiceException{
		StringBuilder result = new StringBuilder();
		String comma = ",";

		try{
			result.append(doc.getSurname()).append(comma);
			result.append(doc.getName()).append(comma);
			result.append(doc.getPatronym()).append(comma);
			result.append(DateParser.unparseDate(doc.getBirthday())).append(comma);
			result.append(doc.getBirthplaceCity()).append(comma);
			result.append(doc.getBirthplaceArea()).append(comma);
			result.append(doc.getBirthplaceRegion()).append(comma);
			result.append(doc.getPassportSerial()).append(comma);
			result.append(doc.getPassportId()).append(comma);
			result.append(doc.getRegistrar()).append(comma);
			result.append(doc.getRegistrarDepartment()).append(comma);
			result.append(DateParser.unparseDate(doc.getDateOfRegistrating()));
		} catch (Exception e){
			throw new AppletProjectServiceException("Invalid document"); 
		}
		
		return result.toString();
	}
	

	private static void addRecordsWithInvalidDates(List<String> list,
			String stringifiedValidDoc) {
		list.add(replaceStringifiedDocElementWith(stringifiedValidDoc, 3,UNPARSEABLE_TO_DATE));
		
		list.add(replaceStringifiedDocElementWith(stringifiedValidDoc, 11,UNPARSEABLE_TO_DATE));
	}

	private static void addElementsWithNullFields(List<String> list,
			String stringifiedValidDoc) {
		for (int i=0; i<12; i++){
			list.add(replaceStringifiedDocElementWith(stringifiedValidDoc, i, ""));
		}
	}
	
	private static String replaceStringifiedDocElementWith(String doc, 
			int position, String holder){
		StringBuilder newDoc = new StringBuilder();
		String[] array = doc.toString().split(",");
		array[position] = holder;
		for (String element: array){
			newDoc.append(element).append(",");
		}
		int positionOfLastelement = newDoc.length() - 1;
		newDoc.deleteCharAt(positionOfLastelement);
		return newDoc.toString() ;
		
	}
	
}
