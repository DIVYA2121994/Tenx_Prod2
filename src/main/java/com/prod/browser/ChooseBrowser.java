package com.prod.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ChooseBrowser 
{
	static WebDriver driver;
	public static WebDriver selectDriver(String bname)
      {
	     if (bname.equalsIgnoreCase("chrome"))
	     {
	    	 System.setProperty("webdriver.chrome.driver", "D:\\git\\Tenx_Prod2\\src\\test\\resources\\Drivers\\chromedriver.exe");
	    	 driver=new ChromeDriver();
	    	 driver.manage().window().maximize();
	    	 
	    	 
	     }
	     else if(bname.equalsIgnoreCase("firefox"))
	     {
	    	driver = new FirefoxDriver(); 
	    	System.setProperty("webdriver.gecko.driver", "D:\\git\\Tenx_Prod2\\src\\test\\resources\\Drivers\\geckodriver.exe");
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
