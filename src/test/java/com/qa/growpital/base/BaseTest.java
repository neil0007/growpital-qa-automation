package com.qa.growpital.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.growpital.factory.PageFactory;
import com.qa.growpital.pages.DashboardPage;
import com.qa.growpital.pages.LoginPage;
import com.qa.growpital.pages.SignUpPage;

public class BaseTest {

	PageFactory pf;
	Page page;
	protected Properties prop;
	protected LoginPage loginPage;
	protected DashboardPage dashboardPage;
	protected SignUpPage signUpPage;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String browserName) {
		pf = new PageFactory();
		prop = pf.init_prop();
		
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		
		page = pf.initBrowser(prop);
		loginPage = new LoginPage(page);
		dashboardPage = new DashboardPage (page);
		
	}
	
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
