package com.automation.test.portal;

import org.testng.annotations.Test;

import com.automation.portal.PortalHomePage;

public class PortalHomePageTest extends PortalBaseTest {
	
	
	
	@Test
	public void doHomePageTest() {
		homepage.clickShop();
		homepage.clickPhones();
		homepage.clickBYOD();
		homepage.clickSupport();
	
	}
	
	@Test
	public void doShopTest() {
		homepage.clickShop();
		homepage.clickPhones();
		homepage.clickBYOD();
		homepage.clickSupport();
	
	}
	
	@Test
	public void doSupportTest() {
		homepage.clickShop();
		homepage.clickPhones();
		homepage.clickBYOD();
		homepage.clickSupport();
	
	}
	

}
