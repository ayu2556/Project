package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class HomePage extends BaseClass {
	public HomePage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement RegisterLink;
	
	public RagisterPage clickOnRegister() {
		clickOnAElement(RegisterLink);
		return new RagisterPage(driver);
	}
}
