package Vtiger.ProductsTests;

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

public class Createproductswithorganization {

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
					      String ORGNAME = eUtil.getdatafromExcel("Products", 4, 4)+jUtil.getRandomNumber();
					      String PRODUCTNAME = eUtil.getdatafromExcel("Products", 4, 2);
					
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
							
							/* Create product using organization   */
							
							//Step 9:Click on products Link
							driver.findElement(By.linkText("Products")).click();
							
							//step10:Create new Product with A vendor
							driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
							
							//Step11:create a product with mandatory information & Choose 303-interest-income in GL Account Drop down
							driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
							WebElement accountDropDown = driver.findElement(By.name("glacct"));
							wUtil.handleDropdown(PRODUCTNAME, accountDropDown);
				
							// Step 11: switch to child window
							wUtil.SwitchtoWindow(driver, "Accounts");

							// Step 12: search for Organisation
							driver.findElement(By.name("search_text")).sendKeys(ORGNAME);

							driver.findElement(By.name("search")).click();

							driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click(); // dynamic xpath

							// Step 13: switch the control back to parent window
							wUtil.SwitchtoWindow(driver, "Products");

							// Step 14: save
							driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

							// Step 15: Validate for Organization
							String ProductsHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
							if (ProductsHeader.contains(PRODUCTNAME)) {
								System.out.println("PASS");
								System.out.println(ProductsHeader);
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

