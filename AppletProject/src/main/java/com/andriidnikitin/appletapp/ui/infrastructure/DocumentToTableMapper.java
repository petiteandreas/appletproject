package com.andriidnikitin.appletapp.ui.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.andriidnikitin.appletapp.bl.Document;


public class DocumentToTableMapper {
	
	/**
	 * Returns vector, prepared to display in table.
	 * Structure -
	 * 
	 * Passport serial,
	 * Passport ID,
	 * Surname,
	 * Name,
	 * Patronym,
	 * Birthday,
	 * Birthplace city,
	 * Birthplace area,
	 * Birthplace region,
	 * Date of registration,
	 * Registrar,
	 * Registrar's department.
	 * 
	 * @param element is element that being transformed to a Vector. 
	 * @return is a result vector. if returning null, record is invalid.
	 */
	public static Vector<String> docToList(Document element) {
		try {
			Vector<String> result = new Vector<String>();
			result.add(element.getPassportSerial());
			result.add(element.getPassportId());
			result.add(element.getSurname());
			result.add(element.getName());
			result.add(element.getPatronym());
			result.add(prepareDate(element.getBirthday()));
			result.add(element.getBirthplaceCity());
			result.add(element.getBirthplaceArea());
			result.add(element.getBirthplaceRegion());
			result.add(prepareDate(element.getDateOfRegistrating()));
			result.add(element.getRegistrar());
			result.add(element.getRegistrarDepartment());
			return result;		
		} catch (Exception e) {
			return null;	
		}
	}
	
	@SuppressWarnings("deprecation")
	private static String prepareDate(java.util.Date d){
		StringBuilder result = new StringBuilder();
		result.append(d.getDate());
		result.append(".");
		result.append(d.getMonth());
		result.append(".");
		result.append(d.getYear() + 1900);
		return result.toString();
		
	}

	public static JTable getDocumentTable(){
		  DefaultTableModel model = new DefaultTableModel(); 
		  
		  for (String column: getListOfColumns()){
			  model.addColumn(column);
		  }

		  JTable table = new JTable(model);
	      return table;
	}
	
	public static String[] getColumns(){
		return (String[])getListOfColumns().toArray();
	}
	
	private static List<String> getListOfColumns() {
		List<String> result = new ArrayList<String>();
		result.add("Serial");
		result.add("ID");
		result.add("Surname");
		result.add("Name");
		result.add("Patronym");
		result.add("Birthday");
		result.add("Birth city");
		result.add("Birth area");
		result.add("Birth region");
		result.add("Register date");
		result.add("Registrar");
		result.add("Department");
		return result ;
	}
}
