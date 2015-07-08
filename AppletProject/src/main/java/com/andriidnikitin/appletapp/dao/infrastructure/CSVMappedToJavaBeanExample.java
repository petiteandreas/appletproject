package com.andriidnikitin.appletapp.dao.infrastructure;
import java.io.FileReader;
import java.util.List;
 

import com.andriidnikitin.appletapp.bl.Document;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
 
public class CSVMappedToJavaBeanExample

//TODO - use it to make own
{
   @SuppressWarnings({"rawtypes", "unchecked"})
   public static void main(String[] args) throws Exception
   {
      CsvToBean csv = new CsvToBean();
       
      String csvFilename = "data.csv";
      CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
       
      //Set column mapping strategy
      List list = csv.parse(setColumMapping(), csvReader);
       
      for (Object object : list) {
          Document employee = (Document) object;
          System.out.println(employee);
      }
   }
    
   @SuppressWarnings({"rawtypes", "unchecked"})
   private static ColumnPositionMappingStrategy setColumMapping()
   {
      ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
      strategy.setType(Document.class);
      String[] columns = new String[] {"id", "firstName", "lastName", "country", "age"};
      strategy.setColumnMapping(columns);
      return strategy;
   }
}