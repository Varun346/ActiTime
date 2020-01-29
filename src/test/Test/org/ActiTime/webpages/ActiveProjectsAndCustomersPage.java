package org.ActiTime.webpages;

import org.ActiTime.generics.Baseclass;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class ActiveProjectsAndCustomersPage 
{
	@FindBy(xpath="//input[@value='Add New Customer']")
	private WebElement AddNewCustomerButton;
	
	
	@FindBy(xpath="//input[@value='Add New Project']")
	private WebElement AddNewProjectButton;
	
	
	@FindBy(className="successmsg")
	private WebElement RetrieveSuccessMsg;
	public static Logger log;
	public ActiveProjectsAndCustomersPage()
	{
		PageFactory.initElements(Baseclass.driver, this);
		log=Logger.getLogger(ActiveProjectsAndCustomersPage.class);
		log.info("......activeprojects and customers.......");
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	public void AddnewcustomerButton()
	{
		AddNewCustomerButton.click();
		log.info("......clickedonAddNewcustomer...");
	}
	public void AddnewProjectButton()
	{
		AddNewProjectButton.click();
		log.info(".......clicked on Add new project button.....");
	}
	public String retrieveSuccessmsg()
	{
		String s=RetrieveSuccessMsg.getText();
		log.info("......retrievesuccessmsg.....");
		return s;
	}
}
