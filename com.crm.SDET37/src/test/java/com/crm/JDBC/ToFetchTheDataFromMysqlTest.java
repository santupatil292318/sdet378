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
public class ToFetchTheDataFromMysqlTest {

	public static void main(String[] args) throws SQLException {
		//step1:register to DB
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//Step2:connect to mysql
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		
	    //step3:create statement\query
	    Statement statement = connection.createStatement();
		String query="select * from student";
		
		//step4:execute the query
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2));
		}
		
		//step5:close DB connection
		connection.close();
	}

}
