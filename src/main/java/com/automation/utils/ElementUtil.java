package com.automation.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
   private  WebDriver driver;
   
   Properties prop = DriverFactory.prop;
   JavaScriptUtil jsutil;
   
	
	
	public ElementUtil(WebDriver driver) {
		
		this.driver = driver;
		 jsutil = new JavaScriptUtil(driver);
			
	}
		
	
	public  WebElement getElement(By locator)
	{
		
		WebElement ele =driver.findElement(locator);
	String highlite= prop.getProperty("highlight");
	if( highlite.equalsIgnoreCase("true"))
	{
		jsutil.flash(ele);
	}
		return ele;
		
	}
	
	
	public  void doSendKeys(By locator,String text) {
	
		
		sendKeysCustom(getElement(locator),text) ;
						
	}
	
	
	
	public  void sendKeysCustom(WebElement element, String text)
	{
		
		element.sendKeys(text);
		
	}
	
	
	public void doClick(By locator)
	
	{
	
		getElement(locator).click();
	
	
	}
	
	public boolean doIsDisplayed(By locator) {
		
	return	getElement(locator).isDisplayed();
		
	}
	
	public boolean doIsEnabled(By locator) {
		
	return	getElement(locator).isEnabled();
		
	}
	
	
	public   List<WebElement>  getListOfWeblements(By locatorListOfLinks)
	{
		
		List<WebElement>  listOfLinks =	driver.findElements(locatorListOfLinks);

		return listOfLinks;
		
		
	}
	
	
	public  ArrayList<String> getTextListOfLinks(By locatorListOfLinks)
	
	{
		
		List<WebElement> listOfWebelements = getListOfWeblements(locatorListOfLinks);
		
		ArrayList<String> textListOfWebElements = new ArrayList<String> ();
		
		for ( WebElement e : listOfWebelements)
		{
			textListOfWebElements.add(e.getText());
		}
		
		return textListOfWebElements;
		
					
	}
	
	public  boolean isElementDispayed(By locatorListOfLinks)
	{
		
		if ( (getTextListOfLinks(locatorListOfLinks).size() > 0) )
		{
			return true;
			
		}
		else
			return false;
				
	}
	
	
	
	public void  doSelectByValue(By locator,String value)
	
	 {
		
		
		WebElement element = getElement(locator);
		
		Select selectDropDown = new Select (element);
		
		selectDropDown.selectByValue(value);
		
		
		
		
		 
	 }
	
	
	public void doSelectByValueClick (By locator,String value)
	{
		
	    List<WebElement>  elementList = getListOfWeblements(locator) ;
	    
        try {
       	 
              
		          for ( WebElement e : elementList)
		          {
		        	  if ( e.getText().equals(value))
		        		  
		        	  {
		        		  e.click();
		        	  }
		   
		           
		         }
         
        }
        
        catch  (Exception e)
        {
       	//e.printStackTrace();
       	 
        }
         
		
		
	}
	
	
	public void doRightClickAndChoseOption(By Locator,String option) 
	
	{
		
		Actions act = new Actions (driver);
		
		act.contextClick(getElement(Locator)).perform();
		//Thread.sleep(2000);
		
		By locatorRightClickOptions = By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]");
		
		List<WebElement> rightClickElements = getListOfWeblements(locatorRightClickOptions);
		
		
		for ( WebElement  e : rightClickElements )
		{
			String rightClickOptionText = e.getText();
			System.out.println(rightClickOptionText);
			if ( rightClickOptionText.equals(option))
			{
				
			
				e.click();
			break;
			}
			
		}
		
		
		
	}
	

	public void doRightClick(By Locator) 
	
	{
		
		Actions act = new Actions (driver);
		
		act.contextClick(getElement(Locator)).perform();
		
		
		
	}
	
	
	
	
	
	
	
	public void doActionSendKeys(By locator,String inputvalue)
	
	{
		Actions act = new Actions (driver);
		
		act.sendKeys(getElement(locator), inputvalue).perform();
		
		
	}
	
	
	public void doActionClick(By locator)
	
	{
		Actions act = new Actions (driver);
		
		act.click(getElement(locator)).perform();
		
		
		
	}
	
	
/*******************WAIT Utilities
 ************************************************************/
	
	
	public  WebElement waitforElementPresence(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	
	public  Alert waitAlert(int timeout) {
		
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
		
		
	}
	
	
	public  void acceptAlert(int timeout) {
		
		waitAlert(timeout).accept();
			 
			
			
		}
	
	
	public  void dismissAlert(int timeout) {
		
		waitAlert(timeout).dismiss();
			 
			
			
		}
	
	public  String getAlertText(int timeout) {
		
	String text=waitAlert(timeout).getText();
	acceptAlert(timeout);
	return text;
						
	}
	
	
	public  void waitforElementPresenceAndClick(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		 wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
		
	}
	
	public void mediumWait ()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void longWait ()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
