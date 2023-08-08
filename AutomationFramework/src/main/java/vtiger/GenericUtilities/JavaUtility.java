package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of all generic methods related to java
 * @author Likith
 *
 */

public class JavaUtility {
	
	/**
	 * This method will generate a random number for every execution
	 * @return
	 */

	public int getRandomNumber()
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	/**
	 * This method will generate the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;		
	}
	/**
	 * This method will generate the system date in specific format
	 * @return  current system date
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		String[] date = d.toString().split(" ");
		String currentDate = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(":", "-");
		
		String dateInformat = currentDate+"_"+month+"_"+year+"_"+time;
		return dateInformat;
		
	}

}
