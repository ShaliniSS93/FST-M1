package ProjectActivitiesHRM;


import java.util.List;
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

public class RetrieveEmergencyContacts {
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
	public void retrieve() {
		driver.findElements(By.cssSelector(".menu > ul:nth-child(1)"));
		WebElement MyInfo=driver.findElement(By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)"));
		MyInfo.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElements(By.cssSelector("#sidenav"));
		//driver.findElement(By.linkText("Emergency Contacts"));
		driver.findElement(By.cssSelector("#sidenav > li:nth-child(3) > a:nth-child(1)")).click();

		
		/*List<WebElement> allLinks = driver.findElements(By.cssSelector("#emgcontact_list"));

		Iterator<WebElement> itr = allLinks.iterator();
		while(itr.hasNext()) {
		    System.out.println(itr.next());*/
		
		List<WebElement> allLinks = driver.findElements(By.cssSelector("#emgcontact_list")); 

		
		for (WebElement row : allLinks) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 


		    for (WebElement cell : cells) {         

		    System.out.println(cell.getText());
		}
	}
}
	
	@AfterMethod
    public void afterMethod() {

        driver.close();
    }
}