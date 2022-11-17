package com.crm.DynamicXpath;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TofetchIccRatingsTest {

	@Test(dataProvider="team")
	public void iccRatings(String teams)
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		 List<WebElement> ratings = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[contains(.,'"+teams+"')]/td[5]"));
		 for (WebElement rating : ratings) {
			String team = rating.getText();
			System.out.println(teams+" = "+team);
		}
		 driver.quit();
		
	}

	@DataProvider
	public Object[] team() throws Throwable

	{
		Object[] objArr= new Object[10];
		objArr[0] ="India";
		objArr[1] ="South Africa";
		objArr[2] ="Australia";
		objArr[3] ="England";
		objArr[4] ="New Zealand";
		objArr[5] ="Pakistan";
		objArr[6] ="Sri Lanka";
		objArr[7] ="West Indies";
		objArr[8] ="Bangladesh";
		objArr[9] ="Zimbabwe";

		return objArr;


	}
}

