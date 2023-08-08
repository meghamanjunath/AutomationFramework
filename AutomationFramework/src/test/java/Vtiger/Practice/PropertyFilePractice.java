package Vtiger.Practice;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
		//step 1:Load the document in Java readable format
		FileInputStream fis = new FileInputStream("C:\\Users\\Likith\\eclipse-workspace\\AutomationFramework\\src\\test\\resources\\CommonData.properties");
		
		
		//step 2:Create Object of properties class from Java.util
	    Properties pobj = new Properties();
	    
		//Step 3:Load the file into properties class
		pobj.load(fis);
		
		//Step 4:Provide the key and get the value
		String value =pobj.getProperty("password");
		System.out.println(value);

	}

}
