package com.andriidnikitin.appletapp.commons;

public class StringParser {

	private static final String LETTER_REGEX = "^[a-zA-Zà-ÿÀ-ß]+$";

	 private static final String NUMERIC_REGEX = "^[0-9]+$";
	 
	 private static final String FILENAME_REGEX = " ^[a-zA-Zà-ÿÀ-ß0-9._ -]+$"; 
	
	public static boolean containsOnlyLetters(String s) {
		
		return s.matches(LETTER_REGEX);
	}


	public static boolean validPrefix(String s) {
		return s.matches(FILENAME_REGEX);
	}
	
	public static boolean containsOnlyNumbers(String s) {
		return s.matches(NUMERIC_REGEX);
	}
	
	public static boolean isValidName(String string) {
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
	
	public static boolean isValidFilename(String filePath) {		
		if (filePath == null) {
			return false;
		}
		
		try {
			String[] parts = filePath.split(".");
			if (!((StringParser.validPrefix(parts[0]))&&(!"csv".equals(parts[1])))){
				return false;
			}
		} catch (Exception e){
			return false;
		}
		
		return true;
	}

}
