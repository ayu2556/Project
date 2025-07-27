package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppShoe {
	
	
	public AppShoe(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='details']")
	List<WebElement> productTitles;
	
	public void clickProduct() {
	
    for(WebElement product:productTitles) {
    	
    	WebElement p=product.findElement(By.xpath(".//h2/a"));
    	if(p.getText().equals("Blue Jeans")) {
    		
    		product.findElement(By.className("buttons")).click();
    		System.out.println(p.getText()+" item selected");
    		break;
    		
    	}
		
		
		
	}
	}
	
}


