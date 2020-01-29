package org.ActiTime.testscripts;

import java.io.IOException;

import org.ActiTime.generics.Baseclass;
import org.ActiTime.generics.Exceloperation;
import org.ActiTime.webpages.ActiveProjectsAndCustomersPage;
import org.ActiTime.webpages.AddNewProjectPage;
import org.ActiTime.webpages.OpenTaskPage;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

public class CreateProject extends Baseclass
{
	@Test
	public void testCreateProject() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		OpenTaskPage otp=new OpenTaskPage();
		otp.projectsandcustomerslink();
		ActiveProjectsAndCustomersPage apcp=new ActiveProjectsAndCustomersPage();
		apcp.AddnewProjectButton();
		AddNewProjectPage anpp=new AddNewProjectPage();
		String cn=Exceloperation.Readdata("Sheet3",1,4);
		String prj=Exceloperation.Readdata("Sheet3",1,5);
		anpp.selectCustomerfromDropdown(cn);
		anpp.projectNameTextfield(prj);
		anpp.addNewprojectButton();
		apcp.retrieveSuccessmsg();
		
	}
}
