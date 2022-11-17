package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartPhoneandPricesortorder {

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
		int phones = phone.size();
		List<WebElement> phoneprice = driver.findElements(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/descendant::div[@class='_4rR01T']/ancestor::a[@class='_1fQZEK']/descendant::div[@class='_30jeq3 _1_WHN1']"));

				HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i <phones; i++) {
			String phonename = phone.get(i).getText();
			String text = phoneprice.get(i).getText();
			String value = text.substring(1).replace(",", "");
			Integer	pri=Integer.parseInt(value);
			map.put(phonename, pri);
		}
		Collection<Integer> value = map.values();
		ArrayList<Integer> list = new ArrayList<Integer>(value);
		Collections.sort(list);
		//System.out.println(list);

		Set<Entry<String, Integer>> set = map.entrySet();
		for (Entry<String, Integer> entry : set) {

			System.out.println(entry.getKey()+" = "+entry.getValue());
		}
		for(int i=0;i<=list.size()-1;i++) {
			
		}
			driver.quit();
	}
}

