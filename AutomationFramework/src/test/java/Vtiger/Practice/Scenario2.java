package Vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2 {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
	    driver.findElement(By.name("accountname")).sendKeys("TCS");
	    driver.findElement(By.cssSelector("[class='crmButton small save']")).click();
        //verify
	    
	   
	

	}

}
