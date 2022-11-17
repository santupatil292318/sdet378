package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipcartflightsautomate {

	public static void main(String[] args) throws Throwable {
			    WebDriverManager.chromedriver().setup();
			    WebDriver driver= new ChromeDriver();
			    driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			    driver.get("http://makemytrip.com");
			    driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			    WebElement ele = driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']"));
			    wait.until(ExpectedConditions.elementToBeClickable(ele));
			    ele.click();
			    driver.switchTo().defaultContent();
			    driver.findElement(By.xpath("//label[@for='fromCity']")).click();
			    driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
			    driver.findElement(By.xpath("//label[@for='toCity']")).click();
			    driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
			    driver.findElement(By.xpath("//span[@class=\"lbl_input latoBold appendBottom10\" and contains(.,'RETURN')]")).click();
			    driver.findElement(By.xpath("//div[@class='DayPicker-Caption' and contains(.,'November')]/parent::div[@class='DayPicker-Month']/descendant::p[.='18']")).click();
			    driver.findElement(By.xpath("//a[.='Search']")).click();
			    driver.findElement(By.xpath("//p[.='Popular Filters']/parent::div[@class='filtersOuter']/descendant::label[@class='makeFlex spaceBetween appendBottom12 pointer ' and contains(.,'IndiGo')]/descendant::span[@class='box']")).click();
			    driver.findElement(By.xpath("//button[.='Book Now']")).click();
			    driver.quit();
			  }

	}


