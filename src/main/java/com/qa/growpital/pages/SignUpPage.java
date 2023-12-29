package com.qa.growpital.pages;

import com.microsoft.playwright.Page;

public class SignUpPage {
private Page page;
	
	//String Locators
	private String loginLink = "//a[normalize-space()='Login']";
	private String supportLink = "//a[normalize-space()='support@growpital.com']";
	private String email = "//input[@placeholder='Enter Email Address']";
	private String firstName = "//input[@placeholder='Enter First Name']";
	private String lastName = "//input[@placeholder='Enter Last Name']";
	private String countryFlag = "//div[contains(@class,'flag-container')]";
	private String phoneNumber = "//div[2]/input";
	private String nextButton = "//button[text()='Next']";
	private String password = "//input[@name='password']";
	private String confirmPassword = "//input[@name='confirm_password']";
	private String anotherStepCloserButton = "//button[text()='Another Step Closer']";
	private String amountDropdown = "(//div[@class='flag-container'])[1]";
	private String residentDropdown = "(//div[@class='flag-container'])[2]";
	private String referralCode = "//input[@placeholder='Referral Code']";
	private String termsCheckBox = "//span[@class='amplify-flex amplify-checkbox__button amplify-checkbox__button--error']";
	private String termsAndConditionsLink = "//a[@href='https://www.growpital.com/terms-of-use']";
	private String createAccountButton = "//button[@data-testid='login']";
	private String oTPBox = "//input[@name='code']";
	private String confrimEmailButton = "//button[@data-testid='submit-confirmation-code']";
	private String resendOTPLink = "(//a[@variation='link'])[2]";
	private String invalidCodeEnterText = "(//div[1]/p)[2]";

	//page constructor
	public SignUpPage(Page page) {
		this.page = page;
	}

	
	//page actions/methods:

	public String getSignUpPageURL() {
		String url =  page.url();
		return url;
	}


}
