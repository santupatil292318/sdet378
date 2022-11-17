package com.crm.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * 
 * @author santu
 *
 */
public class ToDescribeTheDataFromDbTest {

	public static void main(String[] args) throws SQLException {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		Statement statement = connection.createStatement();
		String query="show tables";
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			System.out.println(result.getString(1));
			
		}
		connection.close();

	}

}
