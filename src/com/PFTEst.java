package com;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PFTEst extends PageFactoryTest{

	public PFTEst(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 // @Test
	public static void loginTo(String strUserName,String strPasword) throws InterruptedException{
	    //Click Login button

		System.setProperty("webdriver.chrome.driver","G:/java/cd/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://phptravels.com/demo/");
	   driver.manage().window().maximize();

	        clickLogin();  
	    	Thread.sleep(2000);
	    	Set<String> s = driver.getWindowHandles();
	    	for(String i : s)
	    	{
	    		driver.switchTo().window(i);
	    		break;
	    	}
	    	
	    	//Fill user name

	   //     setUserName(strUserName);

	        //Fill password

	   //     setPassword(strPasword);

	                 

	    }

	public static void main (String args[]) throws InterruptedException{
		loginTo("strUserName", "strPasword");
	}
}
