package com.InetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;



public class Reporting extends TestListenerAdapter{
	
	public ExtentReports extent;
	public ExtentTest logger;
	public ExtentHtmlReporter htmlReporter;
	
	
	public void onStart(ITestContext testContext){
		
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/"+repName);//Specify Location
		 htmlReporter.loadXMLConfig(System.getProperty("user.dir") +"/extentConfg.xml");
		 
		 extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
			extent.setSystemInfo("Environment", "Automation Testing");
			extent.setSystemInfo("User Name", "Roop_Kumar");
			
			htmlReporter.config().setDocumentTitle("Title of the Report Comes here");//Title of report
		     htmlReporter.config().setReportName("Name of the Report Comes here");//Name of the Report
		     htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//Location Of the Chat
		     htmlReporter.config().setTheme(Theme.STANDARD);

		
	}
	
	
	
	public void onTestSuccess(ITestResult tr){
		logger = extent.createTest(tr.getName());//Create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	
	public void onTestFailure(ITestResult tr){
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		String ScreenShotPath = System.getProperty("user.dir"+ "\\ScreenShots\\"+tr.getName()+".png");
		
		File f = new File(ScreenShotPath);
		
		if(f.exists())
		{
			try {
				logger.fail("ScreenShot is below :" +logger.addScreenCaptureFromPath(ScreenShotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		
	}
	public void skipTest(ITestResult tr){
	     logger = extent.createTest(tr.getName());
	     logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	

	
	public void onFinish(ITestContext  testContext)
	{
		extent.flush();
	}
	
}
