package com.crm.Testcase;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.FileUtility;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.WebdriverUtility;
import com.crm.Vtiger.objectRepository.EmailPage;
import com.crm.Vtiger.objectRepository.HomePage;
import com.crm.Vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class EmailVtigerTest {

	public static void main(String[] args) throws Throwable {
		//To fetch all generic utility
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
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
		//To get Random number
		Random random = new Random();
		int randnum = random.nextInt(1000);
		//maximise the browser
		wLib.maximizeTheBrowser(driver);
		
		//implicit wait
		wLib.implicitwait(driver);
		
		driver.get(url);
		//vtiger login
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		login.getSubmitBtn();
		
		
		//click On email
		HomePage homepage = new HomePage(driver);
		homepage.getEmailLink().click();
		
		//click on compose
		EmailPage email = new EmailPage(driver);
		email.getCompose().click();
		
		//switch to select compose window
		//String parentwindowid = driver.getWindowHandle();
		wLib.switchTowindow("Emails&action=EmailsAjax&fil", driver);
		//To pass value To input
		//driver.findElement(By.id("parent_name")).sendKeys("santupatil081@gmail.com");
		email.getInputValue().click();
		
		//switch to select product window

		wLib.switchTowindow("Contacts&action", driver);
		//To search Contact
		email.searchcontact("Patil");
		
		//To search the Contact
		email.getSearchBtn().click();
		
		//select The Contact
		email.getSelectContact().click();
		
		//switch back to Email window
		wLib.switchTowindow("Emails&action=EmailsAjax&fil", driver);

		//To pass value To cc
		email.ccname("sumanth12897@gmail.com");
		
		//To Give subject
		email.subject("Welcome");
		
		//To select file
		email.subject("C:\\Users\\santu\\Downloads\\Rahul.docx");
		//driver.findElement(By.id("my_file_element")).sendKeys("C:\\Users\\santu\\Downloads\\Rahul.docx");
		
		//To send
		//driver.findElement(By.name("Send")).click();

		//To save 
		email.getSaveBtn().click();
		wLib.switchTowindow("Emails&action", driver);
		//driver.switchTo().window(parentwindowid);
		//logout
		homepage.Logout(driver);
		


	}

}
