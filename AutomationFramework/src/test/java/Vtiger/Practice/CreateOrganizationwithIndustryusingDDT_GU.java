package Vtiger.Practice;


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
import vtiger.ObjectRepository.LoginPage;

public class CreateOrganizationwithIndustryusingDDT_GU {

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
		      String ORGNAME = eUtil.getdatafromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
		      String INDUSTRY= eUtil.getdatafromExcel("Organization", 4, 3);
		
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
				
				//Step 3:Login to the application
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("submitButton")).click();
				
				LoginPage lp=new LoginPage(driver);
					lp.getUserNameEdt().sendKeys(USERNAME);
					lp.getPasswordEdt().sendKeys(PASSWORD);
				    lp.getLoginBtn().click();
						
				//Step 4:Click on organization Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 5:click on create organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 6:Create Organization
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 7:Choose 'Chemicals' in industry drop down
				WebElement industryDropDown = driver.findElement(By.name("industry"));
				wUtil.handleDropdown(INDUSTRY, industryDropDown);
						
				//Step 8:save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				//Step 9:validate
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
				//Step 9:Logout of Application
				WebElement adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.MouseHoveraction(driver, adminimg);
				
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Logout Successful");
				
				

	}


}
