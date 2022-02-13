package com.automation.test.portal;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.utils.ExcelUtil;

import io.qameta.allure.Description;

public class PortalLoginTest extends PortalBaseTest {
	
	
	
	@Description ( "Portal Login using Parameters from getPortal Data")
	@Test(dataProvider = "getPortalData")
	public void doPortalLoginTest(String username,String password) {
		
		portalPayPage =	pl.doLogin(username, password);
		
		
		
	}
	
	
		
	@DataProvider
	public Object[][] getPortalData(){
		
				return new Object[][] {
					
					{"4044066233a","Unix@1234"},
					{"Ashish","Bhayana"}
						
			};
			
			}
	
	@DataProvider
	public Object [][] getTesData() {
		
		return ExcelUtil.getTestData("creditcard");
		
	}
	
	
}
