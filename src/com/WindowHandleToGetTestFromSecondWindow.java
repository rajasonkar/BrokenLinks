package com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WindowHandleToGetTestFromSecondWindow {
WebDriver driver;
	@Test
	public void windowHandlesTest() throws AWTException, InterruptedException{
		System.setProperty("webdriver.chrome.driver","G:/java/chromedriver.exe");
		driver = new ChromeDriver();
	driver.get("https://google.com");
		
		 String parent = driver.getWindowHandle();
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles()); 
		//Set<String> allWindowHandles =new HashSet<String>( driver.getWindowHandles());
		//to switch to window based on index
		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.facebook.com");
		Thread.sleep(2500);
		driver.switchTo().window(tabs.get(0));
		driver.close();
		 
		
	}
	public int m (int a, int b){
		return a;
	}
	public float m(int c, int d, int f){
		return c;
	}

}