package com.crm.Datadriven;

import java.io.FileInputStream;

import org.apache.poi.EncryptedDocumentException;
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
public class Fetchonly1stand2ndcoumndataTest {

	public static void main(String[] args) throws EncryptedDocumentException, Throwable {
		FileInputStream fileinput= new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fileinput);
		Sheet sheet = workbook.getSheet("Sheet1");
		for (int i = 0; i < 6; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < 3; j++) {
				Cell cell = row.getCell(j);
				DataFormatter dataformatter = new DataFormatter();
				String data = dataformatter.formatCellValue(cell);
				System.out.print(data+"  ");
			}
		System.out.println();
		}
		

	}

}
