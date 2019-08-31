package shoppingId.shoppingId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Ques1 extends Thread{
	WebDriver driver;
	Thread t = new Thread();
	
	@SuppressWarnings("static-access")
	public void completeRegistrationWithLogin() throws Exception
	{
		driver.findElement(By.linkText("Registration")).click();	t.sleep(3000); //ClickRegistration
		driver.findElement(By.id("name")).sendKeys("Yash");			t.sleep(3000); //FirstName
		driver.findElement(By.id("lastName")).sendKeys("Saboo");	t.sleep(3000); //LastName
		driver.findElement(By.id("email")).sendKeys("ys@sit.in");	t.sleep(3000); //Email
		driver.findElement(By.id("password")).sendKeys("lol bro");	t.sleep(3000); //Password
		driver.findElement(By.id("username")).sendKeys("ys9997");	t.sleep(3000); //Username
		driver.findElement(By.cssSelector(".btn")).click();			t.sleep(3000); //Submit Button Click
		String Alertmessage = driver.findElement(By.cssSelector(".alert")).getText();
		Assert.assertEquals(Alertmessage.trim(), "User has been registered successfully");
		
		driver.findElement(By.linkText("Login")).click();			t.sleep(3000); //ClickLogin
		driver.findElement(By.id("username")).sendKeys("ys9997");	t.sleep(3000); //Username
		driver.findElement(By.id("password")).sendKeys("lol bro");	t.sleep(3000); //Password
		driver.findElement(By.cssSelector(".btn")).click();			t.sleep(3000); //Login Button Click
		driver.findElement(By.linkText("Sign Out")).click();		t.sleep(3000); //Sign Out
	}
	
	@SuppressWarnings("static-access")
	public void noValues() throws Exception
	{
		driver.findElement(By.linkText("Registration")).click();	t.sleep(3000); //ClickRegistration
		driver.findElement(By.cssSelector(".btn")).click();			t.sleep(3000); //Submit Button Click
		
		String Alertmessage1 = driver.findElement(By.cssSelector(".form-group:nth-child(1) > .alert")).getText();
		Assert.assertEquals(Alertmessage1.trim(), "*Please provide your name");
		
		String Alertmessage2 = driver.findElement(By.cssSelector(".form-group:nth-child(2) > .alert")).getText();
		Assert.assertEquals(Alertmessage2.trim(), "*Please provide your last name");
		
		String Alertmessage3 = driver.findElement(By.cssSelector(".form-group:nth-child(3) > .alert")).getText();
		Assert.assertEquals(Alertmessage3.trim(), "*Please provide an email");
		
		String Alertmessage4 = driver.findElement(By.cssSelector(".form-group:nth-child(4) > .alert")).getText();
		String passwordAlerts[] = Alertmessage4.split("\\r?\\n");
		try {
			Assert.assertEquals(passwordAlerts[0].trim(), "*Please provide your password");
			Assert.assertEquals(passwordAlerts[1].trim(), "*Your password must have at least 5 characters");
		}
		catch(AssertionError e){
			Assert.assertEquals(passwordAlerts[1].trim(), "*Please provide your password");
			Assert.assertEquals(passwordAlerts[0].trim(), "*Your password must have at least 5 characters");			
		}
		
		String Alertmessage5 = driver.findElement(By.cssSelector(".form-group:nth-child(5) > .alert")).getText();
		String usernameAlerts[] = Alertmessage5.split("\\r?\\n");
		try {
			Assert.assertEquals(usernameAlerts[0].trim(), "*Please provide your name");
			Assert.assertEquals(usernameAlerts[1].trim(), "*Your username must have at least 5 characters");
		}
		catch(AssertionError e){
			Assert.assertEquals(usernameAlerts[1].trim(), "*Please provide your name");
			Assert.assertEquals(usernameAlerts[0].trim(), "*Your username must have at least 5 characters");
		}
	}
	
	@SuppressWarnings("static-access")
	public void lessThan5CharactersPresentInUsernameAndPassword() throws Exception
	{
		driver.findElement(By.linkText("Registration")).click();	t.sleep(3000); //ClickRegistration
		driver.findElement(By.id("email")).sendKeys("123");			t.sleep(3000); //Email
		driver.findElement(By.id("password")).sendKeys("123");		t.sleep(3000); //Password
		driver.findElement(By.id("username")).sendKeys("123");		t.sleep(3000); //Username
		driver.findElement(By.cssSelector(".btn")).click();			t.sleep(3000); //Submit Button Click
		
		String Alertmessage1 = driver.findElement(By.cssSelector(".form-group:nth-child(3) > .alert")).getText();
		Assert.assertEquals(Alertmessage1.trim(), "*Please provide a valid Email");
		
		String Alertmessage2 = driver.findElement(By.cssSelector(".form-group:nth-child(4) > .alert")).getText();
		Assert.assertEquals(Alertmessage2.trim(), "*Your password must have at least 5 characters");
		
		String Alertmessage3 = driver.findElement(By.cssSelector(".form-group:nth-child(5) > .alert")).getText();
		Assert.assertEquals(Alertmessage3.trim(), "*Your username must have at least 5 characters");
	}
	
	@SuppressWarnings("static-access")
	public void checkRegisteredUsers() throws Exception
	{
		driver.findElement(By.linkText("Registration")).click();			t.sleep(3000); //ClickRegistration
		driver.findElement(By.id("email")).sendKeys("johndoe@gmail.com");	t.sleep(3000); //Email
		driver.findElement(By.id("username")).sendKeys("johndoe");			t.sleep(3000); //Username
		driver.findElement(By.cssSelector(".btn")).click();					t.sleep(3000); //Submit Button Click
		
		String Alertmessage1 = driver.findElement(By.cssSelector(".form-group:nth-child(3) > .alert")).getText();
		Assert.assertEquals(Alertmessage1.trim(), "There is already a user registered with the email provided");
		
		String Alertmessage3 = driver.findElement(By.cssSelector(".form-group:nth-child(5) > .alert")).getText();
		Assert.assertEquals(Alertmessage3.trim(), "There is already a user registered with the username provided");
	}
	
	@Test
	public void f() throws Exception
	{
		Assert.assertEquals(driver.getTitle(),"Shop");
		t.sleep(5000);
		noValues();
		lessThan5CharactersPresentInUsernameAndPassword();
		checkRegisteredUsers();
		completeRegistrationWithLogin();
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