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
public class ToinsertTheDatarmgyantraTest {

	public static void main(String[] args) throws SQLException {
		//register to db
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		//connect to mysql
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		//create statement
		Statement statement = connection.createStatement();
		String query=" insert into project values('TY_PROJ_003','deepak1234','10-07-2022','student1','created','0')";
		//update the query
		int result = statement.executeUpdate(query);
		if(result==1)
		{
			System.out.println("The data to be inserted");
		}
		else
		{
			System.out.println("The data not be inserted");
		}
		//close the connection
		connection.close();
		
	}

}
