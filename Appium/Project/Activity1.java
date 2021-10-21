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

public class Activity1 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

       
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 28");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

       
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }
    @Test
    public void testcreatetask1() {
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElementByClassName("android.widget.EditText").sendKeys("Complete Activity with Google Tasks");
    	
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	String task1=driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView").getText();
    	System.out.println("Task name is: "+ task1);
    	Assert.assertEquals(task1, "Complete Activity with Google Tasks");
    	}
    @Test
    public void testcreatetask2() {
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElementByClassName("android.widget.EditText").sendKeys("Complete Activity with Google Keep");
    	
    	driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	String task2=driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
    	System.out.println("Task name is: "+ task2);
    	Assert.assertEquals(task2, "Complete Activity with Google Keep");
    	}
    @Test
    public void testcreatetask3() {
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Create new task\"]").click();
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	driver.findElementByClassName("android.widget.EditText").sendKeys("Complete the second Activity Google Keep");
        	
        	driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        	String task3=driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();
        	System.out.println("Task name is: "+ task3);
        	Assert.assertEquals(task3, "Complete the second Activity Google Keep");
        	}
    
}