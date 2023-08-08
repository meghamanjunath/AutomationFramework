package vtiger.GenericUtilities;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides implementation to Itestlistener interface of testng
 * Example of abstraction
 * @author Likith
 *
 */
public class ListenerImplementationClass implements ITestListener
{  

     ExtentReports report;
     ExtentTest test;


	public void onTestStart(ITestResult result) {
		
		String methodName =result.getMethod().getMethodName();
		System.out.println("-----Execution Started----"+methodName);	
		
		test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName =result.getMethod().getMethodName();
		//System.out.println("-----PASS----"+methodName);	
		
		test.log(Status.PASS, "--- PASS --- "+methodName);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName =result.getMethod().getMethodName();
		//System.out.println("-----FAIL----"+methodName);
		
		test.log(Status.FAIL, "--- FAIL --- "+methodName);
		
		//System.out.println(result.getThrowable());	
		
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtility wu = new WebDriverUtility();
		JavaUtility ju = new JavaUtility();
		
		String screenshotName =methodName+ju.getSystemDateInFormat();
		
	   /*Take screenshot for failed test scripts-to attach with bug rising*/
		try {
			
			String path=wu.takeScreenShot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO: handle exception
		     e.printStackTrace();
		}		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName =result.getMethod().getMethodName();
		//System.out.println("-----SKIP----"+methodName);	
		
		test.log(Status.SKIP, "--- SKIP --- "+methodName);
		
		//System.out.println(result.getThrowable());	
		
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub	
	}

	public void onStart(ITestContext context) {
		// Start of <Suite> -@BeforeSuite	
		
		System.out.println("-----Suite Execution Started----");	
		
		//configure the extent reports
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("C:\\Users\\Likith\\eclipse-workspace\\AutomationFramework\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution Report");
		htmlreport.config().setReportName("Build 3 Vtiger Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		
		
		//Report Generation
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base Platform", "Testing-Env");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Reporter", "megha");
			
	}

	public void onFinish(ITestContext context) {
		// End Of <Suite> -@AfterSuite
	
		System.out.println("-----Suite Execution ended----");
		
		//Report Generation
		report.flush();
		
	}
	
	
	
	
	
	

}
