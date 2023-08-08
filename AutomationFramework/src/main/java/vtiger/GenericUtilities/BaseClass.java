package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * this class consists of all the basic configuration annotations for
 * all the common actions
 * @author Likith
 *
 */
public class BaseClass {
	
	  public JavaUtility jUtil = new JavaUtility();
	  public ExcelFileUtility eUtil = new ExcelFileUtility();
	  public PropertyFileUtility pUtil = new PropertyFileUtility();
	  public WebDriverUtility wUtil = new WebDriverUtility();
	  
	  public WebDriver driver = null;
	  
	  //only used for listener to take screenshot
	  public static WebDriver sdriver;
	  
	  @BeforeSuite(groups={"SmokeSuite" ,"RegressionSuite"})
	  public void bsConfig()
	  {
		  System.out.println("======db connection successful======");
	  }
	  //@Parameters("browser")  //holds a value
	  //@BeforeTest
	  @BeforeClass(alwaysRun =true)
	  public void bcConfig(/*String BROWSER*/) throws Throwable
	  {
		  //Read browser name and URL from property File
		  String BROWSER = pUtil.getDataFromProprtyFile("browser");
	      String URL = pUtil.getDataFromProprtyFile("url");
	      
	      if(BROWSER.equalsIgnoreCase("chrome"))
	      {
	    	  //WebDriverManager.chromedriver().setup();
	    	  driver=new ChromeDriver();
	    	  System.out.println(BROWSER+"===========Browser launched==========");
	      }
	      else if(BROWSER.equalsIgnoreCase("firefox"))
	      {

	    	  //WebDriverManager.firefoxdriver().setup();
	    	  driver=new FirefoxDriver();
	    	  System.out.println(BROWSER+"=========Browser launched===========");
	      }
	      else if(BROWSER.equalsIgnoreCase("edge"))
	      {

	    	  //WebDriverManager.edgedriver().setup();
	    	  driver=new EdgeDriver();
	    	  System.out.println(BROWSER+"===========Browser launched===========");
	      }
	      else
	      {
	    	  System.out.println("=======Invalid browser name============");
	      }
	      
	      wUtil.maximizewindow(driver);
	      wUtil.waitForElementsToLoad(driver);
	      
	      //only used for listener to take screenshot
	      sdriver = driver;
	       
	      //Load the URl
			driver.get(URL);
	  }
	  
	  @BeforeMethod(alwaysRun=true)
	  public void bmConfig() throws Throwable
	  {
		//read username and password from property file
		  String USERNAME = pUtil.getDataFromProprtyFile("username");
	      String PASSWORD = pUtil.getDataFromProprtyFile("password");
	      
	        LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			System.out.println("=======login successfull============");		
	  }
	  
	  @AfterMethod(alwaysRun =true)
	  public void amConfig() throws Throwable {
		   HomePage hp = new HomePage(driver);
		   hp.logoutofapp(driver);
		   System.out.println("======Logout Successful=================");
	  }
	  
	  //@AfterTest
	  @AfterClass(alwaysRun=true)
	  public void acConfig()
	  {
		  driver.quit();
		  System.out.println("======browser closed=================");
		  
	  }
	  @AfterSuite(alwaysRun =true)
	  public void asConfig() 
	  {
		  System.out.println("======db connection closed======");
	  }
	  
	  
	  
	  

}
