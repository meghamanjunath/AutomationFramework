package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactlookupimg;
	
	//initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//utilization

	public WebElement getCreateContactlookupimg() {
		return CreateContactlookupimg;
	}
	
	//business library
	/**
	 * This method will click on create contactimg
	 */
	public void clickoncreatecontactLookUpImg()
	{
		CreateContactlookupimg.click();
	}	

}
