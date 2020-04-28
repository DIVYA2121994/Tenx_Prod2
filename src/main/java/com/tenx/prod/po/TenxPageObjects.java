package com.tenx.prod.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TenxPageObjects 
{
	public TenxPageObjects()
	{
		
	}
	
    @FindBy(how=How.XPATH, using = "//input[@id='login_userId']")
    public static WebElement usernamefield;
    
    @FindBy(how=How.XPATH, using = "//input[@id='login_password']")
    public static WebElement passwordfield;
    
    @FindBy(how=How.XPATH, using = "//button[@id='login_submitButton']")
    public static WebElement login;
    
    @FindBy(how=How.XPATH, using = "//a[@id='green']")
    public static WebElement logout;
    
    @FindBy(how=How.XPATH, using = "//button[contains(text(),'OK')]")
    public static WebElement ok;
}
