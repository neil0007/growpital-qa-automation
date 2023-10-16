package com.qa.growpital.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	private Page page;
	
	//String Locators
	private String email = "input[name='username']";
	private String password = "input[name='password']";
	private String loginButton = "(//button[@type='button'])[2]";
	
	
	//page constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	
	//page actions/methods:
	public String getLoginPageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}

	public String getDashboardPageURL() {
		String url =  page.url();
		//System.out.println("page url : " + url);
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
	
}
