package com.crm.Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.BaseClass;
import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.FileUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.Vtiger.objectRepository.CreateContactPage;
import com.crm.Vtiger.objectRepository.CreateOrganizationPage;
import com.crm.Vtiger.objectRepository.HomePage;
import com.crm.Vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
@Listeners(com.crm.GenericUtilities.ListnerImplTn.class)
public class AutomateVtigerTest extends BaseClass {

	@Test(retryAnalyzer = com.crm.GenericUtilities.ListnerImplTn.class)
	
	public  void automateVtigerTest() throws Throwable {
//		WebDriver driver=null;
//		//To call all the utility
//		JavaUtility jLib=new JavaUtility();
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		WebdriverUtility wLib = new WebdriverUtility();
//		//To fetch the fileutility
//		String url = fLib.fetchTheDataFrompropertyFile("URL");
//		String username = fLib.fetchTheDataFrompropertyFile("UserName");
//		String password = fLib.fetchTheDataFrompropertyFile("password");
//		String browser = fLib.fetchTheDataFrompropertyFile("Browser");
//
//
//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else {
//			driver = new ChromeDriver();
//		}
		int randomnum = jLib.getRandomNumber();
		//to fetch data from excelutility
		String orgName = eLib.getExceldata("vtiger", 3, 2)+randomnum;
		String contactFirstName = eLib.getExceldata("vtiger", 3, 3)+randomnum;
		String contactLastName = eLib.getExceldata("vtiger", 4, 3)+randomnum;
		String email = eLib.getExceldata("vtiger", 3, 7)+randomnum;
		String website = eLib.getExceldata("vtiger",10, 1)+randomnum;
		//maximize the window
		//wLib.maximizeTheBrowser(driver);
		//Giving implicit wait
		//wLib.implicitwait(driver);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//goto vtiger application
		//driver.get(url);
//		//vtiger username
//		LoginPage login = new LoginPage(driver);
//		login.loginToApp(username, password);
//		login.getSubmitBtn();
		//click on organization 
		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationsLink().click();

		//create organization click plus symbol
		CreateOrganizationPage createorganization = new CreateOrganizationPage(driver);
		createorganization.getCreatOrganizationLink().click();

		//pass Organization Name
		createorganization.createOrganization(orgName);
		
		//pass the website name in website field
		createorganization.websiteName(website);
		
		//click and select industry dropdown
		createorganization.industryDropDown("Apparel");
		
		//select on type dropdown
		createorganization.typeDropDown("Analyst");
		
		//click on save
		createorganization.getSaveBtn().click();

		//click on contacts
		Thread.sleep(3000);
		homepage.getContacts();
		

		//click on + symbol
		CreateContactPage createcontact = new CreateContactPage(driver);
		createcontact.getCreatContactLink().click();

		//firstName select mr
		createcontact.firstName("Mr.");
		
		//To pass name in firstName
		createcontact.createcontact(contactFirstName, contactLastName);

		//To select The organization
		
		driver.findElement(By.xpath("//img[contains(@onclick,'return window.open')]")).click();
		//Thread.sleep(5000);
		//To find the Organization and select
		createcontact.selectOrganization(driver, orgName);
		
		wLib.switchTowindow("Contacts&action", driver);
		createcontact.leadsource("Employee");
		
		//To send Value To email
		createcontact.email(email);
		
		//save the contact
		createcontact.saveBtn();
		
		
		System.out.println("The contact is created");
		


	}

}
