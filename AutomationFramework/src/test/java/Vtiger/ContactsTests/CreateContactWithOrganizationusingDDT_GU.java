package Vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrganizationusingDDT_GU {

	
	public static void main(String[] args) throws Throwable {
		
		
		 //Create object of required Utilities
		  JavaUtility jUtil = new JavaUtility();
		  ExcelFileUtility eUtil = new ExcelFileUtility();
		  PropertyFileUtility pUtil = new PropertyFileUtility();
		  WebDriverUtility wUtil = new WebDriverUtility();
		  
		  
		  WebDriver driver = null;
	
		      //step1: Read all the necessary data
		      /*Read data from propertyfile -common data */
		      String BROWSER = pUtil.getDataFromProprtyFile("browser");
		      String URL = pUtil.getDataFromProprtyFile("url");
		      String USERNAME = pUtil.getDataFromProprtyFile("username");
		      String PASSWORD = pUtil.getDataFromProprtyFile("password");
		      
		    /*Read data from excel sheet-Test data*/
		      String ORGNAME = eUtil.getdatafromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		      String LASTNAME = eUtil.getdatafromExcel("Contact", 4, 2);
		
		     //Step2:launch the browser -driver is acting based on runtime data -runtime polymorphism
		      if(BROWSER.equalsIgnoreCase("chrome"))
		      {
		    	  //WebDriverManager.chromedriver().setup();
		    	  driver=new ChromeDriver();
		    	  System.out.println(BROWSER+"---------Browser launched");
		      }
		      else if(BROWSER.equalsIgnoreCase("firefox"))
		      {

		    	  //WebDriverManager.firefoxdriver().setup();
		    	  driver=new FirefoxDriver();
		    	  System.out.println(BROWSER+"---------Browser launched");
		      }
		      else if(BROWSER.equalsIgnoreCase("edge"))
		      {

		    	  //WebDriverManager.edgedriver().setup();
		    	  driver=new EdgeDriver();
		    	  System.out.println(BROWSER+"---------Browser launched");
		      }
		      else
		      {
		    	  System.out.println("Invalid browser name");
		      }
		      
		      wUtil.maximizewindow(driver);
		      wUtil.waitForElementsToLoad(driver);
		       
		      //Step 3:Load the URl
				driver.get(URL);
				
				//Step 4:Login to the application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
						
				//Step 5:Click on organization Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 6:click on create organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 7:Create Organization
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
						
				//Step 8:save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
				//Step 8:validate for organization
				String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println("PASS");
					System.out.println(OrgHeader);
				}
				else
				{
					System.out.println("FAIL");
				}
				
				/* Create contact using organization   */
				
				
				//Step 9:click on contacts link
				driver.findElement(By.linkText("Contacts")).click();
				
				//Step 10:Navigate to create contact look up image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
				//Step 11:create a contact with mandatory information
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();

				// Step 11: switch to child window
				wUtil.SwitchtoWindow(driver, "Accounts");

				// Step 12: search for Organisation
				driver.findElement(By.name("search_text")).sendKeys(ORGNAME);

				driver.findElement(By.name("search")).click();

				driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click(); // dynamic xpath

				// Step 13: switch the control back to parent window
				wUtil.SwitchtoWindow(driver, "Contact");

				// Step 14: save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				// Step 15: Validate for Organization
				String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (ContactHeader.contains(LASTNAME)) {
					System.out.println("PASS");
					System.out.println(ContactHeader);
				} 
				else 
				{
					System.out.println("Fail");
				}
				
				//Step16:Logout
				WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.MouseHoveraction(driver, AdminImg);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Logout successfull");
		


	}
}
