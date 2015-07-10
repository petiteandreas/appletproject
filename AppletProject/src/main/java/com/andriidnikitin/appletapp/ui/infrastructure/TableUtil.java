package com.andriidnikitin.appletapp.ui.infrastructure;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.andriidnikitin.appletapp.bl.Document;

public class TableUtil {
	
	public static void addDocToTable(JTable table, Document doc) {
		DefaultTableModel model = (DefaultTableModel)(table.getModel());			
		Vector<String> rowData = DocumentToTableMapper.docToList(doc);
		model.addRow(rowData);
		
	}

}
