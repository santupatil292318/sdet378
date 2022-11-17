package com.crm.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.ExcelUtility;

public class CreatedataproviderFetchdataInexcelSheetTest   {

	@Test(dataProvider="bookTicketDataProvider")
	 
	public void bookTicketTest(String src,String dest,String tickets )
	{
		
		System.out.println("execute source =>"+src+"destination =>"+dest+"Tickets =>"+tickets);
		
	}
	@DataProvider
	public Object[][] bookTicketDataProvider() throws Throwable
	
	{
		ExcelUtility eLib=new ExcelUtility();
		Object[][] objArr= new Object[3][3];
		objArr[0][0] =eLib.getExceldata("bookTicketTest", 0, 0);
		objArr[0][1] =eLib.getExceldata("bookTicketTest", 0, 1);
		objArr[0][2] =eLib.getExceldata("bookTicketTest", 0, 2);
		objArr[1][0] =eLib.getExceldata("bookTicketTest", 1, 0);
		objArr[1][1] =eLib.getExceldata("bookTicketTest", 1, 1);
		objArr[1][2] =eLib.getExceldata("bookTicketTest", 1, 2);
		objArr[2][0] =eLib.getExceldata("bookTicketTest", 2, 0);
		objArr[2][1] =eLib.getExceldata("bookTicketTest", 2, 1);
		objArr[2][2] =eLib.getExceldata("bookTicketTest", 2, 2);
		
		return objArr;
		
		
	}
	
}
