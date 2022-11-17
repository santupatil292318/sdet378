package com.crm.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author santu
 *
 */
public class ExcelUtility {
	/**
	 * used to get data in excelfile
	 * @param SheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */
	public String getExceldata(String SheetName,int rownum,int cellnum) throws Throwable, Throwable
	{
		FileInputStream fileinput=new FileInputStream(IConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileinput);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rownum);
		Cell data = row.getCell(cellnum);
		DataFormatter dataformatter = new DataFormatter();
		String  formateclell= dataformatter.formatCellValue(data);
		return formateclell;
	}
	/**
	 * to get lastrowNumber of excelsheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getrowCount(String sheetname) throws Throwable
	{
		FileInputStream fileinput = new FileInputStream(IConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileinput);
		Sheet sheet = workbook.getSheet(sheetname);
		int lastrownum = sheet.getLastRowNum();
		return lastrownum;
	}
	/**
	 * to store the data in excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws Throwable
	 */
	public void setDatafromExcel(String sheetname,int rownum,int cellnum,String data) throws Throwable
	{
		FileInputStream fileinput = new FileInputStream(IConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileinput);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileoutput = new FileOutputStream(IConstants.excelPath);
		workbook.write(fileoutput);
		workbook.close();

	}
}

