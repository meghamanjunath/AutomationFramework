package Vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {
	
	@Test	
	public void read()
	{
		String UN =System.getProperty("username");
		System.out.println(UN);
		String Pwd = System.getProperty("password");
		System.out.println(Pwd);
	}
}
