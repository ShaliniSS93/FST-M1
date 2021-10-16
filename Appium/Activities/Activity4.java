package appium;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);

       
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void addContact() {
        
        driver.findElementByAccessibilityId("Create new contact").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        
        MobileElement firstName = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[1]");
        MobileElement lastName = driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[2]");
        MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
        
        
        firstName.sendKeys("Mrinalini");
        lastName.sendKeys("Venu");
        phoneNumber.sendKeys("9991289008");
        
       
        driver.findElementById("editor_menu_save_button").click();
        
      
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));

        
        MobileElement mobileCard = driver.findElementById("toolbar_parent");
        Assert.assertTrue(mobileCard.isDisplayed());
        
        String contactName = driver.findElementById("large_title").getText();
        Assert.assertEquals(contactName, "Mrinalini Venu");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}