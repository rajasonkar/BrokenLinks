package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class objectRepo {
WebDriver driver;
public objectRepo(WebDriver driver){
	this.driver= driver;
}
WebElement leftMostTableClass = driver.findElement(By.className("RLfQR"));
public WebElement leftMostTableClass(WebDriver driver){
	return leftMostTableClass;}
}
