package practice;

import java.time.Duration;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartphoneNameInsortedorder {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("phones");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//validation of url page
		String urlphonespage = driver.getCurrentUrl();
		SoftAssert softassert = new  SoftAssert();
		softassert.assertTrue(true, urlphonespage);
		Reporter.log(urlphonespage, true);
		
		List<WebElement> phone = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
		LinkedList<String> phones = new LinkedList<String>();
		for (WebElement p : phone) {
		 phones.add(p.getText());
			
		}
		
		Collections.sort(phones,String.CASE_INSENSITIVE_ORDER);
		for(int i=0;i<=phones.size()-1;i++) {
			System.out.println(phones.get(i));
		}
	}

}
