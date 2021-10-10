package ProjectActivitiesHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Verifywebsitetitle {
	WebDriver driver;
	@BeforeMethod
    public void beforeMethod() {
   
        driver = new FirefoxDriver();
        

        driver.get("http://alchemy.hguy.co/orangehrm");
    }
	@Test
	public void titlematch() {
		String Title=driver.getTitle();
		System.out.println(Title);
       Assert.assertEquals("OrangeHRM", Title);
		if(Title.equals("OrangeHRM"))
		{
		  System.out.println("Title matches!");
	      driver.close();
		}	
		else
		{
			System.out.println("Title does not match");
		}
	    }
	

}
