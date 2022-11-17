package com.crm.Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.FileUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.Vtiger.objectRepository.CreateOpportunitiesPage;
import com.crm.Vtiger.objectRepository.HomePage;
import com.crm.Vtiger.objectRepository.LoginPage;
import com.crm.Vtiger.objectRepository.VerifyOpportunityInfoPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class CreatingOpportunitytestcaseTest {

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
		//random number
		int randnum = jLib.getRandomNumber();
		//To fetch excell values
		String opportunityName = eLib.getExceldata("vtiger", 3, 4)+randnum;
		String lastName = eLib.getExceldata("vtiger", 4, 3)+randnum;
		//To maximise window
		wLib.maximizeTheBrowser(driver);
		
		//implicit wait
		wLib.implicitwait(driver);
		
		//To enter main url 
		driver.get(url);
		//vtiger username
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		login.getSubmitBtn();
		
		//To click on Opportynity
		HomePage homepage = new HomePage(driver);
		homepage.getOpportunitiesLink().click();
		
		//To create opportunity
		CreateOpportunitiesPage createopportunity = new CreateOpportunitiesPage(driver);
		createopportunity.getCreateOpportunity().click();
		
		//To pass value to opportunity Name
		createopportunity.opportunityName(opportunityName);
		
		//Related dropdown
		createopportunity.Relateddropdown("Contacts");
		//plus img
		createopportunity.getCreatcontactElement().click();
		
		wLib.switchTowindow("Contacts&action", driver);
		//search contacts
		createopportunity.searchcontact("Patil");
		
		//search
		createopportunity.getSearchcontactBtn().click();
		
		//select contacts
		createopportunity.getSelectContact().click();
		
		//To search click campaign plus
		wLib.switchTowindow("Potentials&action", driver);
		createopportunity.getCampaignplusClick().click();
		
		
		wLib.switchTowindow("Campaigns&action", driver);
		//search contacts
		createopportunity.searchcampaincontact(lastName);
		
		//search
		createopportunity.getSearchcampagnBtn().click();
		
		//select contacts
		createopportunity.getSelectCampaignContacts().click();
		
		//switch Back to Parent window
		wLib.switchTowindow("Potentials&action", driver);

		//click On calender
		createopportunity.getClickCalender().click();
		
		//change the date
		createopportunity.getChangeThedate().click();
		
		//to save
		createopportunity.getSaveBtn().click();
		
		//verify opportunity
		VerifyOpportunityInfoPage verifyopportunity = new VerifyOpportunityInfoPage(driver);
		String name =verifyopportunity.getName().getText();
		if (name.contains(opportunityName)) {
			System.out.println("=====opportunity created=====");
		}
		else
		{
			System.out.println("opportunity not created");
		}
		//Switch back to parent window
		wLib.switchTowindow("Potentials&action", driver);
		homepage.Logout(driver);
	}
}

