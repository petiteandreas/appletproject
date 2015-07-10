package com.andriidnikitin.appletapp.ui.examples;

import java.applet.Applet;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.TestUtil;
import com.andriidnikitin.appletapp.ui.infrastructure.DocumentToTableMapper;
import com.andriidnikitin.appletapp.ui.infrastructure.TableUtil;

public class TableExample extends Applet{

	private static final long serialVersionUID = 1L;
	
	public void init() {
		
		JTable table = DocumentToTableMapper.getDocumentTable();
		
		for (Document doc :TestUtil.generateSampleSetOfValidDocs()) {
			TableUtil.addDocToTable(table, doc);
		}

		JScrollPane pane = new JScrollPane(table);
		add(pane);
	    setBackground(Color.yellow);	    
	}   
}
