package ProjectActivitiesGoogletasks;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

       
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

       
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }
    @Test
    public void testcreatenewnotewithreminder() {
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"New text note\"]").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Test2");
    	driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("To test Google Keep");
    	driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Single-column view\"]").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElementById("com.google.android.keep:id/time_spinner").click();
    	driver.findElementByXPath("//android.widget.ListView/android.widget.LinearLayout[2]/android.widget.TextView[1]").click();
    	driver.findElementById("com.google.android.keep:id/save").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	String time=driver.findElementById("com.google.android.keep:id/reminder_chip_text").getText();
    	System.out.println("Note reminder was at: "+time);
    	Assert.assertEquals(time, "Today, 1:00 PM");
    	
    }
}
