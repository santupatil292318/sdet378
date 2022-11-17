package com.crm.Propertiesfile;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.BaseClass;
/**
 * 
 * @author santu
 *
 */
@Listeners(com.crm.GenericUtilities.ListnerImplTn.class)
public class CreateOrganisationTest extends BaseClass {

	@Test(retryAnalyzer = com.crm.GenericUtilities.ListnerImplTn.class)
	
	public  void  createOrganisationTest() throws Throwable {
//		WebDriver driver=null;
//		FileInputStream fileinputstream = new FileInputStream("./src/test/resources/commondata.Properties");
//		Properties properties = new Properties();
//		properties.load(fileinputstream);
//		String url=properties.getProperty("URL");
//		String username = properties.getProperty("UserName");
//		String  password=properties.getProperty("password");
//		String browser =properties.getProperty("Browser");
//		//set of Driver Executable 
//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver= new ChromeDriver();
//		}
//		else if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver =new FirefoxDriver();
//		}
//		else
//		{
//			driver = new ChromeDriver();
//		}
		//WebDriverManager.chromedriver().setup();
		Random random = new Random();
		int randomvalue = random.nextInt(1000);

		//maximize the window
//		driver.manage().window().maximize();
//		//Giving implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		//goto vtiger application
//		driver.get(url);
		//vtiger username
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		//vtiger password
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		//click on login
//		driver.findElement(By.id("submitButton")).click();

		//To fetch The data in Excel
		 FileInputStream excel = new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook workbook=WorkbookFactory.create(excel);
		Sheet sheet = workbook.getSheet("Organisation");
		String data = sheet.getRow(4).getCell(2).getStringCellValue();
		//click on organization 
		driver.findElement(By.linkText("Organizations")).click();
		//create organization click plus symbol
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//pass Organization Name
		driver.findElement(By.name("accountname")).sendKeys(data+randomvalue);

		//click on save
		driver.findElement(By.name("button")).click();

		//To verify 
		String organisationName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (organisationName.contains(data)) {
			System.out.println("===The organisation is created====");
		}
		else
		{
			System.out.println("===The organisation is not created====");
		}
		//logout
//		WebElement adminstration = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Actions action =new Actions(driver);
//		action.moveToElement(adminstration).perform();
//		//logout the application
//		driver.findElement(By.linkText("Sign Out")).click();
	}

}
