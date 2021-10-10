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

public class Addingqualifications {
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
	public void addqualify() {
		driver.findElements(By.cssSelector(".menu > ul:nth-child(1)"));
		WebElement MyInfo=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)"));
		MyInfo.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElements(By.cssSelector("#sidenav"));
		//driver.findElement(By.linkText("Qualifications")).click();
        driver.findElement(By.cssSelector("#sidenav > li:nth-child(9) > a:nth-child(1)")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("addWorkExperience")).click();
        WebElement Company=driver.findElement(By.id("experience_employer"));
        Company.sendKeys("IBM");
        WebElement JobTitle=driver.findElement(By.id("experience_jobtitle"));
        JobTitle.sendKeys("Tester");
        driver.findElement(By.id("experience_from_date")).clear();
        WebElement StartDate=driver.findElement(By.id("experience_from_date"));
        StartDate.sendKeys("2016-02-08");
        driver.findElement(By.id("experience_to_date")).clear();
        WebElement EndDate=driver.findElement(By.id("experience_to_date"));
        EndDate.sendKeys("2021-02-08");
        driver.findElement(By.id("experience_comments")).sendKeys("test");
        driver.findElement(By.id("btnWorkExpSave")).click();
	}
	@AfterMethod
    public void afterMethod() {

        driver.close();
    }
}
   
