package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ListenerImplementation extends BaseClass implements ITestListener {
	WebDriver driver;
	 public static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test = ExtentReportManager.getReportInstance()
	            .createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub		
	}	
	@Override
	public void onTestFailure(ITestResult result) {
		
		Object testInstance = result.getInstance();
		
		
		
		WebDriver driver = ((BaseClass) testInstance).driver;
		
		try {
			if(driver!=null && isDriverActive(driver)) {
	    String path = ScreenShotUtils.captureScreenshot(driver, result.getMethod().getMethodName());

	    
	    	test.fail("Test Failed",
	            MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	    	System.out.println("Screenshot captured for: " + result.getName());
			}
			else {
				System.out.println("Driver is null or already closed. Skipping screenshot.");
				test.log(Status.WARNING,"Driver is null");
			}
	    } catch (Exception e) {
	    	test.fail("Failed to attach screenshot");
	    	System.out.println("Exception during screenshot: " + e.getMessage());
	        test.log(Status.FAIL, "Screenshot capture failed: " + e.getMessage());
	    }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public boolean isDriverActive(WebDriver driver) {
	    try {
	        driver.getWindowHandles();  // safer than getTitle()
	        return true;
	    } catch (Exception e) {
	    	System.out.println("Driver is already closed"+e.getMessage());
	        return false;
	    }
	}

}
