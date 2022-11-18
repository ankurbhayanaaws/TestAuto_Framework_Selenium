package com.automation.test.portal;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.automation.portal.PortalHomePage;
import com.automation.portal.PortalLoginPage;
import com.automation.portal.PortalPaymentPage;
import com.automation.utils.DriverFactory;

public class PortalBaseTest {
	
	WebDriver driver;
	PortalLoginPage pl;
	PortalPaymentPage portalPayPage;
	PortalHomePage  homepage;
	 
	@BeforeMethod
	public void testSetup() {
		Properties prop;
		
		DriverFactory df = new DriverFactory();
		prop= df.initProperties();
		driver =df.initDriver(prop);
     //    pl = new PortalLoginPage(driver);
		  homepage = new PortalHomePage(driver);
		
		
	}
	
	
	@AfterMethod
		public void tearDown() {
		driver.close();
	}
	
	

}
