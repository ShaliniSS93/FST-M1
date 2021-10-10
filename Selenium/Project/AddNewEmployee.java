package ProjectActivitiesHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddNewEmployee {
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
       driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b:nth-child(1)")).click();
       driver.findElement(By.id("btnAdd")).click();
	}
    
	@Test
	@Parameters({"fname","lname"})
    public void CreateEmp(@Optional("Joe") String fname,@Optional("cassie") String lname) {
     WebElement fname1=driver.findElement(By.id("firstName"));
     WebElement lname1=driver.findElement(By.id("lastName"));
     fname1.sendKeys(fname); 
     lname1.sendKeys(lname);
     
       driver.findElement(By.id("btnSave")).click();
       driver.findElement(By.cssSelector("#menu_pim_viewEmployeeList")).click();
       WebElement Empname=driver.findElement(By.id("empsearch_employee_name_empName"));
       Empname.sendKeys(fname+" "+lname);
       driver.findElement(By.id("searchBtn")).click();
       String first=driver.findElement(By.cssSelector(".odd > td:nth-child(3) > a:nth-child(1)")).getText();
       Assert.assertEquals(fname, first);
             
      }
	@AfterMethod
    public void afterMethod() {

        driver.close();
    }
}
