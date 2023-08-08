package Vtiger.Practice;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateOrganizationWithIndustryusingDDT {

	public static void main(String[] args) throws Throwable {
		
		  WebDriver driver = null;
		  Random r =new Random();
		  int random = r.nextInt(1000);
		  
		
		     //step1: Read all the necessary data
		  /*Read data from propertyfile -common data */
		      FileInputStream fisp = new FileInputStream("C:\\Users\\Likith\\eclipse-workspace\\AutomationFramework\\src\\test\\resources\\CommonData.properties");
		      Properties pobj = new Properties();
		      pobj.load(fisp);
		      String BROWSER = pobj.getProperty("browser");
		      String URL = pobj.getProperty("url");
		      String USERNAME = pobj.getProperty("username");
		      String PASSWORD = pobj.getProperty("password");
		      
		    /*Read data from excel sheet-Test data*/
		     FileInputStream fise = new FileInputStream("C:\\Users\\Likith\\eclipse-workspace\\AutomationFramework\\src\\test\\resources\\testdata.xlsx");
		     Workbook wb = WorkbookFactory.create(fise);
		     Sheet sh = wb.getSheet("Organization");
		      String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+random;
		     String INDUSTRY= sh.getRow(4).getCell(3).getStringCellValue();
		
		     //Step2:launch the browser -driver is acting based on runtime data -runtime polymorphism
		      if(BROWSER.equalsIgnoreCase("chrome"))
		      {
		    	  WebDriverManager.chromedriver().setup();
		    	  driver=new ChromeDriver();
		    	  System.out.println(BROWSER+"---------Browser launched");
		      }
		      else if(BROWSER.equalsIgnoreCase("firefox"))
		      {

		    	  WebDriverManager.firefoxdriver().setup();
		    	  driver=new FirefoxDriver();
		    	  System.out.println(BROWSER+"---------Browser launched");
		      }
		      else if(BROWSER.equalsIgnoreCase("edge"))
		      {

		    	  WebDriverManager.edgedriver().setup();
		    	  driver=new EdgeDriver();
		    	  System.out.println(BROWSER+"---------Browser launched");
		      }
		      else
		      {
		    	  System.out.println("Invalid browser name");
		      }
		      
		      driver.manage().window().maximize(); 
		      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		       
		      //Step 3:Load the URl
				driver.get(URL);
				
				//Step 3:Login to the application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
						
				//Step 4:Click on organization Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 5:click on create organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 6:Create Organization
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 7:Choose 'Chemicals' in industry drop down
				WebElement industryDropDown = driver.findElement(By.name("industry"));
				Select s = new Select(industryDropDown);
				s.selectByValue(INDUSTRY);
						
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
				Actions act = new Actions(driver);
				act.moveToElement(adminimg).perform();
				
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Logout Successful");
				
				

	}

}
