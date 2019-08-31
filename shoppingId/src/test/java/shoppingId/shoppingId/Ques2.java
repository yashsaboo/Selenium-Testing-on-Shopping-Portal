package shoppingId.shoppingId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Ques2 extends Thread{
	WebDriver driver;
	
	@SuppressWarnings("static-access")
	@Test
	public void f() throws Exception
	{
		Thread t = new Thread();
		Assert.assertEquals(driver.getTitle(),"Shop");
		
		driver.findElement(By.id("username")).sendKeys("admin");		t.sleep(5000); //Username
		driver.findElement(By.id("password")).sendKeys("admin");		t.sleep(2000); //Password
		driver.findElement(By.cssSelector(".btn")).click();				t.sleep(1000);  //Submit Button
		
		String value = driver.findElement(By.cssSelector(".panel-default:nth-child(2) > .row")).getText(); 
		//Get number of items value
		System.out.println(value);
		String[] ary = value.split("");
		int stockItemValue = Integer.parseInt(ary[ary.length-5]);
        System.out.println(stockItemValue);
        t.sleep(1000);
        
		driver.findElement(By.cssSelector(".panel-default:nth-child(2) .btn")).click();	t.sleep(1000); //Buy Button
		driver.findElement(By.cssSelector(".btn-danger")).click();						t.sleep(1000); //CheckoutButton
		driver.findElement(By.linkText("Sign Out")).click();							t.sleep(1000); //SignOut Button
		driver.findElement(By.id("username")).sendKeys("admin");						t.sleep(1000); //Username
		driver.findElement(By.id("password")).sendKeys("admin");						t.sleep(1000); //Password
		driver.findElement(By.cssSelector(".btn")).click(); 							t.sleep(1000); //Submit Button
		
		//Get number of items value
		String newValue = driver.findElement(By.cssSelector(".panel-default:nth-child(2) > .row")).getText();
		System.out.println(newValue);
		String[] newAry = newValue.split("");
		int newStockItemValue = Integer.parseInt(newAry[newAry.length-5]);
        System.out.println(newStockItemValue);
        t.sleep(1000);
        
        driver.findElement(By.linkText("Sign Out")).click();			t.sleep(1000); //Sign Out
        
        Assert.assertEquals(newStockItemValue, stockItemValue-1);
//		if (newStockItemValue == )
//		{
//		               System.out.println("Successful!");
//		}
//
//		else
//		{
//		               System.out.println("Unsuccessful!");
//		}
		
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
