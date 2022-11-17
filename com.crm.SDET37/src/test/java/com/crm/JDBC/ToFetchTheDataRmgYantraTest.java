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
public class ToFetchTheDataRmgYantraTest {

	public static void main(String[] args) throws SQLException {
		//register to db
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//connect to mysql
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		//create statement
		Statement statement = connection.createStatement();
		String query="select * from project";
		//executequery
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			
		}
		//close the connection
		connection.close();
		
	}

}
