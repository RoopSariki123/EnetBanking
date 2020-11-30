package com.InetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
		
	@Test
	public void LoginTest() throws IOException
	{
		
		
		logger.info("URL Opened");
		
		LoginPage lp = new LoginPage(Driver);
		
		lp.SetUserName(UserName);
		lp.Setpwd(Pwd);
		
		logger.info("Credentails entered");
		lp.clickSubmit();
		logger.info("logined");
		System.out.println(Driver.getTitle());
		
		
		if(Driver.getTitle().equalsIgnoreCase("GTPL Bank Manager HomePage"))
		{
			
			
			
			Assert.assertTrue(true);
			
			logger.info("Testcase success");
			
		}
		else
		{
			captureScreen( Driver, "LoginTest");
			
			
			Assert.assertTrue(false);
			logger.info("Testcase Failure");
			
		}
		 
		
	}
	
	
	
	
}
