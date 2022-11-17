package com.crm.GenericUtilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * 
 * @author santu
 *
 */
public class WebdriverUtility {
	/**
	 * this method will minimize the window browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method will maximize the window Browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 *This method will wait till the page get loaded
	 * @param driver
	 */
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IConstants.implicitlyTimeout));
	}
	/**
	 * This method will refresh the page
	 * @param driver
	 */
	public void refreshThePage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	/**
	 * This method will navigate to next page
	 * @param driver
	 */
	public void forwardTheNextpage(WebDriver driver)
	{
		driver.navigate().forward();
	}
	/**
	 * This method will navigate the previous page
	 * @param driver
	 */
	public void backthepage(WebDriver driver)
	{
		driver.navigate().back();
	}
	/**
	 * This method will switch to frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch to frame by id
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 * This method will switch to frame by element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will till element to click
	 * @param driver
	 * @param element
	 */
	public void waitTillelementToclick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyTimeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method will till wait element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitTillElementvisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyTimeout));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait title of the page
	 * @param driver
	 * @param title
	 */
	public void waitTillpageLoadTitle(WebDriver driver,String title)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyTimeout));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method will wait load the url of the page
	 * @param driver
	 * @param URL
	 */
	public void waittillpageloadUrl(WebDriver driver,String URL)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyTimeout));
		wait.until(ExpectedConditions.urlContains(URL));
	}
	/**
	 * This method will ignore the no such element exception for the particular class
	 * @param driver
	 */
	public void ignoresuchElementException(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyTimeout));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This message wait for alert message to be visible
	 * @param driver
	 */
	public void waitForAlertmesg(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(IConstants.explicitlyTimeout));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This metod will click on sendkeys
	 * @param driver
	 */
	public void clickEnterkey(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * To take a screenshot
	 * @param driver
	 * @param screenshotname
	 */
	public static String takescreenshot(WebDriver driver,String screenshotname)
	{
 		TakesScreenshot takesreenshot = (TakesScreenshot)driver;
		File src = takesreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots"+screenshotname);
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return screenshotname;
	}
	/**
	 * this method is supermost method wait for whenever occur nosuchelement exception
	 * @param driver
	 */
	public void waitandclickusingcustomewait(WebDriver driver)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		try {
			wait.wait(10);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used for customwait
	 * @param element
	 * @param duration
	 * @param pollingtime
	 */
	public void waitAndclick(WebElement element, int duration,int pollingtime)
	{
		int count=0;
		while(count<duration)
		{
			try {
				element.click();
			} catch (Exception e) {
				try {
					Thread.sleep(pollingtime);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * this method will switch to the window
	 * @param actualurl
	 * @param driver
	 */
	public void switchTowindow(String actualurl,WebDriver driver)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String wId=it.next();
			driver.switchTo().window(wId);
			String url=driver.getCurrentUrl();
			if (url.contains(actualurl)) {
				break;
				
			}
		}
	}
	/**
	 * this method will switch to the window
	 * @param actualurl
	 * @param driver
	 */
	public void switchTowindowTitle(String actuatitle,WebDriver driver)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String wId=it.next();
			driver.switchTo().window(wId);
			String title=driver.getTitle();
			if (title.contains(actuatitle)) {
				break;
				
			}
		}
	}
	
	/**
	 * This method will mousehover on the element
	 * @param driver
	 * @param element
	 */
	public void mousehoverOnelement(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method will right click on the element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method will double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).click();
	}
	/**
	 * This method will switch to parent frame
	 * @param driver
	 */
	public void switchTomainFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will used to element in dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select select= new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will is used to element in dropdown using value
	 * @param element
	 * @param value
	 */
	public void select(WebElement element,String value)
	{
		Select select= new Select(element);
		select.selectByValue(value);
	}
	/**
	 * this method will used to element in dropdown in text
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element)
	{
		Select select= new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method will fetch all dropdown options
	 * @param element
	 */
	public void getAllOptiondropdown(WebElement element)
	{
		Select select= new Select(element);
		List<WebElement> option = select.getOptions();
		for (WebElement webElement : option) {
			String text=webElement.getText();
			System.out.println(text);
		}
	}
	/**
	 * This method will accept alert popup msg
	 * @param driver
	 * @param accepectedmsg
	 */
	public void switchToalertPopup(WebDriver driver,String accepectedmsg)
	{
		Alert alert = driver.switchTo().alert();
		if (alert.getText().trim().equalsIgnoreCase(accepectedmsg.trim())) {
			System.out.println("alert msg is verified");
		}
		else {
			System.out.println("alert msg is not verified");
		}
		alert.accept();
	}
	/**
	 * This method will dismiss the alert popup
	 * @param driver
	 * @param accepectedmsg
	 */
	public void switchToalertPopupdismiss(WebDriver driver,String accepectedmsg)
	{
		Alert alert = driver.switchTo().alert();
		if (alert.getText().trim().equalsIgnoreCase(accepectedmsg.trim())) {
			System.out.println("alert msg is verified");
		}
		else {
			System.out.println("alert msg is not verified");
		}
		alert.dismiss();
	}
}
