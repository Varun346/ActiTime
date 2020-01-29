package org.ActiTime.testscripts;

import java.io.IOException;

import org.ActiTime.generics.Baseclass;
import org.ActiTime.generics.Exceloperation;
import org.ActiTime.webpages.ActiveProjectsAndCustomersPage;
import org.ActiTime.webpages.AddNewCustomerPage;
import org.ActiTime.webpages.OpenTaskPage;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class CreateCustomer extends Baseclass
{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		OpenTaskPage otp=new OpenTaskPage();
		otp.projectsandcustomerslink();
		ActiveProjectsAndCustomersPage apcp=new ActiveProjectsAndCustomersPage();
		apcp.AddnewcustomerButton();
		AddNewCustomerPage ancp=new AddNewCustomerPage();
		String cn=Exceloperation.Readdata("Sheet3", 1, 4);
		ancp.customerNameTextfield(cn);
		ancp.createCustomerButton();
		String s=apcp.retrieveSuccessmsg();
		System.out.println(s);
		
}
}