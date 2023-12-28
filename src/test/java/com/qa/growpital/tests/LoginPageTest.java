package com.qa.growpital.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qa.growpital.base.BaseTest;
import com.qa.growpital.contants.AppConstants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority = 1)
	public void verifyLoginPageTitle() throws InterruptedException {
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		String expectedLoginPageTitle = AppConstants.LOGIN1_PAGE_TITLE;
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
	}
	
	@Test(priority = 2)
	public void verifyForgotPasswordLinkExist() {
		Assert.assertTrue(loginPage.isForgotPasswordLink(), "Forgot Password link is missing from Login Page");
	}
	
	@Test(priority = 3)
	public void verifySignUpLinkExist() {
		Assert.assertTrue(loginPage.isSignUpLink(), "Sign Up link is missing from Login Page");
	}
	
	@Test(priority = 4)
	public void loginToGrowpital() throws InterruptedException {
		loginPage.enterEmailAddress("neil@growpital.com");
		loginPage.enterPassword("Liverpool@01");
		loginPage.clickOnLoginButton();
		Thread.sleep(5000);
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		String expectedLoginPageTitle = AppConstants.LOGIN_PAGE_TITLE;
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
	}
	
	@Test(priority = 5)
	public void verifyDashboardPageURL() throws InterruptedException {
		String actualDashboardPageURL = loginPage.getDashboardPageURL();
		String expectedDashboardPageURL = AppConstants.DASHBOARD_PAGE_URL;
		Assert.assertEquals(actualDashboardPageURL, expectedDashboardPageURL);
		Thread.sleep(5000);
	}
	
	@Test(priority = 6)
	public void verifySingOutText() throws InterruptedException {
		Thread.sleep(5000);
		dashboardPage.clickOnProfileIconPopUp();
		String actualTextPresentOnSingOutButton = dashboardPage.verifyTextPresentOnSingOutButton();
		String expectedlTextPresentOnSingOutButton = "Sign out";
		Assert.assertEquals(actualTextPresentOnSingOutButton, expectedlTextPresentOnSingOutButton);
	}
	
	@Test(priority = 7)
	public void verifySingOutFromApp() throws InterruptedException {
		dashboardPage.clickOnSignOutButton();
		String actualDashboardPageTitlLe = dashboardPage.getDashboardPageTitlLe();
		String expectedDashboardPageTitlLe = AppConstants.LOGIN_PAGE_TITLE;
		Assert.assertEquals(actualDashboardPageTitlLe, expectedDashboardPageTitlLe);
	}
	

}
