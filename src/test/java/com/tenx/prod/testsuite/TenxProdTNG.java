package com.tenx.prod.testsuite;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tenx.prod.browser.ChooseTenxBrowser;
import com.tenx.prod.po.TenxPageObjects;
import com.tenx.prod.utility.TenxBaseClass;

public class TenxProdTNG extends TenxBaseClass
{
	public WebDriver driver; 
	public ExtentSparkReporter htmlreport;
	public ExtentReports extent;
	public ExtentTest test;
	
   @BeforeSuite
	public void setExtent()
	{
		htmlreport = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/10X_ProdStatusReport.html");
		htmlreport.config().setDocumentTitle("Tenx Production"); //Title of the Report
		htmlreport.config().setReportName("Tenx Production State"); //Name of the Report
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setTimeStampFormat("dd.MM.yyyy.HH.mm.ss");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setAnalysisStrategy(AnalysisStrategy.SUITE);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Divya_Ashvich");
		extent.setSystemInfo("BowserInformation", p.getProperty("Browser"));
	}
	
	@BeforeMethod
	 public void browser()
	 {
		 prop();
		 String browser = p.getProperty("Browser");
		 driver = ChooseTenxBrowser.selectDriver(browser);
		
		 
	  }
	@Test(priority = 0, enabled = true)
	public void efc_pharmacy_prod() throws InterruptedException
	{
		test = extent.createTest("efc_pharmacy_prod");
	    //test.getModel().setStartTime(htmlreport.getStartTime());
		String efcph = p.getProperty("efcpharmacy_url");
		String efc_userid = p.getProperty("efcPH_userid");
		String efc_pwd = p.getProperty("efcPH_password");
		test.log(Status.INFO, "Start Test !!");
		driver.get(efcph);
		String geturl = driver.getCurrentUrl();
		Assert.assertEquals(geturl, efcph);
		PageFactory.initElements(driver, TenxPageObjects.class);
		type(driver, TenxPageObjects.usernamefield, efc_userid);
		type(driver, TenxPageObjects.passwordfield, efc_pwd);
		test.log(Status.INFO, "Test In Progress!!");
		click(driver, TenxPageObjects.login);
		String loginurl = driver.getCurrentUrl();
		Boolean success = loginurl.contains("Dashboard");
		Assert.assertTrue(success);
		Thread.sleep(1000);
		click(driver, TenxPageObjects.logout);
		test.log(Status.INFO, "Test Completed!!");
		//test.getModel().setEndTime(htmlreport.getEndTime());
	}
	@Test(priority = 1, enabled = true)
	public void efc_admin_prod() throws InterruptedException
	{
		test = extent.createTest("efc_admin_prod");
		String efcadmin = p.getProperty("efcadminurl");
		String efc_ad_uid = p.getProperty("efcAD_userid");
		String efc_ad_pwd = p.getProperty("efcAD_password");
		driver.get(efcadmin);
		String geturl = driver.getCurrentUrl();
		Assert.assertEquals(geturl, efcadmin);
		PageFactory.initElements(driver, TenxPageObjects.class);
		type(driver, TenxPageObjects.usernamefield, efc_ad_uid);
		type(driver, TenxPageObjects.passwordfield, efc_ad_pwd);
		click(driver, TenxPageObjects.login);
		String loginurl = driver.getCurrentUrl();
		Boolean success = loginurl.contains("MyProfile");
		Assert.assertTrue(success);
		Thread.sleep(1000);
		click(driver, TenxPageObjects.logout);
	}
	@Test(priority = 2, enabled = true) 
	public void gt_pharmacy_prod() throws InterruptedException 
	  {
		    test = extent.createTest("gt_pharmacy_prod");
		    String gtpharm = p.getProperty("gtpharmacy_url");
			String gt_pharm_uid = p.getProperty("gtPH_userid");
			String gt_pharm_pwd = p.getProperty("gtPH_password");
			driver.get(gtpharm);
			String geturl = driver.getCurrentUrl();
			Assert.assertEquals(geturl, gtpharm);
			PageFactory.initElements(driver, TenxPageObjects.class);
			type(driver, TenxPageObjects.usernamefield, gt_pharm_uid);
			type(driver, TenxPageObjects.passwordfield, gt_pharm_pwd);
			click(driver, TenxPageObjects.login);
			String loginurl = driver.getCurrentUrl();
			Boolean success = loginurl.contains("Dashboard");
			Assert.assertTrue(success);
			Thread.sleep(1000);
			click(driver, TenxPageObjects.logout);
	  }
	  
	  @Test(priority = 3, enabled = true) 
	  public void gt_admin_prod() throws InterruptedException 
	  {
		    test = extent.createTest("gt_admin_prod");
		    String gtadmin = p.getProperty("gtadmin_url");
			String gt_admin_uid = p.getProperty("gtAD_userid");
			String gt_admin_pwd = p.getProperty("gtAD_password");
			driver.get(gtadmin);
			String geturl = driver.getCurrentUrl();
			Assert.assertEquals(geturl, gtadmin);
			PageFactory.initElements(driver, TenxPageObjects.class);
			type(driver, TenxPageObjects.usernamefield, gt_admin_uid);
			type(driver, TenxPageObjects.passwordfield, gt_admin_pwd);
			click(driver, TenxPageObjects.login);
			String loginurl = driver.getCurrentUrl();
			Boolean success = loginurl.contains("MyProfile");
			Assert.assertTrue(success);
			Thread.sleep(1000);
			click(driver, TenxPageObjects.logout);
	  }
	  
	  @Test(priority = 4, enabled = true) 
	  public void hn_pharmacy_prod() throws InterruptedException 
	  {
		    test = extent.createTest("hn_pharmacy_prod");
		    String hnpharm = p.getProperty("hnpharmacy_url");
			String hn_pharm_uid = p.getProperty("hnPH_userid");
			String hn_pharm_pwd = p.getProperty("hnPH_password");
			driver.get(hnpharm);
			String geturl = driver.getCurrentUrl();
			Assert.assertEquals(geturl, hnpharm);
			PageFactory.initElements(driver, TenxPageObjects.class);
			type(driver, TenxPageObjects.usernamefield, hn_pharm_uid);
			type(driver, TenxPageObjects.passwordfield, hn_pharm_pwd);
			click(driver, TenxPageObjects.login);
			String loginurl = driver.getCurrentUrl();
			Boolean success = loginurl.contains("Dashboard");
			Assert.assertTrue(success);
			Thread.sleep(1000);
			click(driver, TenxPageObjects.logout);
	  }
	  
	  @Test(priority = 5, enabled = true) 
	  public void hn_admin_prod() throws InterruptedException 
	  {
		    test = extent.createTest("hn_admin_prod");
		    String hnadmin = p.getProperty("hnadmin_url");
			String hn_admin_uid = p.getProperty("hnAD_userid");
			String hn_admin_pwd = p.getProperty("hnAD_password");
			driver.get(hnadmin);
			String geturl = driver.getCurrentUrl();
			Assert.assertEquals(geturl, hnadmin);
			PageFactory.initElements(driver, TenxPageObjects.class);
			type(driver, TenxPageObjects.usernamefield, hn_admin_uid);
			type(driver, TenxPageObjects.passwordfield, hn_admin_pwd);
			click(driver, TenxPageObjects.login);
			String loginurl = driver.getCurrentUrl();
			Boolean success = loginurl.contains("MyProfile");
			Assert.assertTrue(success);
			Thread.sleep(1000);
			click(driver, TenxPageObjects.logout);
	  }
	  @AfterMethod
	  public void tearDown (ITestResult result) throws IOException
	  {
		  if (result.getStatus()==ITestResult.FAILURE)
		  {
			  test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
			  test.log(Status.FAIL, "Test Case Failed is: "+result.getThrowable());
			  String screenshotpath = TenxProdTNG.getScreenshot(driver, result.getName());
			  test.addScreenCaptureFromPath(screenshotpath);
		   }
		  else if(result.getStatus()==ITestResult.SKIP)
		  {
			  test.log(Status.SKIP, "Test Case Skipped is: "+result.getName());
		  }
		  else if(result.getStatus()==ITestResult.SUCCESS)
		  {
			  test.log(Status.PASS, "Test Case Passed is: "+result.getName());
		  }
		  test.getModel().getEndTime();
		  driver.quit();
	  }
	  
    
	@AfterSuite
	  public void endReport()
	  {
		  extent.flush();
	  }
}
