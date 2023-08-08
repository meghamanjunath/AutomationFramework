package Vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.CreatenewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactwithOrgusingObjectRepositoryTest extends BaseClass {
	
	@Test(groups="SmokeSuite")
	public void createcontactwithorgTest() throws Throwable
	{
		      /*  create organization */
		
		      // Read all the necessary data
		      String ORGNAME = eUtil.getdatafromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		      String LASTNAME = eUtil.getdatafromExcel("Contact", 4, 2);
		     	
				//Click on organization Link
				HomePage hp = new HomePage(driver);
				hp.ClickOnOrgLink();
				Reporter.log("Org link clicked");
				
				//click on create organization look up image
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrgLookUpImg();
				Reporter.log("Create org look up image is clicked");
				
				//Create Organization
				CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
				cnop.createOrganization(ORGNAME);
				Reporter.log("Organization created");
			
				//validate for organization
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader = oip.getHeaderText();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				System.out.println(OrgHeader);
				
				/* Create contact using organization   */
				
				//click on contacts link
				hp.clickOnContactLink();
				Reporter.log("contacts link clicked");
				
				//Navigate to create contact look up image
				//Assert.fail();
				ContactsPage cp = new ContactsPage(driver);
				cp.clickoncreatecontactLookUpImg();
				Reporter.log("create contact lookup image is clicked");
				
				//create a contact with mandatory information
				CreatenewContactPage cncp = new CreatenewContactPage(driver);
				cncp.createContact(driver, LASTNAME, ORGNAME);

				//Validate for Organization
				ContactInfoPage cip = new ContactInfoPage(driver);
				String ContactHeader = cip.getContactHeader();
				Assert.assertTrue(ContactHeader.contains(LASTNAME));
				System.out.println(ContactHeader);			   
	}

	@Test
	public void demotest()
	{
		//Assert.fail();
		System.out.println("demo");
	}
	
	
}

