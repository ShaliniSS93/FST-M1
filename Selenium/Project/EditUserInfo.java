package ProjectActivitiesHRM;

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

public class EditUserInfo {
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
	@Parameters({"adminfname","adminlname"})
	public void editinfo(@Optional("John") String adminfname,@Optional("Doe") String adminlname) {
		driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)")).click();
		driver.findElement(By.cssSelector("#btnSave")).click();
		driver.findElement(By.id("personal_txtEmpFirstName")).clear();
		WebElement Adminfname=driver.findElement(By.id("personal_txtEmpFirstName"));
		driver.findElement(By.id("personal_txtEmpLastName")).clear();
		WebElement Adminlname=driver.findElement(By.id("personal_txtEmpLastName"));
		Adminfname.sendKeys(adminfname);
		Adminlname.sendKeys(adminlname);
		driver.findElement(By.id("personal_optGender_1")).click();
		Select nationality=new Select(driver.findElement(By.id("personal_cmbNation")));
		nationality.selectByVisibleText("Bosnian");
		driver.findElement(By.id("personal_DOB")).clear();
		WebElement DOB=driver.findElement(By.id("personal_DOB"));
		DOB.sendKeys("1994-12-30");
        driver.findElement(By.cssSelector("#btnSave")).click();
	}
	@AfterMethod
    public void afterMethod() {

        driver.close();
    }
}