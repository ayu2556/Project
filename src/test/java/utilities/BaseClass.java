package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
	public static WebDriver driver; 
	public Properties readDataFromPropertyFile()  {
			FileReader fr = null;
			try {
				fr = new FileReader("./config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//FileInputStream fis = new FileInputStream("./config.properties");
			Properties prop = new Properties();
			try {
				prop.load(fr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return prop;
	}
	
	public void launchBrowser() {
		String browsername = readDataFromPropertyFile().getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		if(browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		driver.get(readDataFromPropertyFile().getProperty("url"));
	}	
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}
	public void clickOnAElement(WebElement element) {
		element.click();
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public static void closeBrowser() {
		try {
			Thread.sleep(2000);
			if(driver!=null) {
				driver.quit();
			}
		}
		catch(Exception e) {
			System.out.println("Error during driver quit");
		}
	}
}
