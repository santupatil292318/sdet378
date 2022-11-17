package com.crm.Testcase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author santu
 *
 */
public class ToVerifyThedatainRmgYantraTest {

	public static void main(String[] args) throws SQLException {
		String Projectid="TY_PROJ_005";
			//register driver
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			//connect to mysql
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Statement statement = connection.createStatement();
			Statement statement1 = connection.createStatement();
			String query = "insert into project values('TY_PROJ_005','deepak1234','10-07-2022','student1','created','0')";
			int result = statement.executeUpdate(query);
			if(result==1)
			{
				System.out.println("the data to be inserted");
			}
			else {
				System.out.println("The data to be not inserted");
			}
	
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
		String query1 = "select * from project";
		ResultSet result1 = statement1.executeQuery(query1);
		while (result1.next()) {
			String expected=result1.getString(1);
			if (expected.contains(Projectid))
			{
				System.out.println("Project is created");
			}
			else {
				System.out.println("Project is not created");
			}
		}
		
		driver.quit();
		connection.close();
		
	}

}
