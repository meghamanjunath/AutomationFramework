package vtiger.GenericUtilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consistes of generic methods related to property file
 * @author Likith
 *
 */
public class PropertyFileUtility {
	
	/**
	 * this method reads data from proprety file  based on given key
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getDataFromProprtyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Likith\\eclipse-workspace\\AutomationFramework\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
	    String value = p.getProperty(key);
		return value;
	
	}

}
