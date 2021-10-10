package ProjectActivitiesHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeturlOfHeaderImage {
	WebDriver driver;
	@BeforeMethod
    public void beforeMethod() {
   
        driver = new FirefoxDriver();
        

        driver.get("http://alchemy.hguy.co/orangehrm");
    }
	@Test
	public void geturl() {
		WebElement logo = driver.findElement(By.cssSelector("#divLogo > img"));
		String src=logo.getAttribute("src");
		System.out.println("The URL is: "+src);
	}
	@AfterMethod
    public void afterMethod() {

        driver.close();
    }

}