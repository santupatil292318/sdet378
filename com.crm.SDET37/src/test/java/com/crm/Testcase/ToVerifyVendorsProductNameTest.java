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

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class ToVerifyVendorsProductNameTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		FileInputStream fileinput=new FileInputStream("./src/test/resources/commondata.properties");
		Properties properties = new Properties();
		properties.load(fileinput);
		String url = properties.getProperty("URL");
		String username = properties.getProperty("UserName");
		String password = properties.getProperty("password");
		String browser = properties.getProperty("Browser");
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
		//click on vendors
		driver.findElement(By.linkText("Vendors")).click();
		//create vendor
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		//To pass vendor Name
		driver.findElement(By.name("vendorname")).sendKeys("Rmg");
		//To save the vendor
		driver.findElement(By.name("button")).click();

		//To click on Products
		driver.findElement(By.linkText("Products")).click();
		//To create product
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//To Pass Product Name
		driver.findElement(By.name("productname")).sendKeys(productName);
		//select Vendor name
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		//switch to select vendor window
		Set<String> windowids = driver.getWindowHandles();
		for (String windowid : windowids) {
			driver.switchTo().window(windowid);
			String title = driver.getTitle();
			if (title.contains("Vendors&action")) {
				break;	
			}
		}
		//passing values to search field
		driver.findElement(By.id("search_txt")).sendKeys("Rmg");
		//search vendors
		driver.findElement(By.name("search")).click();
		//select The vendor
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		//switch back to Product window
		Set<String> windowids1 = driver.getWindowHandles();
		for (String windowid1 : windowids1) {
			driver.switchTo().window(windowid1);
		}
		//click on save
		driver.findElement(By.name("button")).click();
		//verify the product is created
		String productName1 = driver.findElement(By.id("dtlview_Product Name")).getText();
		if (productName1.contains(productName)) {
			System.out.println("====product is created=====");
		}
		else
		{
			System.out.println("product is not created");
		}
		driver.quit();
	}

}
