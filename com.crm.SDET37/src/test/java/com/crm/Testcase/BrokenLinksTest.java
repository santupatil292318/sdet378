package com.crm.Testcase;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("java programs");
		
		driver.findElement(By.xpath("//div[@class='lJ9FBc']/descendant::input[@value='Google Search']")).click();
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (WebElement ele : links) {
			String link = ele.getAttribute("href");
			URL url = new URL(link);
			//HttpURLConnection con =HttpURLConnection(url);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.connect();
			if (con.getResponseCode()==200) {
				
				System.out.println("link is not brokend");
			}
			else {
				System.out.println("links are brokened");
			
			}
	
		}
		driver.quit();

	}
}

