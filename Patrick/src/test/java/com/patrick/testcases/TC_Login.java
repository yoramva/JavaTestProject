package com.patrick.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.patrick.pages.BaseClass;
import com.patrick.pages.LoginPage;

public class TC_Login extends BaseClass {

	@Test
	public void loginApp() 
	{
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginWL("BaseD8@pfslab.local", "ui78UI");
		
	}
	
}
