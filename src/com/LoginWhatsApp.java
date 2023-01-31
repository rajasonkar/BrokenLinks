package com;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginWhatsApp extends TestBase {

	@Test
	public static void chkMsg() throws InterruptedException{
		//objectRepo or = new objectRepo(driver);
		//Thread.sleep(30000);
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("RLfQR")));
	    WebElement  web = driver.findElement(By.className("RLfQR"));
	    List<WebElement> noOfUsers  = web.findElements(By.className("_2wP_Y")); 
	    System.out.println("count :"+noOfUsers.size());
	    List<String> ContactNames  =new ArrayList<String>(); 
	   for(int i=1;i<=noOfUsers.size();i++)
	   {String str = driver.findElement(By.cssSelector("#pane-side > div > div > div > div:nth-child("+i+") > div > div > div > div._3j7s9 > div._1AwDx > div._itDl > span > span")).getText();
		   //System.out.println(str);
	   }
	    /* for(WebElement a :noOfUsers){
	    	System.out.println(driver.findElement(By.className("_1AwDx")).getText());
	    System.out.println("fghd"+a);
	    }*/
	    /*for(int i= 1; i<=noOfUsers.size();i++){
	    	ContactNames.add(driver.findElement(By.xpath("//*[@id='pane-side']/div/div/div/div["+i+"]/div/div/div[2]/div[1]/div[1]/span/span")).getText());
	    	//if(driver.findElement(By.xpath("//*[@id='pane-side']/div/div/div/div[+i+]/div/div/div[2]/div[1]/div[1]/span/span")))
	    }*/
	  //System.out.println("list of contacs :"+ContactNames);
	   WebElement  web1 = driver.findElement(By.className("RLfQR"));
	    List<WebElement> noOfUsers1  = web1.findElements(By.className("_3Bxar"));
	    List<String> usersHavingMessage = new ArrayList<String>();
	    System.out.println("count :"+noOfUsers1.size());
	    for (int i=1;i<=noOfUsers1.size()/2;i++){
	    	//if (i%2==0)
	    	//for geeting no of new msg of a particular user
	    		String str = driver.findElement(By.xpath("//*[@id='pane-side']/div/div/div/div["+i+"]/div/div/div/div[2]/div[2]/div[2]/span[1]")).getText();
	    	if(str.isEmpty())
	    	{
	    		System.out.println("found null value for: "+i);
	    	}
	    	else
	    	{
	    		usersHavingMessage.add("#pane-side > div > div > div > div:nth-child("+i+") > div > div > div > div._3j7s9 > div._1AwDx > div._itDl > span > span");
	    		System.out.println(str);
	    		//for reading message
	    		String str1 = driver.findElement(By.cssSelector("#pane-side > div > div > div > div:nth-child("+i+") > div > div > div > div._3j7s9 > div._1AwDx > div._itDl > span > span")).getText();
	   		    System.out.println(str1);
	    		
	    	}
	    	
	    		//System.out.println(str);
	    	
	    }
	    for(String s:usersHavingMessage )
   	 {
   	  driver.findElement(By.cssSelector(s)).click();	
      driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_1Plpp")));
   	  driver.findElement(By.className("_1Plpp")).sendKeys("Hello from web");
   	  driver.findElement(By.className("_1Plpp")).sendKeys(Keys.ENTER);
   	 }
	} 
}
