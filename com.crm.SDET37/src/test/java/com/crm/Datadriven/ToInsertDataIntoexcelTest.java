package com.crm.Datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author santu
 *
 */
public class ToInsertDataIntoexcelTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fileinput =new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fileinput);
		Cell insertdata = workbook.createSheet("Sheet2").createRow(0).createCell(0);
		insertdata.setCellValue("hi");
		
		FileOutputStream fileOutput= new FileOutputStream("./src/test/resources/Testdata.xlsx");
		workbook.write(fileOutput);
	}

}
