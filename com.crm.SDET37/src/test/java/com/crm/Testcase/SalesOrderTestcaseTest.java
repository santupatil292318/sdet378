package com.crm.Testcase;

import java.util.Set;

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
import com.crm.Vtiger.objectRepository.HomePage;
import com.crm.Vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class SalesOrderTestcaseTest {

	public static void main(String[] args) throws Throwable {
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
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else {

			driver= new ChromeDriver();
		}
		//Random number
		int random = jLib.getRandomNumber();
		//To read data into excel sheet
		String salesSubject = eLib.getExceldata("vtiger", 6, 10)+random;
		String customerNumber = eLib.getExceldata("vtiger", 7, 10)+random;
		
		//window size maximise
		wLib.maximizeTheBrowser(driver);
		
		//implict wait
		wLib.implicitwait(driver);
		//Entering url of main application
		driver.get(url);
		//vtiger login
		LoginPage login = new LoginPage(driver);
		login.loginToApp(username, password);
		login.getSubmitBtn();
		
		//click on more navigation
		HomePage homepage = new HomePage(driver);
		homepage.More(driver);
		
		//click on sales order
		homepage.getSalesOrder().click();
		
		//create sales order
		driver.findElement(By.xpath("//img[@title='Create Sales Order...']")).click();
		//enter subject
		driver.findElement(By.name("subject")).sendKeys(salesSubject);
		//To enter customer number
		driver.findElement(By.id("customerno")).sendKeys(customerNumber);
		//To select contact click plus
		driver.findElement(By.xpath("//img[contains(@onclick,'selectC')]")).click();
		String parentwindowid = driver.getWindowHandle();
		Set<String> contactwindow = driver.getWindowHandles();
		for (String contact : contactwindow) {
			driver.switchTo().window(contact);

		}
		//to search field search element contact
		driver.findElement(By.id("search_txt")).sendKeys("Patil");
		//To search values
		driver.findElement(By.name("search")).click();
		//To select contact
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		driver.switchTo().alert().accept();
		//switch back To parent sales window
		driver.switchTo().window(parentwindowid);
		//To select approved dropdown
		WebElement approveddropdown = driver.findElement(By.name("sostatus"));
		Select select=new Select(approveddropdown);
		select.selectByValue("Approved");
		//To select opportunity
		driver.findElement(By.xpath("//img[@onclick='selectPotential()']")).click();
		Set<String> oppotunitywindow = driver.getWindowHandles();
		for (String opportunitywindowid : oppotunitywindow) {
			driver.switchTo().window(opportunitywindowid);
		}

		//to search field search element
		driver.findElement(By.id("search_txt")).sendKeys("software");
		//To search values
		driver.findElement(By.name("search")).click();
		//To select contact
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		//driver.switchTo().alert().accept();
		//switch back To parent sales window
		driver.switchTo().window(parentwindowid);

		//to handle end calender date
		driver.findElement(By.id("jscal_trigger_duedate")).click();
		driver.findElement(By.xpath("//td[@class='day' and text()='15']")).click();
		//To select organisation
		driver.findElement(By.xpath("//img[contains(@onclick,'return window.open(\"')]")).click();
		Set<String> organisationwindow = driver.getWindowHandles();
		for (String windowid : organisationwindow) {
			driver.switchTo().window(windowid);
		}

		//to search field search element
		driver.findElement(By.id("search_txt")).sendKeys("software");
		//To search values
		driver.findElement(By.name("search")).click();
		//To select organisation
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		driver.switchTo().alert().accept();

		//switch back To parent sales window
		driver.switchTo().window(parentwindowid);
		//invoice status
		WebElement invoice1 = driver.findElement(By.name("invoicestatus"));
		Select invoice = new Select(invoice1) ;
		invoice.selectByValue("Created");

		//billing address
		driver.findElement(By.name("bill_street")).sendKeys("kattriguppe banglore");
		//shipping street
		driver.findElement(By.name("ship_street")).sendKeys("Basavanagudi");
		//lineitem
		driver.findElement(By.id("searchIcon1")).click();
		Set<String> lineitem = driver.getWindowHandles();
		for (String line : lineitem) {
			driver.switchTo().window(line);
		}
		//to search field search line item
		driver.findElement(By.id("search_txt")).sendKeys("website");
		//To search line item
		driver.findElement(By.name("search")).click();
		//To select line item
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		//driver.switchTo().alert().accept();
		//switch back to parent window
		driver.switchTo().window(parentwindowid);
		//quantity
		driver.findElement(By.id("qty1")).sendKeys("3");
		//list Price
		driver.findElement(By.id("listPrice1")).sendKeys("300000");
		//To save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//To verify sales order created or not
		String verify = driver.findElement(By.id("dtlview_Subject")).getText();
		if (verify.contains(salesSubject)) {
			System.out.println("=====Sales order is created=====");
		}
		else {
			System.out.println("Sales order is not created");

		}
		driver.switchTo().window(parentwindowid);

		WebElement adminstration = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action =new Actions(driver);
		action.moveToElement(adminstration).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
