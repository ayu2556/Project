package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.HomePage;
import utilities.BaseClass;
import utilities.ExtentReportManager;
import utilities.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class RegisterTest extends BaseClass {
	
	ExtentTest test;
	//WebDriver driver;
	HomePage page;
	@BeforeClass
	public void setUp() {
		launchBrowser();
		page = new HomePage(driver);
	}
	@Test(priority = 0, groups = {"smoke"})
	public void validationRegistrationLink() {
		test = ExtentReportManager.createTest("Test Method 1");
        test.fail("Test step Failed");
        Assert.assertTrue(false);
		page.clickOnRegister();
		Assert.assertEquals(getCurrentUrl(), "https://demowebshop.tricentis.com/register");
	}
	@AfterSuite
    public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
        ExtentReportManager.flushReport();
        
        closeBrowser();
        
    }

}
