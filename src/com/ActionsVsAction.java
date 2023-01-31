package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class ActionsVsAction {
	WebDriver driver ;
 public void test(){
	 int x =0;
	 Actions act = new  Actions(driver);
	 org.openqa.selenium.interactions.Action a = act.moveToElement(driver.findElement(By.id(""))).build();
 a.perform();
 for(;x>5;++x){}
 }
}
