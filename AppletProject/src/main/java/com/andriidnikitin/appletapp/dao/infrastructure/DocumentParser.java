package com.andriidnikitin.appletapp.dao.infrastructure;

import java.util.Date;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.AppletProjectPersistenceException;
import com.andriidnikitin.appletapp.commons.AppletProjectServiceException;

public class DocumentParser {
	
	public static String stringifyDoc(Document doc) throws AppletProjectServiceException{
		StringBuilder result = new StringBuilder();
		String comma = ",";

		try{
			result.append(doc.getSurname()).append(comma);
			result.append(doc.getName()).append(comma);
			result.append(doc.getPatronym()).append(comma);
			result.append(unparseDate(doc.getBirthday())).append(comma);
			result.append(doc.getBirthplaceCity()).append(comma);
			result.append(doc.getBirthplaceArea()).append(comma);
			result.append(doc.getBirthplaceRegion()).append(comma);
			result.append(doc.getPassportSerial()).append(comma);
			result.append(doc.getPassportId()).append(comma);
			result.append(doc.getRegistrator()).append(comma);
			result.append(doc.getRegistratorDepartment()).append(comma);
			result.append(unparseDate(doc.getDateOfRegistrating()));
		} catch (Exception e){
			throw new AppletProjectServiceException("Invalid document"); 
		}
		
		return result.toString();
	}
	
	public static Document unstringifyDoc(String str) throws AppletProjectPersistenceException{
		
		Document doc = new  Document();	
		String[] array = null;	
		try{
			array = str.split(",");
		} catch (NullPointerException e){
			throw new AppletProjectPersistenceException("One or more fields of string is null.");
		}
		
		int i = 0;
		
		try{
			doc.setSurname(array[i++]);
			doc.setName(array[i++]);
			doc.setPatronym(array[i++]);
			doc.setBirthday(parseDate(array[i++]));
			doc.setBirthplaceCity(array[i++]);
			doc.setBirthplaceArea(array[i++]);
			doc.setBirthplaceRegion(array[i++]);
			doc.setPassportSerial(array[i++]);
			doc.setPassportId(array[i++]);
			doc.setRegistrator(array[i++]);
			doc.setRegistratorDepartment(array[i++]);
			doc.setDateOfRegistrating(parseDate(array[i++]));
			
		} catch (IndexOutOfBoundsException e){
			throw new AppletProjectPersistenceException("Inconsistent record:" + str);
		}
		
		return doc;
	}
	
	private static String unparseDate(Date d){
		
		if (d==null){
			throw new IllegalArgumentException("Date cannot be null."); 
		}
		@SuppressWarnings("deprecation")
		String str = d.toGMTString().replace(',', '@');
		return str;
	}
	
	@SuppressWarnings("deprecation")
	private static Date parseDate(String str) throws AppletProjectPersistenceException{
		Date d = null;
		try{
			d = new Date(str.replace('@', ','));
		} catch (Exception e){
			throw new AppletProjectPersistenceException("Invalid data:" + str);
		}
		return d;
	}

}
