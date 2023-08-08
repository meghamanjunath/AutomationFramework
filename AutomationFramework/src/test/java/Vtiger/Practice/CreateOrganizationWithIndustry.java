package Vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class CreateOrganizationWithIndustry {

	public static void main(String[] args)
	{
	    Random r = new Random();
		int random =r.nextInt(1000);
		
		//step 1:Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2:Load the URl
		driver.get("http://localhost:8888");
		
		//Step 3:Login to the application
	    driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	
				
		//Step 4:Click on organization Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5:click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 6:Create Organization
		String orgname ="L&T" +random;
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		//Step 7:Choose 'Chemicals' in industry drop down
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropDown);
		s.selectByValue("Chemicals");
				
		//Step 8:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//Step 9:validate
		String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains("L&T"))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		//Step 9:Logout of Apllication
		WebElement adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout Successful");
		
		
		

	}

}
