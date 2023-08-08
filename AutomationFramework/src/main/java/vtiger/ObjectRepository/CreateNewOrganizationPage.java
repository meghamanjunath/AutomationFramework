package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	

	@FindBy(name="accountname")
	private WebElement OrgNameEdt;

	@FindBy(name="industry")
	private WebElement IndustryDropDwn;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	//businees libraries
	/**
	 * this method will create organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	/**
	 * this method will handledropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createOrganization(String ORGNAME,String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropdown(IndustryDropDwn,INDUSTRY);
		SaveBtn.click();	
	}
	

}
