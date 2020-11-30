package com.InetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfg {
	
	Properties pro;
	
	public ReadConfg()
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String getApplicationUrl()
	{
		String url =pro.getProperty("BaseUrl");
		return url;
		
	}
	public String getUserName()
	{
		String UserName =pro.getProperty("UserName");
		return UserName;
		
	}
	public String getPassward()
	{
		String passward =pro.getProperty("Password");
		return passward;
		
	}
	public String getBrowser()
	{
		String Browser =pro.getProperty("firefoxPath");
		return Browser;
		
	}
	

}
