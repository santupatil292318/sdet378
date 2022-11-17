package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartPhonePricesort {

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

		List<WebElement> phoneprice = driver.findElements(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/descendant::div[@class='_4rR01T']/ancestor::a[@class='_1fQZEK']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		ArrayList<Integer> prices = new ArrayList<Integer>();
		for (WebElement price : phoneprice) {
			String text = price.getText();
			String value = text.substring(1).replace(",", "");
		Integer	pri=Integer.parseInt(value);
		prices.add(pri);
		}

		Collections.sort(prices);
		for(int i=0;i<=prices.size()-1;i++) {
			System.out.println(prices.get(i));
		}
		driver.quit();
	}

}
