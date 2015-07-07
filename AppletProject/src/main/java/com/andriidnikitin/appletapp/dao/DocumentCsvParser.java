package com.andriidnikitin.appletapp.dao;

import java.util.Date;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.AppletProjectInvalidDocException;

public class DocumentCsvParser {
	
	public static String unparseCsvString(Document doc) throws AppletProjectInvalidDocException{
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
			throw new AppletProjectInvalidDocException(e); 
		}
		
		return result.toString();
	}
	
	public static Document parseCsvString(String str) throws AppletProjectInvalidFileException{
		
		Document doc = new  Document();		
		String[] array = str.split(",");
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
			throw new AppletProjectInvalidFileException(e);
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
	private static Date parseDate(String str){
		Date d = null;
		try{
			d = new Date(str.replace('@', ','));
		} catch (Exception e){
			throw new IllegalArgumentException("Invalid data:" + str);
		}
		return d;
	}

}