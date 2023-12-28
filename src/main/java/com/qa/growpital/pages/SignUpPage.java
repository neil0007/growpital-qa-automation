package com.qa.growpital.pages;

import com.microsoft.playwright.Page;

public class SignUpPage {
private Page page;
	
	//String Locators
	//private String email = "input[name='username']";
	
	
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
