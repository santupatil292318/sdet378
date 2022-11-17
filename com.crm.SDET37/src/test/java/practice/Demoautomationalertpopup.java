package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demoautomationalertpopup {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/");
		driver.findElement(By.xpath("//button[text()='Skip Sign In']")).click();
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		action.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Alerts']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='aswift_2']")));
		action.doubleClick().perform();
		//action.doubleClick().perform();
		}
	}
