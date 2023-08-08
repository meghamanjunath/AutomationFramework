package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{  
	
	//Rule1:create a separate pom class for every webpage
	
	//Rule2:Identify the webElements using @FindBy,@FindBys,@FindAll
	@FindBy(linkText="Organizations")
	private WebElement Organizationslnk;
	
	@FindBy(linkText="Contacts")
	private WebElement Contactslnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement Opportunitieslnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	//Rule3:Create a construtor to initialize the webelements
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//Rule4:provide getters to access these web elements
	
	public WebElement getOrganizationslnk() {
		return Organizationslnk;
	}

	public WebElement getContactslink() {
		return Contactslnk;
	}
	
	public WebElement getOpportunitieslink() {
		return Opportunitieslnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	
	//Business LIbrary
	/**
	 * this method will click on organizations
	 */
	public void ClickOnOrgLink()
	{
		Organizationslnk.click();
	}
	/**
	 * this method will click on contacts link
	 */
	public void clickOnContactLink() 
	{
		Contactslnk.click();
	}
	public void clickOnOppurtunitiesLink()
	{
		Opportunitieslnk.click();
	}
	/**
	 * this method will logout of application
	 * @param driver
	 * @throws Throwable 
	 */
	public void logoutofapp(WebDriver driver) throws Throwable 
	{
		MouseHoveraction(driver,AdministratorImg);
		Thread.sleep(1000);
		SignOutLnk.click();
	}	

	
}
