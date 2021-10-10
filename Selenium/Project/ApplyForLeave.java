package ProjectActivitiesHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApplyForLeave {
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
	public void applyleave() {
		driver.findElements(By.id("panel_wrapper_0"));
		driver.findElement(By.cssSelector(".quickLaungeContainer > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(4) > div:nth-child(1) > a:nth-child(1)")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElements(By.cssSelector(".inner"));
		
		Select leave=new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		leave.selectByVisibleText("privilege leaves");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        WebElement Start=driver.findElement(By.id("applyleave_txtFromDate"));
        Start.sendKeys("2021-11-20");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        WebElement End=driver.findElement(By.id("applyleave_txtToDate"));
        End.sendKeys("2021-11-20");
        driver.findElement(By.id("applyleave_txtComment")).sendKeys("test");
        driver.findElement(By.cssSelector("#applyBtn")).click();

        driver.findElements(By.cssSelector(".current > ul:nth-child(2)"));
        driver.findElement(By.cssSelector("#menu_leave_viewMyLeaveList")).click();
        driver.findElement(By.id("btnReset")).click();
        driver.findElements(By.cssSelector("div.inner:nth-child(1)"));
        WebElement date=driver.findElement(By.linkText("2021-11-20"));
        String Datevalue=date.getText();
        System.out.println(Datevalue);
        
        WebElement status=driver.findElement(By.cssSelector("tr.even:nth-child(2) > td:nth-child(6) > a:nth-child(1)"));
        String statusofleave=status.getText();
        System.out.println(statusofleave);
         //2nd code
        /*driver.findElement(By.id("calFromDate")).clear();
         * WebElement FromD=driver.findElement(By.id("calFromDate"));
         * FromD.sendKeys("2021-11-20");
         * driver.findElement(By.id("calToDate")).clear();
         * WebElement ToD=driver.findElement(By.id("calToDate"));
         * ToD.sendKeys("2021-11-20");
         * driver.findElements(By.cssSelector("div.inner:nth-child(1)"));
           WebElement date=driver.findElement(By.linkText("2021-11-20"));
         * WebElement Status=driver.findElement(By.cssSelector("td.left:nth-child(6) > a:nth-child(1)"));
        String StatusLeave=Status.getText();*/
        
        
}
	@AfterMethod
    public void afterMethod() {

        driver.close();
    }
}
