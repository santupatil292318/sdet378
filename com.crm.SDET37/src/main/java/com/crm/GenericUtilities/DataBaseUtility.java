package com.crm.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;
/**
 * 
 * @author santu
 *
 */
public class DataBaseUtility {
	/**
	 * This method will established connection to db
	 */
	static Driver driverref;
	static Connection connection;
	static ResultSet result;
	public void connectTodb()
	{
		try {
			driverref= new Driver();
			DriverManager.registerDriver(driverref);
			connection=DriverManager.getConnection(IConstants.dburl+IConstants.dbUsername+IConstants.dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	/**
	 * close the db connection
	 */
	public void closeDB()
	{
		try {
			connection.close();
		} catch (Exception e) {

		}	
	}
	/**
	 * This method will execute the query
	 * @param querry
	 * @param columnIndex
	 * @param expecteddata
	 * @return
	 * @throws Throwable
	 */
	public boolean ExecutequeryandVerify(String querry,int columnIndex,String expecteddata) throws Throwable
	{
		boolean flag=false;
		result=connection.createStatement().executeQuery(querry);
		while(result.next())
		{
			if (result.getString(columnIndex).equalsIgnoreCase(expecteddata)) {
				flag=true;
				break;
			}
		}
		if (flag) {
			System.out.println(expecteddata+"data is verified");
			return flag;
		}
		else {
			System.out.println(expecteddata+"expected data is not verified");
			return flag;
		}
	}
	/**
	 * this method will update the query
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public int executeUpdate(String query) throws Throwable
	{
		int result=connection.createStatement().executeUpdate(query);
		if (result==1)
		{
			System.out.println("the data to be updated");
		}
		else {
			System.out.println("The data to be not updated");
		}
		return result;
	}
}
