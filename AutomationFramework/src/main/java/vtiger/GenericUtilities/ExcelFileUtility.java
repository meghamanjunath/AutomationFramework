package vtiger.GenericUtilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	

	/**
	 * this method will read data from excel sheet based on sheet name,row no and cell no given by caller
	 * @param sheetName
	 * @param rowno
	 * @param celno
	 * @return value
	 * @throws Throwable 
	 * @throws IOException 
	 */
	
	public String getdatafromExcel(String sheetName,int rowno,int celno) throws Throwable 
	{
		
	     FileInputStream fis = new FileInputStream(IConstants.ExcelFilepath);
		 Workbook wb =WorkbookFactory.create(fis);
		 String value = wb.getSheet(sheetName).getRow(rowno).getCell(celno).getStringCellValue();
		 return value;
	}
	/**
	 * 
	 * @param SheetName
	 * @param rowno
	 * @param celno
	 * @param data
	 * @throws Throwable
	 */
	
	public void writedataintoexcel(String SheetName,int rowno,int celno,String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IConstants.ExcelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet(SheetName);
		Row rw = sh.createRow(rowno);
	    Cell cl = rw.createCell(celno); 
	    cl.setCellValue(data);
	    
	    FileOutputStream fos = new FileOutputStream(IConstants.ExcelFilepath);
	    wb.write(fos); //action
	    wb.close();
		
	}
	
	public Object[][] readMultipleData(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IConstants.ExcelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheetname);
		 int lastRow = sh.getLastRowNum();   //capture no of rows
	     int lastcel = sh.getRow(0).getLastCellNum();   //capture the no of cells
		 
	     Object[][] data = new Object[lastRow][lastcel];
	     
	     for(int i=0;i<lastRow;i++)    //for row navigation
	     {
	    	for(int j=0;j<lastcel;j++)  //for cell navigation
	    	{
	    		data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
	    	}
	     }
		return data;
	}	
		
	
	
}
