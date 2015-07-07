package com.andriidnikitin.appletapp.dao;

import java.util.Date;

import com.andriidnikitin.appletapp.bl.Document;

public class DocumentCsvParser {
	
	public static String unparseCsvString(Document doc){
		StringBuilder result = new StringBuilder();
		String comma = ",";

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
		
		return result.toString();
	}
	
	public static String parseCsvString(Document doc){
		StringBuilder result = new StringBuilder();
		String comma = ",";

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
		
		return result.toString();
	}
	
	private static String unparseDate(Date d){
		String str = d.toString().replace(',', '@');
		return str;
	}
	
	private static Date parseDate(String str){
		Date d = new Date(str.replace('@', ','));
		return d;
	}

}
