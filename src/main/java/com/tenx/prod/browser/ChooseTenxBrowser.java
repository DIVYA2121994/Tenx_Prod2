package com.tenx.prod.browser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
	    	 ChromeOptions options = new ChromeOptions();
	    	 options.addArguments("start-maximized"); 
	    	 options.addArguments("enable-automation"); 
	    	 options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	    	 driver=new ChromeDriver(options);
	    	 
	    	 
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
