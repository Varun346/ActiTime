package org.ActiTime.webpages;

import org.ActiTime.generics.Baseclass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenTaskPage 
{
	@FindBy(linkText="Projects & Customers")
	private WebElement ProjectsandCustomerslink;
	public static Logger log;
	public OpenTaskPage()
	{
		PageFactory.initElements(Baseclass.driver,this);
		log=Logger.getLogger(OpenTaskPage.class);
		PropertyConfigurator.configure("Log4j.properties");
	}
	public void projectsandcustomerslink()
	{
		ProjectsandCustomerslink.click();
		log.info("......clicked on projects and customer link");
	}
}
