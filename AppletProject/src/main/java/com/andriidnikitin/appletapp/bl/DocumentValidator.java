package com.andriidnikitin.appletapp.bl;

import java.util.Date;

import com.andriidnikitin.appletapp.commons.AppletProjectInvalidDocException;

public class DocumentValidator {
		
	public static boolean validateDoc(Document doc) throws AppletProjectInvalidDocException{
		
		if (doc == null){
			throw new AppletProjectInvalidDocException();
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
				if (!isValidNaming(str)){
					return false;
				}
			}
		} catch (IndexOutOfBoundsException e){
			throw e;
		}
		return true;
	}

	private static boolean validPassportCode(Document doc) {
		String numericRegex = "^[0-9]+$"; 
		String letterRegex = "^[a-zA-Zà-ÿÀ-ß]+$";
		
		if (!doc.getPassportId().matches(numericRegex)){
			return false;
		}
		if (!doc.getPassportSerial().matches(letterRegex)){
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
		
		if ((doc.getPatronym() != null) && (!isValidNaming(doc.getPatronym()))){
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

	private static boolean isValidNaming(String string) {
		if (string == null){
			return false;
		}
		char firstLetter = string.charAt(0);
		if (!Character.isUpperCase(firstLetter))
				return false;
		for (int i = 1; i < string.length(); i++){
			char c =  string.charAt(i);
			if (!Character.isLowerCase(c) && c!='-')
				return false;
		}
		return (!string.contains("--"));
	}
}
