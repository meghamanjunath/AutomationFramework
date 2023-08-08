package Vtiger.Practice;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable 
	{
		
		JavaUtility jutil = new JavaUtility();
		
		int value = jutil.getRandomNumber();
		System.out.println(value);
		
		System.out.println(jutil.getSystemDate());
		
		System.out.println(jutil.getSystemDateInFormat());
		
	    PropertyFileUtility putil = new PropertyFileUtility();
	    System.out.println(putil.getDataFromProprtyFile("url"));
	    
	    ExcelFileUtility eutil=new ExcelFileUtility();
	    String data = eutil.getdatafromExcel("Organization", 1, 2);
	    System.out.println(data);
	    
	    eutil.writedataintoexcel("sample", 3, 4,"Tiyaangowda");
	    System.out.println("data added");
	}

}
