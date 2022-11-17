package com.crm.Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.FileUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.Vtiger.objectRepository.CreateAssetInfoPage;
import com.crm.Vtiger.objectRepository.CreateAssetsPage;
import com.crm.Vtiger.objectRepository.HomePage;
import com.crm.Vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAssetswithInvoice {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		//To read the data into properties files
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
		//random
		int randnum = jLib.getRandomNumber();
		//to read the data into excel sheet
		//String assetNumber = eLib.getExceldata("vtiger", 9, 8);
		
		String serialnumberNumber = eLib.getExceldata("vtiger", 10, 8)+randnum;
		
		String invoiceSubject = eLib.getExceldata("vtiger", 2, 9)+randnum;
		
		String customerName = eLib.getExceldata("vtiger", 3, 2)+randnum;
		
		String assetName = eLib.getExceldata("vtiger", 3, 8)+randnum;
		
		//maximize the window
		wLib.maximizeTheBrowser(driver);
		//Giving implicit wait
		wLib.implicitwait(driver);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//goto vtiger application
		driver.get(url);
		//vtiger username
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		login.getSubmitBtn();
		
		//click on more navigation
		HomePage homepage = new HomePage(driver);
		homepage.More(driver);
		
		//click on assets
		homepage.Assets(driver);
		
		//To create assets
		CreateAssetsPage createassets = new CreateAssetsPage(driver);
		createassets.getCreateasset().click();
		
		//to add asset number
		//createassets.assetnumber(assetNumber+randnum);
		
		//serial number
		createassets.serialnumber(serialnumberNumber+randnum);
		
		//data sold
		createassets.getDateSold().click();
		
		//to click on date
		createassets.getDatetext().click();
		
		
		//status dropdown
		createassets.statusDropdown("In Service");

		//To select invoice
		
		createassets.selectInvoice(driver, "Invoice&action");
		
		//sales order select in dropdown
		
		createassets.salesorderDropdown("subject");
		
		//give input to sales order
		createassets.invoiceSubjectEdt(invoiceSubject);
		
		//To search The sales order
		createassets.getSearchsalesOrder().click();
		
		//To select sales order
		createassets.getSelectSalesoder().click();
		


		//switch back to asset window
		wLib.switchTowindow("Assets&action", driver);
		//To click lookup on customer Name
		createassets.getcustomerlookUp().click();
		
		wLib.switchTowindow("Accounts&action", driver);
		//give input to customer name
		createassets.customername(customerName);
	
		//To search The customer Name
		createassets.getSearchCustomername().click();

		//To select customer name
		createassets.getSelectCustomername().click();
		
		//switch back to asset window
		wLib.switchTowindow("Assets&action", driver);
		//To select Product name
		createassets.getSelectProduct().click();
		
		wLib.switchTowindow("Products&action", driver);
		//give input to product name
		createassets.productname(customerName);
		

		//To search The product Name
		createassets.getSearchproductName().click();

		//To select product name
		createassets.getSelectproductName().click();

		//switch back to asset window
		wLib.switchTowindow("Assets&action", driver);

		//To check user radio button is assigned or not
		WebElement userradio = createassets.getUserradioBtn();
		if (userradio.isSelected()) {
			System.out.println("User radio Button is selected");
		}

		//To click on date in service
		createassets.getDateInService().click();
		
		//to click on date
		createassets.getClickOndate().click();
		
		//To Asset name
		createassets.assetName(assetName);
		

		//To save
		createassets.getSaveAssetBtn().click();

		//To verify invoice with assets order created or not
		CreateAssetInfoPage assetInfo = new CreateAssetInfoPage(driver);
		String verify =assetInfo.getVerifyAsset().getText();
		if (verify.contains(assetName)) {
			System.out.println("=====Invoice with assets order is created=====");
		}
		else {
			System.out.println("=====Invoice with assets order is not created===");

		}
		//To switch back to parent window
		wLib.switchTowindow("Assets&action", driver);
		//logout
		homepage.Logout(driver);

	}

}
