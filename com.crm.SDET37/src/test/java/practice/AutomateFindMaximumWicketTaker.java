package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateFindMaximumWicketTaker {

	@Test
	
	public void maximumWicket()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cricbuzz.com");
		MaximumwktPage maxwkt = new MaximumwktPage(driver);
		maxwkt.getSlkpakwomen().click();
		maxwkt.getscorecardlnk().click();
		List<WebElement> elename = driver.findElements(By.xpath("//div[@url='/api/html/cricket-scorecard/50963']/descendant::a[contains(.,' Washington Sundar ')]/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::a[@class='cb-text-link']"));
		int names = elename.size();
		
		List<WebElement> elewkt = driver.findElements(By.xpath("//div[@url='/api/html/cricket-scorecard/50963']/descendant::a[contains(.,' Washington Sundar ')]/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-8 text-right text-bold']"));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < names; i++) {
			String name = elename.get(i).getText();
			//String wkt = elewkt.get(i).getText();
			int wkts = Integer.parseInt(elewkt.get(i).getText());
			map.put(name, wkts);
		}
		Collection<Integer> value = map.values();
		ArrayList<Integer> list = new ArrayList<Integer>(value);
		Collections.sort(list);
		int n = (int)list.get(list.size()-1);
		Set<Entry<String, Integer>> set = map.entrySet();
		for (Entry<String, Integer> entry : set) {
			if (entry.getValue()==n) {
				System.out.println(entry.getKey()+""+entry.getValue());
			}
		}
		driver.quit();
	}
}
