package com.andriidnikitin.appletapp.ui.examples;


import java.applet.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class ReadFileApplet extends Applet {

	private static final long serialVersionUID = 3826575242310146657L;
String fileToRead = "test1.txt";
   StringBuffer strBuff;
   TextArea txtArea;
   Graphics g;
   public void init(){
      txtArea = new TextArea(100, 100);
      txtArea.setEditable(false);
      add(txtArea, "center");
      String prHtml = this.getParameter("fileToRead");
      if (prHtml != null) fileToRead = new String(prHtml);  
      readFile();
   }
   public void readFile(){
      String line;
      URL url = null;
      try{
         url = new URL(getCodeBase(), fileToRead);
      }
      catch(MalformedURLException e){}
      try{
         InputStream in = url.openStream();
         BufferedReader bf = new BufferedReader
         (new InputStreamReader(in));
         strBuff = new StringBuffer();
         while((line = bf.readLine()) != null){
            strBuff.append(line + "\n");
         }
         txtArea.append("File Name : " + fileToRead + "\n");
         txtArea.append(strBuff.toString());
      }
      catch(IOException e){
      e.printStackTrace();
   }
}
}