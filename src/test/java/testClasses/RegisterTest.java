package testClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.BaseClass;
import utilities.ListenerImplementation;

@Listeners(ListenerImplementation.class)
public class RegisterTest extends BaseClass {
	//WebDriver driver;
	HomePage page;
	@BeforeClass
	public void setUp() {
		launchBrowser();
		page = new HomePage(driver);
	}
	@Test(priority = 0, groups = {"smoke"})
	public void validationRegistrationLink() {
		page.clickOnRegister();
		Assert.assertEquals(getCurrentUrl(), "https://demowebshop.tricentis.com/register");
	}

}
