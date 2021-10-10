package ProjectActivitiesHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loggingintosite {
	WebDriver driver;
	@BeforeMethod
    public void beforeMethod() {
   
        driver = new FirefoxDriver();
        

        driver.get("http://alchemy.hguy.co:8080/orangehrm");
    }
	@Test
    public void loginTestCase() {
	WebElement Username = driver.findElement(By.id("txtUsername"));
	WebElement Password = driver.findElement(By.id("txtPassword"));
       Username.sendKeys("orange"); 
       Password.sendKeys("orangepassword123");
    driver.findElement(By.id("btnLogin")).click();
   
    String admin = driver.findElement(By.cssSelector("#menu_admin_viewAdminModule > b:nth-child(1)")).getText();
    Assert.assertEquals(admin, "Admin");
      }
	@AfterMethod
    public void afterMethod() {

        driver.close();
    }
}
