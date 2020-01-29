package org.ActiTime.webpages;

import org.ActiTime.generics.Baseclass;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class AddNewCustomerPage 
{
	@FindBy(name="name")
	private WebElement CustomerNameTextField;
	
	@FindBy(xpath="//input[@value='Create Customer']")
	private WebElement CreateCustomerButton;
	public static Logger log;
	public AddNewCustomerPage()
	{
		PageFactory.initElements(Baseclass.driver,this);
		log=Logger.getLogger(AddNewCustomerPage.class);
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	public void customerNameTextfield(String customername)
	{
		CustomerNameTextField.sendKeys(customername);
		log.info("......entercustomername....");
	}
	
	public void createCustomerButton()
	{
		CreateCustomerButton.click();
		log.info("......click create customer.....");
	}
}
