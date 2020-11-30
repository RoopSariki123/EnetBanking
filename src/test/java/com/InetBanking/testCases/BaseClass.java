package com.InetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.InetBanking.utilities.ReadConfg;

public class BaseClass {
	
	
	ReadConfg readConfg = new ReadConfg();
	
	public	String	BaseUrl =readConfg.getApplicationUrl() ;	
	public String UserName =readConfg.getUserName();
	public String Pwd =readConfg.getPassward();
	public static WebDriver Driver;
	public static Logger logger;
	
	@Parameters("Browser")
	@BeforeMethod()
	public void SetUp(String br)
	{
		
		logger=Logger.getLogger("Ebanking");
		PropertyConfigurator.configure("log4j2.properties");
		
		if(br.equalsIgnoreCase("fireFox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfg.getBrowser());
			Driver = new FirefoxDriver();
		}
		
		else
		{
			System.out.println("Browser error");
		}
		
		Driver.get(BaseUrl);
		
	}
	
	@AfterMethod()
	public void tearDoen()
	{
		Driver.quit();
	}

	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShot/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot Taken");
	}
}
