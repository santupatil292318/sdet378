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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateMaximumRuns {
	@Test
	public void runs()
	{
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cricbuzz.com");
		MaximumwktPage maxwkt = new MaximumwktPage(driver);
		maxwkt.getSlkpakwomen().click();
		maxwkt.getscorecardlnk().click();
		List<WebElement> names = driver.findElements(By.xpath("//div[@url='/api/html/cricket-scorecard/50963']/descendant::a[contains(.,' Janneman Malan ')]/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::a[@class='cb-text-link']"));
		int name = names.size();
		List<WebElement> runs = driver.findElements(By.xpath("//div[@url='/api/html/cricket-scorecard/50963']/descendant::a[contains(.,' Janneman Malan ')]/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[@class='cb-col cb-col-8 text-right text-bold' and not (text()='R')]"));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < name; i++) {
			String Playername = names.get(i).getText();
			System.out.println(runs.get(i).getText());
			int run = Integer.parseInt(runs.get(i).getText());
			map.put(Playername, run);
		}
		Collection<Integer> value = map.values();
		//System.out.println("value"+value);
		
		ArrayList<Integer> list = new ArrayList<Integer>(value);
		//System.out.println("list"+list);
		
		Collections.sort(list);
		int n = (int)list.get(list.size()-1);
		//System.out.println("n"+n);
		Set<Entry<String, Integer>> set = map.entrySet();
		System.out.println(set);
		for (Entry<String, Integer> entry : set) {
			if (entry.getValue()==n) {
				System.out.println(entry.getKey()+""+entry.getValue());
			}
			
		}
		driver.quit();

}
}
