package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class LoginPage extends BaseClass{
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="Email")
	private WebElement EmailLogin;
	
	@FindBy(id ="Password")
	private WebElement PasswordLogin;
	
	@FindBy(css ="input[value='Log in']")
	private WebElement LoginButton;
	
	public Dashboard loginCred(String email, String Pass) {
        
        sendKeys(EmailLogin,email);
        sendKeys(PasswordLogin,Pass);
        clickOnAElement(LoginButton);
        return new Dashboard(driver);
        
	}

}
