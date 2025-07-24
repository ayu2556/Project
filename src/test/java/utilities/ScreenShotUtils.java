package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShotUtils {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "test-output/screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            File dest = new File(path);
            dest.getParentFile().mkdirs(); // Make sure folder exists
            Files.copy(src, dest);
            System.out.println("Saved screenshot");
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Not Saved screenshot");
            return null;
        }
    }

}
