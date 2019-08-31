package shoppingId.shoppingId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class HomeTest extends Thread{
	WebDriver driver;
	
	@Test
	public void f() throws Exception
	{
		Thread t = new Thread();
		Assert.assertEquals(driver.getTitle(),"Shop");
		driver.findElement(By.id("username")).sendKeys("admin");
		t.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("admin");
		t.sleep(3000);
		driver.findElement(By.cssSelector(".btn")).click();
		t.sleep(3000);
		driver.findElement(By.linkText("Sign Out")).click();
		t.sleep(3000);
	}
	
	@Test(dataProvider = "InvalidDateaProvider")
	public void VerifyInvalidLoginBothTest(String username, String password) {
		
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("btn")).click();
		String Alertmessage = driver.findElement(By.cssSelector(".alert")).getText();
		Assert.assertEquals(Alertmessage, "Invalid username and password!!");
	}
	
	@DataProvider
	public Object [][] InvalidDataProvider(){
		return new Object[][] {
			new Object[] {"InvalidUser", "password"},
			new Object[] {"testuser", "InvalidPassword"},
			new Object[] {"InvalidUser", "InvalidPassword"},
		};
	}
	
	
   
	@BeforeTest
	public void beforeTest() {
	   System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("http://localhost:8070/login");
     }
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
		
	}
	

}
