package Vtiger.Practice;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelsheet {

	public static void main(String[] args) throws Throwable {
		
		//step1: load the file in java readable format
		FileInputStream fis = new FileInputStream("C:\\Users\\Likith\\eclipse-workspace\\AutomationFramework\\src\\test\\resources\\testdata.xlsx");
		
		//step2: Create a workbook for the file loaded
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3: navigate to required sheet
		Sheet sh = wb.getSheet("contact");
		
		//step4:navigate to required row
		Row rw = sh.getRow(1);
		
		//step4:navigate to required cell
		Cell ce = rw.getCell(2);
		
		//step5:capture the value inside the cell
		String value=ce.getStringCellValue();
		System.out.println(value);
	

	}

}
