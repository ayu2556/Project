package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import utilities.BaseClass;
import utilities.ExtentReportManager;
import utilities.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class LoginTest extends BaseClass {
	 ExtentTest test;
	 
	@Test
	
	public void executeLoginTest() {
		
		test = ExtentReportManager.createTest("Test Method 2");
        test.pass("Test step Pass");
        Assert.assertTrue(true);
		
		
		
	}
	@AfterSuite
    public void tearDown() {
        ExtentReportManager.flushReport();
    }
}
