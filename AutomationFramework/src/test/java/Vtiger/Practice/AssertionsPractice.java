package Vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void sampleTest()
	{
		SoftAssert sa = new SoftAssert();
		int a=1;  //exp
		int b=2;  //actual
		
		System.out.println("step1");
		sa.assertEquals(false, true);     //fail
		
		System.out.println("step2");
		
		//Assert.assertEquals(b,a);    //pass //failed
		System.out.println("step3");
	
		System.out.println("step4");
		sa.assertTrue(false);    //fail
		
		System.out.println("exceution and validation complete");
		sa.assertAll();  //logging all the failures
	}
	
	@Test
    public void sampleTest1()
    {
		SoftAssert sa = new SoftAssert();
		
		int a=1;  //exp
		int b=2;  //actual
		
		System.out.println("step1");
		System.out.println("step2");
		sa.assertEquals(b, a);
		System.out.println("step3");
		System.out.println("step4");
		sa.assertTrue(false);
		System.out.println("exceution and validation complete");
		sa.assertAll();
		
    }

}
