package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class TestBase {
	static WebDriver driver;
	 public static WebDriverWait driverWait;
@BeforeClass
	public static void setUp(){
	System.setProperty("webdriver.chrome.driver","G:/java/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://web.whatsapp.com/");
   
	driver.findElement(By.xpath("//*[contains(text(),'Keep me signed in')]")).click();
    driverWait=	new WebDriverWait(driver,60);

    
}
}
