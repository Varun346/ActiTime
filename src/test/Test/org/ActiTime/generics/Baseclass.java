package org.ActiTime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class Baseclass extends Exceloperation
{
	public static WebDriver driver;
	@BeforeTest
	public void OpenBrowser() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String brow=Exceloperation.Readdata("Sheet3", 1, 0);
		String url=Exceloperation.Readdata("Sheet3", 1, 1);
		if(brow.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(brow.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void Login() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String un=Exceloperation.Readdata("Sheet3", 1, 2);
		String psd=Exceloperation.Readdata("Sheet3", 1, 3);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(psd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	@AfterClass
	public void LogOut()
	{
		driver.findElement(By.className("logoutImg")).click();
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}

}
