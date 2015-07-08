package com.andriidnikitin.appletapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	//TODO - include new tests to suite
   //FileTest.class, 
   //UserInterfaceTest.class, 
   DocumentServiceMultipleDataTest.class, 
   //DocumentCsvParserTest.class, 
   DocumentServiceTest.class
})
public class TestSuite {
}