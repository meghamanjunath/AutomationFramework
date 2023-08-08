package Vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
	    driver.findElement(By.name("lastname")).sendKeys("gowda");
	    driver.findElement(By.cssSelector("[class='crmButton small save']")).click();
        //verify
	    if(driver.getTitle().equals("Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM"))
	    {
	    	System.out.println("we are on vtiger contacts page");
	    }
	    else
	    {
	    	System.out.println("we are not on vtiger contacts page");
	    }
	    //driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    //driver.close();
	    
	    
	    
	    
	}

}
