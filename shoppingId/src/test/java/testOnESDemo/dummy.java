package testOnESDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dummy extends Thread{
	WebDriver driver;
	Thread t = new Thread();
	
//	driver.findElement(By.linkText("Registration")).click();	t.sleep(3000); //ClickRegistration
//	driver.findElement(By.id("username")).sendKeys("ys9997");	t.sleep(3000); //Username
//	driver.findElement(By.cssSelector(".btn")).click();			t.sleep(3000); //Login Button Click
//	String Alertmessage = driver.findElement(By.cssSelector(".alert")).getText();
//	Assert.assertEquals(Alertmessage.trim(), "User has been registered successfully");
//	usernameAlerts[0].trim();
	
	
	@SuppressWarnings("static-access")
	public void executeFirstQuery() throws Exception
	{
		
		driver.findElement(By.id("username")).sendKeys("diabetes type 2");			t.sleep(3000); //Query Info
		Select dropDownCategory = new Select(driver.findElement(By.name("category")));
		dropDownCategory.selectByVisibleText("Chemical");
		driver.findElement(By.cssSelector("input")).click();
	}
	
	@Test
	public void f() throws Exception
	{
		executeFirstQuery();
	}
   
	@BeforeTest
	public void beforeTest() {
	   System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("http://localhost:5000");
     }
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
}
