package com.crm.Datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author santu
 *
 */
public class FetchThedataFromExcelTest {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fileinput = new FileInputStream("./src/test/resources/Testdata.xlsx");
		 Workbook workbook = WorkbookFactory.create(fileinput);
		String exceldata = workbook.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(exceldata);
		
		
	}

}
