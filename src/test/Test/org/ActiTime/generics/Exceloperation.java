package org.ActiTime.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Exceloperation 
{
	public static int getRowCount(String sheetname) throws EncryptedDocumentException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException 
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/testdata/userdata.xlsx");
		Workbook w1 = WorkbookFactory.create(fis);
		return w1.getSheet(sheetname).getPhysicalNumberOfRows();
		
	}
	public static int getCellcount(String sheetname,int rownum) throws EncryptedDocumentException, IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException 
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/testdata/userdata.xlsx");
		Workbook w1=WorkbookFactory.create(fis);
		return w1.getSheet(sheetname).getRow(rownum).getPhysicalNumberOfCells();
		
	}
	public static String Readdata(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/testdata/userdata.xlsx");
		Workbook w1=WorkbookFactory.create(fis);
		Cell c1 = w1.getSheet(sheetname).getRow(rownum).getCell(cellnum);
		DataFormatter rv=new DataFormatter();
		String s=rv.formatCellValue(c1);
		System.out.print(s+" ");
		System.out.println();
		return s;
	}
	public static void Writedata(String sheetname,int rownum,int cellnum,String data) throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/testdata/userdata.xlsx");
		Workbook w1=WorkbookFactory.create(fis);
		w1.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"/testdata/userdata.xlsx");
		w1.write(fos);
	}

}
