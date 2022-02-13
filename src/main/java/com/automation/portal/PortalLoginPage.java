package com.automation.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ElementUtil;

public class PortalLoginPage {
	
	WebDriver driver;
	
	public PortalLoginPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	
	By locatorMyAccount = By.linkText("My Account");
	By locatorUserName = By.id("usernameInputField");
	By locatorPassword = By.id("passwordInputField");
	By locatorSignInButton = By.id("signIn");
	By locatorLogout = By.linkText("Log out");
	By locatorAccountSummary = By.xpath("//div[@class='row']/h1[text()='Account Summary']");
	
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
	
	
	public void goToLoginPage() {
	
		ElementUtil ele= new ElementUtil(driver);
		
		ele.waitforElementPresenceAndClick(locatorMyAccount, 10);
			
		}
	
	
	public String getTitle() {
		
	return driver.getTitle();
			
		}
	
	public PortalPaymentPage doLogin(String username, String password) {
	
		
	ElementUtil element = new ElementUtil(driver);
		
		element.waitforElementPresenceAndClick(locatorMyAccount, 10);
		element.doSendKeys(locatorUserName, username);
		element.doSendKeys(locatorPassword, password);
		element.doClick(locatorSignInButton);
		return new PortalPaymentPage(driver);
	
	}
	

}
