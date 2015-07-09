package com.andriidnikitin.appletapp.ui;

import java.applet.Applet;
import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import com.andriidnikitin.appletapp.ui.infrastructure.DateField;
import com.andriidnikitin.appletapp.ui.model.PassportDetailsModel;
import com.andriidnikitin.appletapp.ui.model.PersonalDataModel;

public class InputFormApplet extends Applet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final PassportDetailsModel passport = new PassportDetailsModel();
	
	private final PersonalDataModel person = new PersonalDataModel();
	
	TextField Surname, Name, Patronym, City, Area, Region;	

	TextField passportSerial, passportId, registrator,registratorDepartment;	
	
	DateField dateOfRegistrating, birthday;//edit datefield 
	
	private GridLayout  mainLayout; 
	      
	public void init(){
		
		this.setName("Passport data input");

		mainLayout = new GridLayout(12,2);
		this.setLayout(mainLayout);
		
		
		//Font appletFont=new Font("Monospased",Font.BOLD, 20);
		//this.setFont(appletFont);
		
		Surname = new TextField(30);
		Name = new TextField(30);
		Patronym = new TextField(30);
		City = new TextField(50);
		Area = new TextField(50);
		Region = new TextField(50);	
		addToNameLayout(new Label("Surname:"));
		addToNameLayout(Surname);
		addToNameLayout(new Label("Name:"));	
		addToNameLayout(Name);
		addToNameLayout(new Label("Patronym:"));	
		addToNameLayout(Patronym);
		addToNameLayout(new Label("City:"));	
		addToNameLayout(City);
		addToNameLayout(new Label("Area:"));	
		addToNameLayout(Area);
		addToNameLayout(new Label("Region:"));	
		addToNameLayout(Region);
		this.setVisible(true);
	}

	int i = 0;
	int j=0;
	private void addToNameLayout(Component c) {
		this.add(c);
	}

	public void paint(Graphics g){
		int x=0,y=0,z=0;
		String s1,s2,s;
		g.drawString("¬ведите персональные данные:",10,50);
		try {
		    s1 = Surname.getText();
		    x = Integer.parseInt(s1);
		    s2 = Name.getText();
		    y = Integer.parseInt(s2);
		    }
		 catch(Exception e) {
			 UiManager.showErrorScreen("something gone wrong...");
		 }
		 z = x + y;
		 s =  String.valueOf(z);
		 g.drawString("—умма равна: ",10,75);
		 g.drawString(s,100,75);
	 }

	 public boolean action(Event event, Object obj){
		 repaint();
		 return true;
	 }	 
	
}
