package com.tenx.prod.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ChooseTenxBrowser 
{
	static WebDriver driver;
	public static WebDriver selectDriver(String bname)
      {
	     if (bname.equalsIgnoreCase("chrome"))
	     {
	    	 String path = System.getProperty("user.dir");
	    	 System.setProperty("webdriver.chrome.driver",path+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
	    	 driver=new ChromeDriver();
	    	 driver.manage().window().maximize();
	    	 
	    	 
	     }
	     else if(bname.equalsIgnoreCase("firefox"))
	     {
	    	 String path = System.getProperty("user.dir");
	    	 System.setProperty("webdriver.chrome.driver",path+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
	    	 driver=new FirefoxDriver();
	    	 driver.manage().window().maximize();
	     }
	     else if(bname.equalsIgnoreCase("ie"))
	     {
	    	 driver = new InternetExplorerDriver();
	     }
	     return driver;
      }
}
