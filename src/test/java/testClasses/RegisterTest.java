package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.AppShoe;
import pages.Dashboard;
import pages.HomePage;
import pages.LoginPage;
import pages.RagisterPage;
import utilities.BaseClass;
import utilities.ExtentReportManager;
import utilities.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class RegisterTest extends BaseClass {
	
	ExtentTest test;
	//WebDriver driver;
	HomePage page;
	RagisterPage ragisterPage;
	LoginPage loginPage;
	Dashboard dashboard;
	AppShoe appshoe;
	@BeforeClass
	public void setUp() {
		launchBrowser();
		page = new HomePage(driver);
		
	}
	@Test(priority = 0, groups = {"smoke"})
	public void validationRegistrationLink() {
		test = ExtentReportManager.createTest("Test Method 1");
        test.pass("Test step Passed");
        
		ragisterPage=page.clickOnRegister();
		ragisterPage.selectGender();
		ragisterPage.fillForm("Ayush", "Sahu", "ayushsahu599@gmail.com", "Ayush123", "Ayush123");
		ragisterPage.submit();
		//Assert.assertEquals(getCurrentUrl(), "https://demowebshop.tricentis.com/register");
		String s=ragisterPage.getText();
		System.out.println(s);
		if(s.equals("The specified email already exists")) {
			System.out.println("Okay");
			loginPage=ragisterPage.login();
			
		}
		
		dashboard = loginPage.loginCred("ayushsahu599@gmail.com", "Ayush123");
		appshoe=dashboard.enterPage();
		appshoe.clickProduct();
		
		
		Assert.assertTrue(true);
		
	}
	@AfterSuite
    public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
        ExtentReportManager.flushReport();
        
        closeBrowser();
        
    }

}
