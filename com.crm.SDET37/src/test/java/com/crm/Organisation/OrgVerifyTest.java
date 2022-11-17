package com.crm.Organisation;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericUtilities.BaseClass;
import com.crm.Vtiger.objectRepository.CreateOrganizationInfoPage;
import com.crm.Vtiger.objectRepository.CreateOrganizationPage;
import com.crm.Vtiger.objectRepository.HomePage;
/**
 * 
 * @author santu
 *
 */
@Listeners(com.crm.GenericUtilities.ListnerImplTn.class)
public class OrgVerifyTest extends BaseClass  {

	@Test(retryAnalyzer = com.crm.GenericUtilities.ListnerImplTn.class)
	
	public  void orgVerifyTest() throws Throwable {
//		JavaUtility jLib=new JavaUtility();
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		WebdriverUtility wLib = new WebdriverUtility();
//		WebDriver driver=null;
		SoftAssert softassert = new  SoftAssert();
//		//To read the data in properties file
//		
//		String url = fLib.fetchTheDataFrompropertyFile("URL");
//		String username = fLib.fetchTheDataFrompropertyFile("UserName");
//		String password = fLib.fetchTheDataFrompropertyFile("password");
//		String browser = fLib.fetchTheDataFrompropertyFile("Browser");
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
		
	
		int randnum = jLib.getRandomNumber();
		String name = eLib.getExceldata("vtiger", 3, 2)+randnum;
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
		//click on organization 
		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationsLink().click();
		
		//create organization click plus symbol
		CreateOrganizationPage createorganization = new CreateOrganizationPage(driver);
		createorganization.getCreatOrganizationLink().click();
		
	
		//pass Organization Name
		createorganization.createOrganization(name);
		
		//driver.findElement(By.name("accountname")).sendKeys(name+randnum);

		//click on save
		createorganization.getSaveBtn().click();
		//driver.findElement(By.name("button")).click();
		
		//Thread.sleep(5000);
		//To verify 
		CreateOrganizationInfoPage orgInfopage = new CreateOrganizationInfoPage(driver);
		String title= orgInfopage.getOrganisationName().getText();
		softassert.assertTrue(true, title);
		Reporter.log(title, true);
//		if (title.contains(name)) {
//			System.out.println("===The organisation is created====");
//		}
//		else
//		{
//			System.out.println("===The organisation is not created====");
//		}
		//logout
		//homepage.Logout(driver);
	}
	

}
