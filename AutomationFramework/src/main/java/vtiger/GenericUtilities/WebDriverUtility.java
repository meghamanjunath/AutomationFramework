package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver)//update driver reference
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizewindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for all the findelement and findelements
	 * operations to be performed
	 * @param driver
	 */
	public void waitForElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait until the specified element
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will handle dropdown using value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will handle dropdown using visibletext
	 * @param element
	 * @param text
	 */
	public void handleDropdown(String text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will perform mouse hover action on a target element
	 * @param driver
	 * @param element
	 */
	public void MouseHoveraction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will double click anywhere on the webpage
	 * @param driver
	 */
	public void Doubleclickaction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();	
	}
	/**
	 * This method will double click on a web element
	 * @param driver
	 * @param element
	 */
	public void Doubleclickaction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will right click anywhere on the webpage
	 * @param driver
	 */
	public void rightclickaction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();	
	}
	/**
	 * This method will perform rightclick on a particular web element
	 * @param driver
	 * @param element
	 */
	public void rightclickaction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDropaction(WebDriver driver,WebElement srcElement ,WebElement targetElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
	}
	/**
	 * This method will perform drag and drop actions on coordinates
	 * @param driver
	 * @param element
	 */
	public void dragAndDropaction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.dragAndDropBy(element, 0, 0);
	}
	/**
	 * This method is used to move the cursor anywhere on the web page based on offset value
	 * @param driver
	 * @param xoffset
	 * @param yoffset
	 */
	public void moveacrosswebpage(WebDriver driver,int xoffset,int yoffset)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(xoffset, yoffset).click().perform();
	}
	/**
	 * This method will scroll vertically for 500 pixels
	 * @param driver
	 */
	public void scrollaction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	/**
	 * This method will scroll vertically until the element reference
	 * @param driver
	 * @param element
	 */
	public void scrollaction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+");",element);	
	}
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptalert(WebDriver driver)
	{ 
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel the confirmation popup
	 * @param driver
	 */
	public void cancelalert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will enter the text in prompt popup
	 * @param driver
	 * @param text
	 */
	public void sendTextToalert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * This method will capture the alert message and return to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will handle frame based on index value
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle frame based on value of name or id attributes
	 * @param driver
	 * @param nameorId
	 */
	public void  handleFrame(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	/**
	 * This method will handle frame based on WebElement
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver ,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will help to switch the control back to immediate parent
	 * @param driver
	 */
	public void switchtoParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will help to switch the control back to current page
	 * @param driver
	 */
	public void switchtodefaultpage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch the selenium control from parent to child or child 
	 * to parent based on partial window title
	 * @param driver
	 */
	public void SwitchtoWindow(WebDriver driver,String partialwintitle)
	{
		//step1:capture all the window ID'S
		Set<String> allwindowids = driver.getWindowHandles();
				
		//Step2:iterate through individual ID'S
		for(String winID:allwindowids)
		{
		  //Step3:switch to each id and capture the title
		  String currenttitle = driver.switchTo().window(winID).getTitle();
			
		//step4:compare the title with required reference
		if(currenttitle.contains(partialwintitle))
		{
			break;
		}
		}
	}
	
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		  TakesScreenshot ts = (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dst = new File(".\\ScreenShots\\"+screenshotName+".png");
		 Files.copy(src, dst);  //this class is from commons IO tool
		 
		 return dst.getAbsolutePath();   //attach the screenshot to extent reports	 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
