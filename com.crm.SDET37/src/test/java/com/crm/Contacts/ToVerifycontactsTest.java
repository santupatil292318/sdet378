package com.crm.Contacts;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericUtilities.BaseClass;
import com.crm.Vtiger.objectRepository.ContactInfoPage;
import com.crm.Vtiger.objectRepository.CreateContactPage;
import com.crm.Vtiger.objectRepository.HomePage;
/**
 * 
 * @author santu
 *
 */
@Listeners(com.crm.GenericUtilities.ListnerImplTn.class)
public class ToVerifycontactsTest extends BaseClass {
@Test(groups = "RegressionTest",retryAnalyzer = com.crm.GenericUtilities.ListnerImplTn.class)
	public  void  toVerifycontactsTest() throws Throwable {
//		JavaUtility jLib=new JavaUtility();
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		WebdriverUtility wLib = new WebdriverUtility();
//		WebDriver driver=null;
		SoftAssert softassert = new SoftAssert();
//		//To Read the data in Properties file
//		String url = fLib.fetchTheDataFrompropertyFile("URL");
//		String username = fLib.fetchTheDataFrompropertyFile("UserName");
//		String password = fLib.fetchTheDataFrompropertyFile("password");
//		String browser = fLib.fetchTheDataFrompropertyFile("Browser");
//
//		//set of Driver Executable 
//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else {
//			driver = new ChromeDriver();
//		}
		
		int randnum = jLib.getRandomNumber();
		String firstName = eLib.getExceldata("vtiger", 3, 3)+randnum;
		String lastName = eLib.getExceldata("vtiger", 4, 3)+randnum;
		//maximize the window
		//wLib.maximizeTheBrowser(driver);
		//Giving implicit wait
		//wLib.implicitwait(driver);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//goto vtiger application
		//driver.get(url);
		//vtiger username
//		LoginPage login = new LoginPage(driver);
//		login.loginToApp(username, password);
//		login.getSubmitBtn();

		//click on contacts
		HomePage homepage = new HomePage(driver);
		homepage.getContactsLink().click();

		//click on + symbol
		CreateContactPage createcontact = new CreateContactPage(driver);
		createcontact.getCreatContactLink().click();

		//firstName select mr
		createcontact.firstName("Mr.");
		//To pass name in firstName
		
		createcontact.createcontact(firstName, lastName);

		//To save contact
		createcontact.saveBtn();

		//To verify The contacts
		ContactInfoPage contactinfo = new ContactInfoPage(driver);
		String contact = contactinfo.getVerifycontact().getText();
		softassert.assertTrue(true, contact);
		Reporter.log(contact, true);
//		if (contact.contains(firstName)) {
//			System.out.println("===The Contact is created====");
//		}
//		else
//		{
//			System.out.println("===The contact is not created");
//		}
		//logout
//		homepage.Logout(driver);
//		driver.quit();
		
	}

}
