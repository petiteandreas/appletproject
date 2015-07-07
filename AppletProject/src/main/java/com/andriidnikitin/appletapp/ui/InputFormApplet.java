package com.andriidnikitin.appletapp.ui;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.TextField;

public class InputFormApplet extends Applet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		TextField text1, text2;
	      
	      public void init(){
	           text1 = new TextField(8);
	           text2 = new TextField(8);
	           add(text1);
	           add(text2);
	           text1.setText("0");
	           text2.setText("0");
	      }

	      public void paint(Graphics g){
	          int x=0,y=0,z=0;
	          String s1,s2,s;
	          g.drawString("¬ведите персональные данные:",10,50);
	          try
	          {
	                 s1 = text1.getText();
	                 x = Integer.parseInt(s1);
	                 s2 = text2.getText();
	                 y = Integer.parseInt(s2);
	           }
	          catch(Exception e) {}
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
