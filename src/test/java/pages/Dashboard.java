package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class Dashboard extends BaseClass {
	
	public Dashboard(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText ="Apparel & Shoes")
	private WebElement AppShoe;
	
	public AppShoe enterPage() {
		
		clickOnAElement(AppShoe);
		return new AppShoe(driver);
		
	}

}
