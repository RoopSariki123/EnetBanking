package com.InetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(name="uid")
	WebElement textuserName;
	
	@FindBy(name="password")
	WebElement textpwdName;
	
	@FindBy(name="btnLogin")
	WebElement button;
	
	
	public void SetUserName(String user)
	{
		textuserName.sendKeys(user);
	}
	
	public void Setpwd(String pwd)
	{
		textpwdName.sendKeys(pwd);
	}

	public void clickSubmit()
	{
		button.click();
	}

	
}
