package com.qa.growpital.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class LoginPage {
	private Page page;
	
	//String Locators
	private String email = "input[name='username']";
	private String password = "input[name='password']";
	private String loginButton = "(//button[@type='button'])[2]";
	private String forgotPassword = "(//a[@class='amplify-link'])[1]";
	private String signUp = "(//a[@class='amplify-link'])[2]";
	private String createAccount = "//a[@href='/signup']";
	
	//page constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	
	//page actions/methods:
	public String getLoginPageTitle() throws InterruptedException {
		//page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		//page.waitForLoadState(LoadState.LOAD);
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}

	public String getDashboardPageURL() {
		String url =  page.url();
		return url;
	}

	public void enterEmailAddress(String userEmail) {
		page.fill(email, userEmail);
	}
	
	public void enterPassword(String userPassword) {
		page.fill(password, userPassword);
	}
	
	public void clickOnLoginButton() {
		page.click(loginButton);
	}
	
	public boolean isForgotPasswordLink() {
		page.waitForSelector(forgotPassword);
		 return page.isVisible(forgotPassword);
	}
	
	public boolean isSignUpLink() {
		return page.isVisible(signUp);
	}
	
	public SignUpPage navigateToCreateAccount () {
		page.click(createAccount);
		return new SignUpPage(page);
		
	}
}
