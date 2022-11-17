package com.crm.DynamicXpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TofetchAllflipcartpricesTest {
@Test
public void Getallprices()
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	driver.get("https://www.flipkart.com");
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("phone");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	System.out.println("======All Phone prices======");
	List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	for (WebElement ele : price) {
		String pricelist = ele.getText();
		System.out.println(pricelist);
	}
	
	System.out.println("====All Products List=====");
	List<WebElement> products = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	for (WebElement productlist : products) {
		String productsname = productlist.getText();
		System.out.println(productsname);
	}
	System.out.println("====get the price of specific Product====");
	String samsungsp = driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy F13 (Nightsky Green, 64 GB)']/ancestor::div[@class='_3pLy-c row']/descendant::div[@class='_30jeq3 _1_WHN1']")).getText();
	System.out.println("SAMSUNG Galaxy F13 = "+samsungsp);
	driver.quit();
}
}
