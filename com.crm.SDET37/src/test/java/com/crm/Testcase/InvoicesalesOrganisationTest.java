package com.crm.Testcase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.FileUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.Vtiger.objectRepository.CreateInvoicePage;
import com.crm.Vtiger.objectRepository.HomePage;
import com.crm.Vtiger.objectRepository.LoginPage;
import com.crm.Vtiger.objectRepository.VerifyInvoiceInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class InvoicesalesOrganisationTest {

	public static void main(String[] args) throws Throwable  {
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
		//To set up driver executables
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
		
		//Random Number
		Random randumnumber = new Random();
		//to read the data into excel sheet
		String invoicesubject = eLib.getExceldata("vtiger", 2, 9)+randumnumber;
		String contactLastName = eLib.getExceldata("vtiger", 4, 3)+randumnumber;
		String oganisationName = eLib.getExceldata("vtiger", 3, 2)+randumnumber;
		String billingaddress = eLib.getExceldata("vtiger", 5, 9)+randumnumber;
		String salesSubject = eLib.getExceldata("vtiger", 6, 10);
		String shippingaddress = eLib.getExceldata("vtiger", 8, 9)+randumnumber;
		

		//maximize the window
		wLib.maximizeTheBrowser(driver);
		
		//Giving implicit wait
		wLib.implicitwait(driver);
	
		driver.get(url);
		//vtiger login
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		login.getSubmitBtn();
		
		//click on more navigation
		HomePage homepage = new HomePage(driver);
		homepage.More(driver);
		
		//click on invoice
		homepage.getInvoice().click();
		
		//create invoice
		CreateInvoicePage invoice = new CreateInvoicePage(driver);
		invoice.getCreateInvoice().click();
		
		//To add subject
		invoice.subject(invoicesubject);
		
		//To select contact
		invoice.selectcontact(driver, "Contacts&action", contactLastName);
		
		driver.switchTo().alert().accept();
		//switch back to invoice window
		wLib.switchTowindow("Invoice&action", driver);

		//To select Organisation Name
		invoice.Selectoragnization(driver, "Accounts&action", oganisationName);
		
		driver.switchTo().alert().accept();
		//switch back to invoice window
		wLib.switchTowindow("Invoice&action", driver);
		//To check user radio button is selected or not
		
		WebElement userradio = invoice.getUserRadio();
		if (userradio.isSelected()) {
			System.out.println("User radio Button is selected");
		}



		//To search sales order
		invoice.getSearchSalesOrder().click();

		wLib.switchTowindow("SalesOrder&action", driver);
		//sales order select in dropdown
		invoice.salesdropdown("subject");
		
		//give input to sales order
		invoice.inputsalesOrder(salesSubject);
		
		//To search The sales order
		invoice.getSearchOrder().click();
		
		//To select sales order
		invoice.getSelectSales().click();
		
		//switch back to invoice window
		wLib.switchTowindow("Invoice&action", driver);
		//billing address
		invoice.BillingAddress(billingaddress);
		
		//shipping street
		invoice.ShipStreet(shippingaddress);

		//item name
		//driver.findElement(By.id("productName1")).click();
		invoice.searchiconitem(driver, "Products&action");
		
		//to search field search line item
		invoice.searchfieldLineitem(salesSubject);
		
		//To search line item
		invoice.getSearchItem().click();
		
		//To select line item
		invoice.getSelectLineitem().click();
		//driver.switchTo().alert().accept();
		//switch back to parent window
		wLib.switchTowindow("Invoice&action", driver);
		//quantity
		invoice.Quantity("3");
		
		//list Price
		invoice.listPrice1("30000");
		
		//To save
		invoice.getSaveinvoiceBtn().click();
	
		//To verify invoice with sales order created or not
		VerifyInvoiceInfoPage verifyInvoice = new VerifyInvoiceInfoPage(driver);
		String verify =verifyInvoice.getVerifyInvoice().getText();
		if (verify.contains(invoicesubject)) {
			System.out.println("Pass:Invoice with Sales order is created");
		}
		else {
			System.out.println("Fail:Invoice with Sales order is not created===");

		}
		//Yo switch back to parent window
		wLib.switchTowindow("Invoice&action", driver);
		//logout
		homepage.Logout(driver);

	}

}
