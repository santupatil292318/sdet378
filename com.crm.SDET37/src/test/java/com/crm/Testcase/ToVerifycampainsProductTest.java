package com.crm.Testcase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.FileUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class ToVerifycampainsProductTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		//To call all the utility
		JavaUtility jLib=new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		String url = fLib.fetchTheDataFrompropertyFile("URL");
		String username = fLib.fetchTheDataFrompropertyFile("UserName");
		String password = fLib.fetchTheDataFrompropertyFile("password");
		String browser = fLib.fetchTheDataFrompropertyFile("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else {

			driver= new ChromeDriver();
		}

		//To read into excel sheet
		FileInputStream fileinput1 = new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fileinput1);
		String productName = workbook.getSheet("vtiger").getRow(3).getCell(5).getStringCellValue();
		String campaignName = workbook.getSheet("vtiger").getRow(3).getCell(11).getStringCellValue();
		//maximise window screen
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		//vtiger username
		driver.findElement(By.name("user_name")).sendKeys(username);
		//vtiger password
		driver.findElement(By.name("user_password")).sendKeys(password);
		//click on login
		driver.findElement(By.id("submitButton")).click();
		//click on more navigation
		WebElement element = driver.findElement(By.linkText("More"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		//click on Campaigns
		driver.findElement(By.name("Campaigns")).click();
		//create campaigns
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		//To Pass value camaigns Name
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);


		//To select product
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		//switch to select product window
		Set<String> windowids = driver.getWindowHandles();
		for (String windowid : windowids) {
			driver.switchTo().window(windowid);
			String title = driver.getTitle();
			if (title.contains("Products&action")) {
				break;	
			}
		}
		//To search product
		driver.findElement(By.name("search_text")).sendKeys(productName);
		//To search the Product
		driver.findElement(By.name("search")).click();
		//select The product
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		//switch back to Product window
		Set<String> windowids1 = driver.getWindowHandles();
		for (String windowid1 : windowids1) {
			driver.switchTo().window(windowid1);
		}
		//click on save
		driver.findElement(By.name("button")).click();
		//verify the campign is created
		String campign = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		if (campign.contains(campaignName)) {
			System.out.println("====campign is created=====");
		}
		else
		{
			System.out.println("campaign is not created");
		}
		driver.quit();

	}

}
