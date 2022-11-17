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
public class ToContactVerifyTest extends BaseClass {
@Test(groups = "SmokeTest",retryAnalyzer = com.crm.GenericUtilities.ListnerImplTn.class )

	public  void toContactVerifyTest() throws Throwable {
		
		SoftAssert softassert = new SoftAssert();
		
		int randnum = jLib.getRandomNumber();
		//To read the data into excel sheet
		String firstName = eLib.getExceldata("vtiger", 3, 3)+randnum;
		//To read FirstName
		//String firstName = workbook.getSheet("vtiger").getRow(3).getCell(3).getStringCellValue();
		//To read lastName
		String lastName = eLib.getExceldata("vtiger", 4, 3)+randnum;
		//String lastName = workbook.getSheet("vtiger").getRow(4).getCell(3).getStringCellValue();
		String orgname = eLib.getExceldata("vtiger", 3, 2)+randnum;
		//maximize the window
	
		
		//Giving implicit wait
		
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//goto vtiger application
		
		//vtiger username
	
		//click on logi
		
		
		HomePage homepage = new HomePage(driver);
		//click on contacts
		homepage.getContactsLink().click();
		

		//click on + symbol
		CreateContactPage createcontact = new CreateContactPage(driver);
		createcontact.getCreatContactLink().click();

		//firstName select mr
		createcontact.firstName("Mr.");
		
		createcontact.createcontact(firstName, lastName);
		
		String parentwindowid = driver.getWindowHandle();

		//To select organisation
		
		createcontact.selectOrganization(driver, orgname);
		
		//switch back to parent window
		driver.switchTo().window(parentwindowid);
		//To save contact
		createcontact.saveBtn();
		//To verify The contacts
		ContactInfoPage contactinfo = new ContactInfoPage(driver);
		String contact = contactinfo.getVerifycontact().getText();
		
		softassert.assertTrue(contact.contains(firstName));
		Reporter.log("The Contact is created", true);
//		if (contact.contains(firstName)) {
//			System.out.println("===The Contact is created====");
//		}
//		else
//		{
//			System.out.println("===The contact is not created====");
//		}
		//logout
	


	}

}
