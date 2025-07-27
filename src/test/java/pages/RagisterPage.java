package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class RagisterPage extends BaseClass {
	
	public RagisterPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id ="gender-male")
	private WebElement gender;
	
	@FindBy(id ="FirstName")
	private WebElement First;
	
	@FindBy(id ="LastName")
	private WebElement Last;
	
	@FindBy(id ="Email")
	private WebElement Email;
	
	@FindBy(id ="Password")
	private WebElement Password;
	
	@FindBy(id ="ConfirmPassword")
	private WebElement ConPassword;
	
	@FindBy(id ="register-button")
	private WebElement registerButton;
	
	@FindBy(xpath="//li[contains(text(),'specified email')]")
	private WebElement text;
	
	@FindBy(linkText ="Log in")
	private WebElement login;
	
	public void selectGender() {
		clickOnAElement(gender);
	}
//	public void setFirst() {
//		sendKeys(First,"Ayush");
//	}
//	public void setLast() {
//		sendKeys(Last,"Sahu");
//	}
//	public void setEmail() {
//		sendKeys(Email,"ayushsahu599@gmail.com");
//	}
//	public void setPass() {
//		sendKeys(Password,"Ayush123");
//		sendKeys(ConPassword,"Ayush123");
//		
//	}
	public void fillForm(String first, String last,String email, String Pass,String confirm) {
        sendKeys(First,first);
        sendKeys(Last,last);
        sendKeys(Email,email);
        sendKeys(Password,Pass);
        sendKeys(ConPassword,confirm);
	
	}
	public void submit() {
		clickOnAElement(registerButton);
	}
	
	public String getText() {
		return text.getText();
	}
	
	public LoginPage login() {
		clickOnAElement(login);
		return new LoginPage(driver);
	}
	//public void setName()
	
	
	

}
