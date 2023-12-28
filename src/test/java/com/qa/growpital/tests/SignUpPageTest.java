package com.qa.growpital.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.growpital.base.BaseTest;
import com.qa.growpital.contants.AppConstants;

public class SignUpPageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyLoginPageTitle() throws InterruptedException {
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		String expectedLoginPageTitle = AppConstants.LOGIN1_PAGE_TITLE;
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
	}
	
	@Test(priority = 2)
	public void verifySignUpPageURL() {
		signUpPage = loginPage.navigateToCreateAccount();
		String actualSignUpPageURL = signUpPage.getSignUpPageURL();
		String expectedignUpPageUrl = AppConstants.Sign_Up_PAGE_URL;
		Assert.assertEquals(actualSignUpPageURL, expectedignUpPageUrl);
	}
}
