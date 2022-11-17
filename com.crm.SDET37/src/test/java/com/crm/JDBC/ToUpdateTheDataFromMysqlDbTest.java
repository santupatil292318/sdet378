package com.crm.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * 
 * @author santu
 *
 */
public class ToUpdateTheDataFromMysqlDbTest {

	public static void main(String[] args) throws SQLException {
	Driver driverref = new Driver();
	DriverManager.registerDriver(driverref);
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		Statement statement = connection.createStatement();
		String query="insert into student values('san','r1','rmg142','1991-02-15','male');";
		 int result = statement.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data is created");
		}
		else
		{
			System.out.println("data is not created");
		}
		connection.close();

	}

}
