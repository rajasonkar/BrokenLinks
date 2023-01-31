package com;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestBrokenLinks {
public static WebDriver driver;

public static void setup() {
System.setProperty("webdriver.chrome.driver","G:/java/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.facebook.com");
}
@Test
public void test () throws MalformedURLException, IOException{
	setup();
	//to get all the link under a tag
	List<WebElement> link = driver.findElements(By.tagName("a"));
	System.out.println("link size "+link.size());
	//to get all the images
	link.addAll(driver.findElements(By.tagName("img")));
	System.out.println("link size after adding images"+link.size());
	//to find active links on the page
	List <WebElement> activeLinks = new ArrayList<WebElement>();
	int i;
	for( i=0;i<link.size();i++){
		if(link.get(i).getAttribute("href")!= null){
			activeLinks.add(link.get(i));}
		}
			System.out.println("size of active link : "+activeLinks.size());
		
		for(int j=0;j<activeLinks.size();j++){
			try{
			
			HttpURLConnection con =(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		    //to get with url
			con.connect();
			//to get response message
			String resposeMsg = con.getResponseMessage();
			//to disconnect
			con.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"-->"+resposeMsg);
			
		}catch(Exception e){}
		}
			
	//if it consist of javaScript in url
	//	if(link.get(i).getAttribute("href")!=null && (!link.get(i).getAttribute("href").contains("javascript"))){
	//		activeLinks.add(link.get(i));
	//	}
	System.out.println("quiting driver");
	driver.quit();

	
} 
}
