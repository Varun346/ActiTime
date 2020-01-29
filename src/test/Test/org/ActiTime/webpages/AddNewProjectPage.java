package org.ActiTime.webpages;

import org.ActiTime.generics.Baseclass;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

public class AddNewProjectPage 
{
	@FindBy(name="customerId")
	private WebElement SelectCustomerFromDropdown;
	
	@FindBy(name="name")
	private WebElement ProjectNameTextField;
	
	@FindBy(name="createProjectSubmit")
	private WebElement AddNewProjectButton;
	public static Logger log;
	public AddNewProjectPage()
	{
		PageFactory.initElements(Baseclass.driver,this);
		log=Logger.getLogger(AddNewProjectPage.class);
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	public void selectCustomerfromDropdown(String customername)
	{
		Select s1=new Select(SelectCustomerFromDropdown);
		s1.selectByVisibleText(customername);
		log.info(".......select customer from dropdown....");
	}
	
	public void projectNameTextfield(String prjname)
	{
		ProjectNameTextField.sendKeys(prjname);
		log.info(".........enter project name.........");
	}
	
	public void addNewprojectButton()
	{
		AddNewProjectButton.click();
		log.info("......click on add new project....");
	}
	
}
