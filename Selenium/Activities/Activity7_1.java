package Selenium_activities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Activity7_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        
        
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        
        WebElement userName = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, 'password')]"));
        
        userName.sendKeys("admin");
        password.sendKeys("password");
       
        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();
        
      
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);
        
   
        driver.close();

    }
}