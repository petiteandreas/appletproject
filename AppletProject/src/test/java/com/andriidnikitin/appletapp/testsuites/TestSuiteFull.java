package com.andriidnikitin.appletapp.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.andriidnikitin.appletapp.DocumentServiceBasicFunctionalityTest;
import com.andriidnikitin.appletapp.DocumentServiceValidationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	//TODO - include new tests to suite
   //FileTest.class, 
   //UserInterfaceTest.class, 
   DocumentServiceBasicFunctionalityTest.class, 
   DocumentServiceValidationTest.class 
   //DocumentCsvParserTest.class, 
})
public class TestSuiteFull {
}