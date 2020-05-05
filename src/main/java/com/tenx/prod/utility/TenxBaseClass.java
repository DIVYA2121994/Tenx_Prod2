package com.tenx.prod.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenxBaseClass 
{
	public static WebDriver driver;
	protected static Properties p = new Properties();
	WebDriverWait wait;
	public static void setHighlight(WebDriver driver, WebElement element) 
	{
		try 
		{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid orange;');", element);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static void type(WebDriver driver, WebElement element, String value)
	{
		try 
		{
		 setHighlight(driver,element);
		 element.sendKeys(value);
		} 
		catch (Exception e) 
		{
		e.printStackTrace();
		}
	}
	public static void click(WebDriver driver, WebElement element)
	{
		try 
		{
		 setHighlight(driver,element);
		 element.click();
		} 
		catch (Exception e) 
		{
		 e.printStackTrace();
		}
	}
	public static Properties prop()
	{
		try
		{
	     String path = System.getProperty("user.dir");
	     File file = new File (path+"\\src\\test\\resources\\config.properties");
		 FileInputStream fis = new FileInputStream (file);
		 p.load(fis);
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
		return p;
		
	}
	
	 public static String getScreenshot (WebDriver driver, String screenshotName) throws IOException
     {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
    	String destination = System.getProperty("user.dir")+"/Screenshots/"+screenshotName+dateName+".png";
    	File finaldestination = new File (destination);
    	FileUtils.copyFile(source, finaldestination);
        return destination;
    	 
     }
	 public boolean isObjectDisplayed(WebDriver driver, WebElement element) 
	 {
			int attempts = 0;
			boolean isObjDisp = false;
			while(attempts < 5) 
			{
				try 
				{
					Thread.sleep(500);
					element.isDisplayed();
					isObjDisp = true;
					break;
				}

				catch (Exception e) {
					e.printStackTrace();
				}
				attempts++;	
			}
			return isObjDisp;
		}
	 public void actions(WebDriver driver, WebElement element)
	 {
		 Actions ac = new Actions (driver);
		 driver.navigate().refresh();
		 wait = new WebDriverWait(driver, 10000);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 ac.moveToElement(element).build().perform();
		 click(driver, element);
	 }
	 public void jsclick(WebDriver driver, WebElement element)
	 {
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 System.out.println("element going to click");
		 setHighlight(driver, element);
		 executor.executeScript("arguments[0].click();", element);
	 }
}
