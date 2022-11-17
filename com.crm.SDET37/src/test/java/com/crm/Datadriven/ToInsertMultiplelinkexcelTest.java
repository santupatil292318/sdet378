package com.crm.Datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class ToInsertMultiplelinkexcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, Throwable {
		Workbook workbook = WorkbookFactory.create(new FileInputStream("./src/test/resources/Testdata.xlsx"));
		Sheet sheet2 = workbook.getSheet("Sheet2");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//goto vtiger application
		driver.get("http://localhost:8888/");
		//vtiger username
		driver.findElement(By.name("user_name")).sendKeys("admin");
		//vtiger password
		driver.findElement(By.name("user_password")).sendKeys("admin");
		//click on login
		driver.findElement(By.id("submitButton")).click();
		//To capture all links
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		int count=alllinks.size();
		for (int i=0; i<count; i++) {
			Cell cell = sheet2.createRow(i).createCell(0);
			cell.setCellValue(alllinks.get(i).getAttribute("href"));
			}
		FileOutputStream fileOutput = new FileOutputStream("./src/test/resources/Testdata.xlsx");
		workbook.write(fileOutput);

	}

}
