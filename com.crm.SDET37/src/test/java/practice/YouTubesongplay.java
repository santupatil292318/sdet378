package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YouTubesongplay {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://youtube.com");
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("karunada tayi sada chinmayi");
		driver.findElement(By.id("search-icon-legacy")).click();
		driver.findElement(By.xpath("//a[@href='/watch?v=ceKvyYE9G1s']")).click();
		//dsdgxdfd
		System.out.println("fdsfds");
	}

}
