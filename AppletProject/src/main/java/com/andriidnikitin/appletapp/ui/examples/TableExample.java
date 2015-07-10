package com.andriidnikitin.appletapp.ui.examples;

import java.applet.Applet;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.andriidnikitin.appletapp.bl.Document;
import com.andriidnikitin.appletapp.commons.TestUtil;
import com.andriidnikitin.appletapp.ui.infrastructure.DocumentToTableMapper;
import com.andriidnikitin.appletapp.ui.infrastructure.TableUtil;

public class TableExample extends Applet{

	private static final long serialVersionUID = 1L;
	
	public void init() {
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JTable table = DocumentToTableMapper.getDocumentTable();		
		JScrollPane pane = new JScrollPane(table);		
		add(pane);
		
		for (Document doc :TestUtil.generateSampleSetOfValidDocs()) {
			TableUtil.addDocToTable(table, doc);
		}
	    setBackground(Color.yellow);	    
	}   
}
