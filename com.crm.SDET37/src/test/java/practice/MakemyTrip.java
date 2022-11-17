package practice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.GenericUtilities.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemyTrip  {

	public static void main(String[] args) throws Throwable {
		ExcelUtility ex = new ExcelUtility();
		//ex.getExceldata(null, 0, 0)
		  WebDriverManager.chromedriver().setup();
		    WebDriver driver= new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		    driver.get("http://makemytrip.com");
		    driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		    MakemytripPage mt = new MakemytripPage(driver);
		    WebElement ele = mt.getpopupbanner();
		     
		    wait.until(ExpectedConditions.elementToBeClickable(ele));
		    ele.click();
		    driver.switchTo().defaultContent();
		    mt.getfromcity().click();
		   
		    driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		    mt.gettoCity().click();
		   
		    driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		    mt.getreturnele().click();
		   
		    driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and contains(.,'November')]/parent::div[@class='DayPicker-Month']/descendant::p[.='18']")).click();
		    mt.getsearchele().click();
		    mt.getpopularfilter().click();
		    mt.getbtnclick().click();
		    mt.getflexiplus().click();
		    mt.getcontinuebtn().click();
		    
		    Set<String> wid = driver.getWindowHandles();
		    for (String string : wid) {
				driver.switchTo().window(string);
				String url = driver.getCurrentUrl();
				if (url.contains("flight/reviewD")) {
					System.out.println("displayed booking information");
				}
			}
		    driver.quit();
	
	}

}
