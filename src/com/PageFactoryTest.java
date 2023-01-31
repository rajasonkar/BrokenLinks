package com;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PageFactoryTest {
	 /**

     * All WebElements are identified by @FindBy annotation

     */

    static WebDriver driver;

    @FindBy(name="uid")

    WebElement user99GuruName;

    @FindBy(name="password")

    WebElement password99Guru;    

    @FindBy(className="barone")

    WebElement titleText;

    @FindBy(className="button_to")
	static

    WebElement login;

    public PageFactoryTest(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    //Set user name in textbox

    public void setUserName(String strUserName){

        user99GuruName.sendKeys(strUserName);     
    }

    //Set password in password textbox

    public void setPassword(String strPassword){

    password99Guru.sendKeys(strPassword);

    }

    //Click on login button

    public static void clickLogin(){

            login.click();

    }  

    //Get the title of Login Page

    public String getLoginTitle(){

     return    titleText.getText();

    }

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return
     * @throws InterruptedException 

     */
    @Test
    public void loginToGuru99(String strUserName,String strPasword) throws InterruptedException{
    //Click Login button

    	System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
    	
        FirefoxDriver	driver = new FirefoxDriver();
        driver.get("http:www.facebook.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        this.clickLogin();  
    	Thread.sleep(2000);
    	Set<String> s = driver.getWindowHandles();
    	for(String i : s)
    	{
    		driver.switchTo().window(i);
    		break;
    	}
    	
    	//Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

                 

    }


}
