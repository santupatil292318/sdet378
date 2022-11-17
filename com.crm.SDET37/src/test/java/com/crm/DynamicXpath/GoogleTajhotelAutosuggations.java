package com.crm.DynamicXpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTajhotelAutosuggations {
	@Test
	public static void autosuggations()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Taajhotels");
		List<WebElement> autosug = driver.findElements(By.xpath("//span[text()='Taj Hotels']"));
		int count = autosug.size();
		System.out.println(count);
		for (int i=0;i<count;i++) {
			WebElement text = autosug.get(i);
			System.out.println(text);
			driver.quit();
		}

	}
}
