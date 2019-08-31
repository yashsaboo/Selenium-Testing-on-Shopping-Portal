package shoppingId.shoppingId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Ques3 extends Thread{
	WebDriver driver;
	
	@SuppressWarnings("static-access")
	@Test
	public void f() throws Exception
	{
		Thread t = new Thread();
		Assert.assertEquals(driver.getTitle(),"Shop");
		int i=0;
		int stockItemValue;
		try {
			
			do
			{
				
				driver.findElement(By.id("username")).sendKeys("admin");	t.sleep(1000); //Username
				driver.findElement(By.id("password")).sendKeys("admin");	t.sleep(1000); //Password
				driver.findElement(By.cssSelector(".btn")).click();			t.sleep(1000); //Submit Button
				
				//Get number of items value
				String value = driver.findElement(By.cssSelector(".panel-default:nth-child(3) > .row")).getText();
				System.out.println(value);
				String[] ary = value.split("");
				stockItemValue = Integer.parseInt(ary[ary.length-5]);
		        System.out.println(stockItemValue);
				t.sleep(1000);
				
				
				driver.findElement(By.cssSelector(".panel-default:nth-child(3) .btn")).click();	t.sleep(1000); //Buy Button
				driver.findElement(By.cssSelector(".btn-danger")).click(); 						t.sleep(1000); //CheckoutButton
				driver.findElement(By.linkText("Sign Out")).click();							t.sleep(1000); //SignOut Button
				
			}while(i<stockItemValue);
		}
		catch(Exception e)
		{
			Assert.assertEquals(e.getClass() + "", "class java.lang.NumberFormatException");
		}
		
//		catch(java.lang.NumberFormatException e)
//		{
//			System.out.println("Successful Test!");
//			System.out.println(e.getClass());
//		}
//		catch(Exception e2)
//		{
//			System.out.println("Unsuccessful Test!");
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
