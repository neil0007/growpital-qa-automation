package com.qa.growpital.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.growpital.base.BaseTest;
import com.qa.growpital.contants.AppConstants;

public class InvestPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void verifyDashboardPageTitle() throws InterruptedException {
		loginPage.loginToGrowpital(AppConstants.Prod_Email, AppConstants.Prod_Password);
		Thread.sleep(5000);
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		String expectedLoginPageTitle = AppConstants.DASHBOARD_PAGE_TITLE;
		Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);
		
	}
	@Test(priority = 2)
	public void verifyInvestPageURL() {
		investPage = dashboardPage.navigateToInvestTab();
		String actualInvestPageURL = investPage.getInvestPageURL();
		String expectedInvestPageURL = AppConstants.Invest_Page_URL;
		Assert.assertEquals(actualInvestPageURL, expectedInvestPageURL);
	}
	
	@Test(priority=3)
	public void verifyInvestPageTitle() {
		String actualInvestPageTitle = investPage.getInvestPageTitle();
		String expectedInvestPageTitle = AppConstants.Invest_Page_Title;
		Assert.assertEquals(actualInvestPageTitle, expectedInvestPageTitle);
	}
	
	@Test(priority = 4)
	public void verifySelectInvestmentPageURL() {
		String actualInvestmentPageURL = investPage.getInvestmentURL();
		String expectedInvestmentPageURL = AppConstants.Investment_Page_URL;
		Assert.assertEquals(actualInvestmentPageURL, expectedInvestmentPageURL);
		}
	
	@Test(priority = 5)
	public void verifySubHeading() {
		String actualSubHeading = investPage.getSubHeading();
		String expectedSubHeading = AppConstants.Investment_Page_Subheading;
		Assert.assertEquals(actualSubHeading, expectedSubHeading);
	}
	
	@Test(priority = 6)
	public void verifyUnitCalculationCardHead() {
		String actualUnitCalcualtionCardHeading = investPage.unitCalcualtionCardHeading();
		String expectedUnitCalcualtionCardHeading = AppConstants.Calcualtion_Card_Heading;
		Assert.assertEquals(actualUnitCalcualtionCardHeading, expectedUnitCalcualtionCardHeading);
	}
	
	@Test(priority = 7)
	public void verifyContinueButtonIsDisabled () {
		Assert.assertFalse(investPage.isContinueButton(), "Continue Button should be disabled before entring Unit");
	}
	
	@Test(priority = 8)
	public void verifyContinueButtonIsEnabled() {
		investPage.enterUnits("1");
		investPage.clickOnContinueButton();
		Assert.assertTrue(investPage.isContinueButton(), "Continue Button should be enable after entring Unit");
	}
	
	@Test(priority = 9)
	public void verifyInvestmentPaymentPageURL() {
		String actualInvestmentPaymentPageURL = investPage.getInvestmentPaymentPageURL();
		String expectedInvestmentPaymentPageURL = AppConstants.Investment_Payement_URL;
		Assert.assertEquals(actualInvestmentPaymentPageURL, expectedInvestmentPaymentPageURL);
	}
	
	@Test(priority = 10)
	
	public void verifyIsPaymentPageContinueButton() {
		Assert.assertTrue(investPage.isPaymentPageContinueButton(), "Continue Button present in payment section is disable because Money Is insufficient");
	}
	
	@Test(priority = 11)
	public void verifyPaymentMessage () {
		String actualPaymentMessage = investPage.getPaymentMessage();
		String expectedPyamentMessage = AppConstants.Payment_Message;
		Assert.assertEquals(actualPaymentMessage, expectedPyamentMessage);
	}
	
	@Test(priority = 12)
	public void verifyConsentLetterPageURL() {
		investPage.clickOnNextContinuebutton();
		String actualConsentLetterPageURL = investPage.getConsentLetterPageURL();
		String expectedConsentLetterPageURL = AppConstants.Consent_Letter_Page_URL; 
		Assert.assertEquals(actualConsentLetterPageURL, expectedConsentLetterPageURL);
		}
	
	@Test(priority = 13)
	public void verifyMandatoryTextInfoBeforeSigningConsentLetter(){
		String actualMandatoryTextInfoBeforeSigningConsentLetter = investPage.getMandatoryTextOfConsentLetter();
		String expectedMandatoryTextInfoBeforeSigningConsentLetter = AppConstants.Mandatory_Text_ConsentLetter;
		Assert.assertEquals(actualMandatoryTextInfoBeforeSigningConsentLetter, expectedMandatoryTextInfoBeforeSigningConsentLetter);
	}
	
	@Test(priority = 14)
	public void verifyPlanPurchaseText(){
		investPage.signConsentLetter();
		String actualPlanPurchaseText = investPage.getConfirmationTextAfterSigningConsentLetter();
		String expectedPlanPurchaseText = AppConstants.Plan_Purchase_Text;
		Assert.assertEquals(actualPlanPurchaseText, expectedPlanPurchaseText);
	}
	
	@Test(priority = 15)
	public void verifyCancelPlanPageTitle(){
		String actualCancelPlanPageTitle = investPage.navigateToCancelPlan();
		String expectedCancelPlanPageTitle = "My Investment | Growpital";
		Assert.assertEquals(actualCancelPlanPageTitle, expectedCancelPlanPageTitle);
	}

	@Test(priority = 16)
	public void verifyStatusOfPlan() {
		investPage.cancelPlan();
		String actualStatus = investPage.checkPlanCancel();
		String expectedStatus = "Cancelled";
		Assert.assertEquals(actualStatus, expectedStatus);
		}

}
