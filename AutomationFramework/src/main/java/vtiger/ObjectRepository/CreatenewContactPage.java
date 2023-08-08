package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreatenewContactPage extends WebDriverUtility {
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement orgSearchBtn;

	//initilization
	public CreatenewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	
	//business libraries
	/**
	 * this method will create contact with mandatory information
	 * @param LASTNAME
	 */
	public void CreateContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	public void createContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		SwitchtoWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		SwitchtoWindow(driver, "Contacts");
		SaveBtn.click();
		
		
	}
	
	
	
	
	
}
