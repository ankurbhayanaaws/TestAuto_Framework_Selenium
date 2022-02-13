package com.automation.test.portal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class PortalPaymentTest extends PortalBaseTest{
	
	
	
	@BeforeClass
	
	public void  portalPaymentPageSetup() {
		
					
	}
	
	
	
	@Description ("Portal Make Payment Test")
	@Test(dataProvider = "getPortalData")
	public void doPortalPaymentTest (String username,String password) {
		portalPayPage= pl.doLogin(username, password);
		portalPayPage.doPayment();
					
	}
	
	
	@DataProvider
	public Object[][] getPortalData(){
		
				return new Object[][] {
					
					{"4044066233a","Unix@1234"},
					{"Ashish","Bhayana"}
										
			};
	
	}
	
	

}
