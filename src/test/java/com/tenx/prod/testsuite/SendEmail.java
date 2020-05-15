package com.tenx.prod.testsuite;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


public class SendEmail 
{
	
	
	public static void emailconfig() throws MessagingException
	{
		try
		{
		 String path = System.getProperty("user.dir");
		 File file = new File (path+"\\test-output\\10X_ProdStatusReport.html");	
		  MultiPartEmail email = new MultiPartEmail(); 
		  email.attach(new FileDataSource(file), "10X_ProdStatusReport.html", "10X_ProdStatusReport.html");
		  email.setHostName("smtp.office365.com");
		  email.setSmtpPort(587);
	      email.setStartTLSRequired(true);
		  email.setAuthentication("gsdivya@ashvichinfotek.com", "Divu@2121994");
		  email.addTo("gsdivya@ashvichinfotek.com");
		  email.addTo("garvinth@ashvichinfotek.com");
		  email.setFrom("gsdivya@ashvichinfotek.com");
		  email.setSubject("TenX Production Automation report");
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		  LocalDateTime now = LocalDateTime.now();  
		  System.out.println(dtf.format(now));  
		  email.setMsg("Production Status Report::"+dtf.format(now));
		  email.send();
		}
	
	catch (EmailException e) 
	{
		e.printStackTrace();
	}
	
	}
}
