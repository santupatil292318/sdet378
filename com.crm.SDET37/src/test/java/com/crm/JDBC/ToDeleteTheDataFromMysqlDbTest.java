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
public class ToDeleteTheDataFromMysqlDbTest {

	public static void main(String[] args) throws SQLException {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			Statement statement = connection.createStatement();
			String query="delete from student where lastName='r'";
			 int result = statement.executeUpdate(query);
			if(result==1)
			{
				System.out.println("data is deleted");
			}
			else
			{
				System.out.println("data is not deleted");
			}
			connection.close();
	}

}
