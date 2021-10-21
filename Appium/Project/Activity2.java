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

public class Activity2 {
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
    public void testcreatenewnote() {
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"New text note\"]").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Test");
    	driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("To test Google Keep");
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	String notetitle=driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"Test. To test Google Keep. \"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]").getText();
    	System.out.println("Note Title was: "+notetitle);
    	Assert.assertEquals(notetitle, "Test");
    	
    }
}