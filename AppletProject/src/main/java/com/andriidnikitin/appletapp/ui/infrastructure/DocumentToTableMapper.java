package com.andriidnikitin.appletapp.ui.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.andriidnikitin.appletapp.bl.Document;


public class DocumentToTableMapper {
	
	@SuppressWarnings({ "deprecation" })
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
			result.add(element.getBirthday().toGMTString());
			result.add(element.getBirthplaceCity());
			result.add(element.getBirthplaceArea());
			result.add(element.getBirthplaceRegion());
			result.add(element.getDateOfRegistrating().toGMTString());
			result.add(element.getRegistrar());
			result.add(element.getRegistrarDepartment());
			return result;		
		} catch (Exception e) {
			return null;	
		}
	}

	public static JTable getDocumentTable(){
		  DefaultTableModel model = new DefaultTableModel(); 
		  
		  for (String column: getListOfColumns()){
			  model.addColumn(column);
		  }

		  JTable table = new JTable(model);
	      table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	      return table;
	}
	
	public static String[] getColumns(){
		return (String[])getListOfColumns().toArray();
	}
	
	private static List<String> getListOfColumns() {
		List<String> result = new ArrayList<String>();
		result.add("Passport serial");
		result.add("Passport ID");
		result.add("Surname");
		result.add("Name");
		result.add("Patronym");
		result.add("Birthday");
		result.add("Birthplace city");
		result.add("Birthplace area");
		result.add("Birthplace region");
		result.add("Date of registration");
		result.add("Registrar");
		result.add("Registrar's department");
		return result ;
	}
}
