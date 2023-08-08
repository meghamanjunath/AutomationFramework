package Vtiger.OrganizationTests;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
	import vtiger.GenericUtilities.JavaUtility;
	import vtiger.GenericUtilities.PropertyFileUtility;
	import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

	public class CreateOrgwithIndustryusingObjectRepositoryTest  extends BaseClass{	
		
		@Test
		public void createorgWithIndustryTest() throws Throwable {
		  
			  /*Read all necessary data*/
			  String ORGNAME = eUtil.getdatafromExcel("Organization", 4, 2)+jUtil.getRandomNumber();
			  String INDUSTRY= eUtil.getdatafromExcel("Organization", 4, 3);
					
		      //Click on organization Link
			   HomePage hp = new HomePage(driver);
			   hp.ClickOnOrgLink();
					
			   //click on create organization look up image
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrgLookUpImg();
					
			    //Create Organization
			    CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			    cnop.createOrganization(ORGNAME, INDUSTRY);
					
				//validate
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String OrgHeader=oip.getHeaderText();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				System.out.println(OrgHeader);
					
		}	
		
		@Test
		public void SampleTest()
		{
			System.out.println("SampleTest");
		}
}
