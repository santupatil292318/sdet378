package com.crm.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class AutomateTheDataRmgYantraTest {

	public static void main(String[] args) throws SQLException {
		//To Insert the data into Rmg Yantra
	
		Connection connection = null;
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//Maximise The Browser
		driver.manage().window().maximize();
		
		//implicitly wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Enter the url of Rmg Yantra application
		driver.get("http://localhost:8084/");
		
		//enter the username in Rmg Yantra
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		
		//enter the password in Rmg Yantra
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		//click in sign in button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click on projects link
		driver.findElement(By.linkText("Projects")).click();
		
		//click on project link
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		//enter the project Name
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(" TY_PROJ_0041");
		
		//enter the project manager
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("sanjay_sir1");
		
		//select the status from dropdown option
		WebElement dropdown = driver.findElement(By.xpath("//input[@type='submit']/../..//select[@name='status']"));
		//select the dropdown option
		Select select = new Select(dropdown);
		select.selectByValue("Created");
		
		//click on create project
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//To fetch The Data on RmgYantra
		
		try {
			//get register for mysql db
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			//connect to mysql
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			//create statement
			Statement statement = connection.createStatement();
			String query="select * from project";
			//executequery
			ResultSet result = statement.executeQuery(query);
			
			//verify the data in db
			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
				
			}
		} catch (Exception e) {
				//close the connection
				connection.close();
			}
		driver.quit();
		}
		
	
		

	}


