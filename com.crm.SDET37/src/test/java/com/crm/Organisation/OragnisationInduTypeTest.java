package com.crm.Organisation;

import java.util.Random;

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
public class OragnisationInduTypeTest extends BaseClass {
@Test(groups = "RegressionTest",retryAnalyzer = com.crm.GenericUtilities.ListnerImplTn.class)
	public  void oragnisationInduTypeTest() throws Throwable {
//		WebDriver driver=null;
//		//To call all the utility
//		JavaUtility jLib=new JavaUtility();
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		WebdriverUtility wLib = new WebdriverUtility();
//		String url = fLib.fetchTheDataFrompropertyFile("URL");
//		String Username = fLib.fetchTheDataFrompropertyFile("UserName");
//		String password = fLib.fetchTheDataFrompropertyFile("password");
//		String browser = fLib.fetchTheDataFrompropertyFile("Browser");
		SoftAssert softassert = new SoftAssert();
//		//set of Driver Executable 
//		if (browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			//connect to driver
//			driver = new ChromeDriver();
//		}
//		else if (browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.chromedriver().setup();
//			driver= new ChromeDriver();
//		}else {
//
//			driver = new ChromeDriver();
//		}
		Random random =new Random();
		int random1 = random.nextInt(1000);
		//to read into excel sheet
		String organizationName = eLib.getExceldata("vtiger", 3, 2)+random1;
		//String organizationName = workbook.getSheet("vtiger").getRow(3).getCell(2).getStringCellValue();
		//maximize the window
		//wLib.maximizeTheBrowser(driver);
		
		//Giving implicit wait
		//wLib.implicitwait(driver);
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//goto vtiger application
		//driver.get(url);
		//vtiger username
//		LoginPage login = new LoginPage(driver);
//		login.loginToApp(Username, password);
//		login.getSubmitBtn();
		//click on organization 
		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationsLink().click();
		//driver.findElement(By.linkText("Organizations")).click();
		//create organization click plus symbol
	   	CreateOrganizationPage createorganization = new CreateOrganizationPage(driver);
	   	createorganization.getCreatOrganizationLink().click();
	
		//pass Organization Name
	   	createorganization.createOrganization(organizationName);
		
		//To click on industry
	    createorganization.industryDropDown("Communications");
	   	//WebElement industrydropdown = driver.findElement(By.name("industry"));
		//wLib.select(industrydropdown, "Communications");

		//To click on type dropdown
		createorganization.typeDropDown("Investor");
		//click on save
		createorganization.getSaveBtn().click();

		//To verify 
		CreateOrganizationInfoPage orgInfo = new CreateOrganizationInfoPage(driver);
		String orgText = orgInfo.getOrganisationName().getText();
		softassert.assertTrue(true, orgText);
		Reporter.log(orgText, true);
//		if (orgText.contains(organizationName)) {
//			System.out.println("===The organisation is created====");
//		}
//		else
//		{
//			System.out.println("===The organisation is not created");
//		}
		//logout
//		homepage.Logout(driver);
//		driver.quit();
	}

}
