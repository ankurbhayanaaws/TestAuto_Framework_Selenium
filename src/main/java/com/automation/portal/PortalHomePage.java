package com.automation.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ElementUtil;

public class PortalHomePage {
	
	WebDriver driver ;
	
	 public PortalHomePage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	By locatorShop = By.linkText("Shop");
	By locatorBYOD = By.xpath("//div[@class ='primary-nav container-fluid']//ul[@id='shopMenuSub']//li[@class ='subNavFour']");
	
	//div[@class ='primary-nav container-fluid']//ul[@id='shopMenuSub']//li[@class ='subNavTwo']
	By locatorSupport = By.xpath("//div[@class ='primary-nav container-fluid']//li[@id='supportMenu']/a");
	
	
	By locatorPhones = By.xpath("//div[@class ='primary-nav container-fluid']//ul[@id='shopMenuSub']//li[@class ='subNavTwo']");
	

	
	public  void clickShop()
	 {
		 ElementUtil ele = new ElementUtil(driver);
		 ele.waitforElementPresenceAndClick(locatorShop, 15);
		 
		 		 
	 }
	
	public	 void clickPhones()
	 {
		 ElementUtil ele = new ElementUtil(driver);
		 ele.waitforElementPresenceAndClick(locatorPhones, 15);
		 		 
	 }
	 
	public void clickSupport()
	 {
		 ElementUtil ele = new ElementUtil(driver);
		 ele.waitforElementPresenceAndClick(locatorSupport, 15);
		 		 
	 }
	 
	public	 void clickBYOD()
	 {
		 ElementUtil ele = new ElementUtil(driver);
		 ele.waitforElementPresenceAndClick(locatorBYOD, 15);
		 		 
	 }
	
	
}
