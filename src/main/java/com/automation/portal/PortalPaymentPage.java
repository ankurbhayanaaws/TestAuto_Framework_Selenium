package com.automation.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ElementUtil;
import com.automation.utils.JavaScriptUtil;

public class PortalPaymentPage {
	
	WebDriver driver;
	
	public PortalPaymentPage(WebDriver driver) {
		
		this.driver = driver;
		
		
	}
	
	By locatorMakePayment = By.xpath("//button[contains (text() ,'Make a Payment')]");
	By locatorCreditOrDebit = By.xpath("//div[contains (text() ,'Credit or Debit Card')]");
	By locatorNameOnId = By.id("nameOnCard");
	
	By locatorcardNumber = By.id("cardNumber");
	By locatorccMonth = By.id("ccMonth");
	By locatorccYear = By.id("ccYear");
	By locatorsecurityCode = By.id("securityCode");
	By locatorbillingZipCode =By.xpath("//input[contains(@name ,'billingZipCode')]");
	By locaorAcceptCheckBox = By.xpath("//label[contains(text(),'Accept')]");
	By locatorReviewPayment = By.xpath("(//span[contains(text(),'Review Payment')])[2]");
	By locatorSubmitPayment = By.xpath("//button[@tb ='Submit Payment']");
	
	
	
	public void doPayment()
	{
		ElementUtil element = new ElementUtil(driver);
		element.waitforElementPresenceAndClick(locatorMakePayment, 10);
		element.waitforElementPresenceAndClick(locatorCreditOrDebit,10);
		element.doSendKeys(locatorNameOnId, "Ankur");
		element.doSendKeys(locatorcardNumber, "5252525252525252");
		element.doSendKeys(locatorccMonth, "05");
		element.doSendKeys(locatorccYear, "26");
		element.doSendKeys(locatorsecurityCode, "356");
		element.mediumWait();
		element.doSendKeys(locatorbillingZipCode, "30009");
		element.doClick(locaorAcceptCheckBox);

		element.longWait();
		
		JavaScriptUtil js = new JavaScriptUtil(driver);
		js.scrollPageDown();
		
		element.longWait();
		element.waitforElementPresenceAndClick(locatorReviewPayment,10);
		element.waitforElementPresenceAndClick(locatorSubmitPayment,10);				
		
		
	}
	
	

}
