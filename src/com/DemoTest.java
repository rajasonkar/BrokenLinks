package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DemoTest {
	@Test
	public static void setUp() throws InterruptedException{
		WebDriver driver;
		WebDriverWait driverWait;
		System.setProperty("webdriver.chrome.driver","G:/java/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://panitr.com/");
	   
		driver.findElement(By.cssSelector("body > app-root > div > navbar > div > mat-toolbar:nth-child(2) > div > mat-toolbar-row > button:nth-child(10) > span")).click();
	   Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[contains(text(),'SIGN UP')]")).click();
		driver.findElement(By.name("userName")).sendKeys("sdsdds");
		driver.findElement(By.id("txtEmail")).sendKeys("abc@bac.co");
		
		driver.findElement(By.name("password")).sendKeys("Pass@1234");
		driver.findElement(By.name("confirmPassword")).sendKeys("Pass@1234");
		driver.findElement(By.xpath("//*[contains(text(),'SIGN UP')]")).click();
		
		
		
		driverWait=	new WebDriverWait(driver,60);

	    
	}
}
