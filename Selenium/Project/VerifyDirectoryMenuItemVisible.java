package ProjectActivitiesHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class VerifyDirectoryMenuItemVisible {
	WebDriver driver;
	@BeforeTest

    public void beforetest() {
   
        driver = new FirefoxDriver();
        

        driver.get("http://alchemy.hguy.co:8080/orangehrm");
	}
	@BeforeMethod
	@Parameters({"username","password"})
    public void beforemethod(@Optional("orange") String username,@Optional("orangepassword123") String password) {
	WebElement Username = driver.findElement(By.id("txtUsername"));
	WebElement Password = driver.findElement(By.id("txtPassword"));
       Username.sendKeys(username); 
       Password.sendKeys(password);
       driver.findElement(By.id("btnLogin")).click();
}
	@Test
	public void directoryCheck() {
	driver.findElements(By.cssSelector(".menu > ul:nth-child(1)"));
	WebElement Directory=driver.findElement(By.cssSelector("#menu_directory_viewDirectory > b:nth-child(1)"));
	if(Directory.isEnabled() && Directory.isDisplayed())
	{
		Directory.click();
	}
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebElement Search=driver.findElement(By.cssSelector(".head > h1:nth-child(1)"));
	String Directoryheader=Search.getText();
	System.out.println(Directoryheader);
	Assert.assertEquals(Directoryheader,"Search Directory");
	}
	@AfterMethod
    public void afterMethod() {

        driver.close();
    }
}
