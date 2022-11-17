package com.crm.Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.FileUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.Vtiger.objectRepository.DocumentInfoPage;
import com.crm.Vtiger.objectRepository.DocumentsTestcasePage;
import com.crm.Vtiger.objectRepository.HomePage;
import com.crm.Vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class DocumentsTestcaseTest {

	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		//To read the data into properties files
		String url = fLib.fetchTheDataFrompropertyFile("URL");
		String username = fLib.fetchTheDataFrompropertyFile("UserName");
		String password = fLib.fetchTheDataFrompropertyFile("password");
		String browser = fLib.fetchTheDataFrompropertyFile("Browser");
		WebDriver driver=null;

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		//to get randomnumber
		int randnum = jLib.getRandomNumber();
		//To fetch data in excel 
		String documentName = eLib.getExceldata("vtiger", 3, 6)+randnum;
		String contactName = eLib.getExceldata("vtiger", 3, 3)+randnum;

		wLib.maximizeTheBrowser(driver);

		wLib.implicitwait(driver);

		driver.get(url);
		//vtiger login
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		login.getSubmitBtn();
		
		//click on documents
		HomePage homepage = new HomePage(driver);
		homepage.getDocumentsLink().click();
		
		//create documents
		DocumentsTestcasePage documentTestcase = new DocumentsTestcasePage(driver);
		documentTestcase.getCreatedocument().click();
	
		//Title name
		documentTestcase.titleName(documentName);
		
		wLib.switchToFrame(driver, 0);
		//driver.switchTo().frame(0);
		documentTestcase.contactName(contactName);
		
		wLib.switchTomainFrame(driver);
		//driver.switchTo().parentFrame();
		
		documentTestcase.fileName("C:\\Users\\santu\\Downloads\\Rahul.docx");
		
		documentTestcase.getDocumentBtn().click();
		
		DocumentInfoPage documentInfo = new DocumentInfoPage(driver);
		String titledocument =documentInfo.getVerifyDocumentElement().getText();
		if (titledocument.contains(documentName)) {
			System.out.println("====The Document Is created=====");
		}
		else
		{
			System.out.println("The document is not created");
		}
		
		driver.quit();
	}

}
