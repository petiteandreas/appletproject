package com.andriidnikitin.appletapp.bl;

import java.util.Date;

import com.andriidnikitin.appletapp.commons.StringParser;
import com.andriidnikitin.appletapp.commons.exceptions.AppletProjectServiceException;

public class DocumentValidator {
		
	public static boolean validateDoc(Document doc) throws AppletProjectServiceException{
		
		if (!(nullFieldValidation(doc))){
			return false;
		}
		
		if (!validNameSurnamePatronym(doc)){
			return false;
		}
		
		if (doc.getBirthday().after((new Date()))){
			return false;
		}
		
		if (!validDateOfRegistrating(doc)){
			return false;
		}	
		
		if (!validRegistrator(doc)){
			return false;
		}
		
		if (!validRegion(doc)){
			return false;
		}
		
		if (!validPassportCode(doc)){
			return false;
		}
		
		return true;
	}

	private static boolean nullFieldValidation(Document doc) {
		if (doc == null ){
			return false;
		}
		
		if (documentHasNullFields(doc)){
			return false;
		}				
		
		return true;
	}

	private static boolean documentHasNullFields(Document doc) {
		return !(
				(doc.getBirthday() != null)
				&& (doc.getBirthplaceArea() != null) 
				&& (doc.getBirthplaceCity() != null) 
				&& (doc.getBirthplaceRegion() != null) 
				&& (doc.getDateOfRegistrating() != null) 
				&& (doc.getName() != null) 
				&& (doc.getPassportId() != null) 
				&& (doc.getPassportSerial() != null) 
				&& (doc.getPatronym() != null) 
				&& (doc.getRegistrator() != null) 
				&& (doc.getRegistratorDepartment() != null) 
				&& (doc.getSurname() != null) 
				);
	}

	private static boolean validRegistrator(Document doc) {
		
		if (!isValidNaming(doc.getRegistrator().split("[ -]"))){
			return false;
		}
		
		if (!isValidNaming(doc.getRegistratorDepartment().split("[ -]"))){
			return false;
		}
		
		return true;
	}

	private static boolean isValidNaming(String[] split) {
		if (split.length<1)
			return false;
		try{
			for (String str: split){
				if (str.length()<1){
					return false;
				}
				if (!StringParser.isValidName(str)){
					return false;
				}
			}
		} catch (IndexOutOfBoundsException e){
			throw e;
		}
		return true;
	}

	private static boolean validPassportCode(Document doc) {
				
		if (!StringParser.containsOnlyNumbers(doc.getPassportId())){
			return false;
		}
		
		if (!StringParser.containsOnlyLetters(doc.getPassportSerial())){
			return false;
		}
		
		return true;
		
	}

	private static boolean validRegion(Document doc) {
		
		if (!isValidNaming(doc.getBirthplaceCity().split("[ -]"))){
			return false;
		}
		
		if (!isValidNaming(doc.getBirthplaceArea().split("[ -]"))){
			return false;
		} 		
		
		if (!isValidNaming(doc.getBirthplaceRegion().split("[ -]"))){
			return false;
		}		
		
		return true;
	}

	private static boolean validNameSurnamePatronym(Document doc) {
		if (doc.getName() == null){
			return false;
		}
		
		if (doc.getSurname() == null){
			return false;
		}

		if (!isValidNaming(doc.getSurname().split("[ -]"))){
			return false;
		}
		
		if (!isValidNaming(doc.getName().split("[ -]"))){
			return false;
		}
		
		if ((doc.getPatronym() != null) && (!StringParser.isValidName(doc.getPatronym()))){
			return false;
		}
		
		return true;
	}

	private static boolean validDateOfRegistrating(Document doc) {
		
		if (doc.getDateOfRegistrating().after((new Date()))){
			return false;
		}
		
		if (doc.getDateOfRegistrating().before((doc.getBirthday()))){
			return false;
		}
		
		return true;
		
	}
	
}
