package com.patrick.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage
{

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		
		this.driver = ldriver;
		
	}
	

	@FindBy(css="input[name='login']") WebElement user;
	@FindBy(css="input[name='password']") WebElement pwd;
	@FindBy(css="button[data-qa='log_in']") WebElement btnLogin;
	
	
	public void loginWL(String username , String password)
	{
		try
		{
			Thread.sleep(2000);
		}catch(InterruptedException e)
		{
			
		}
		
		user.sendKeys(username);
		pwd.sendKeys(password);
		btnLogin.click();
		
	}
	
}
