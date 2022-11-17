package com.crm.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InterviewQuetion {
	public static void main(String[] args) throws Throwable {
		for(;;)
		{
		Class.forName("com.mysql.jdbc.Driver");
		//Driver driverref=new Driver();
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement statement = con.createStatement();
		Scanner sc =new Scanner(System.in);
		System.out.println("enter name");
		String string = sc.nextLine();
		if (string.length()>=6) {
			String query="select * from employee";
			ResultSet  result = statement.executeQuery(query);
			boolean flag=true;
			while (result.next()) {
				if (result.getString(1).equalsIgnoreCase(string)) {
					flag=false;
					break;
				}
			}
			if (flag==false) {
				System.out.println("Yes,The data allready present");
			}
			else {
				System.out.println("No,i will insert now");
				String query1=" insert into employee values('"+string+"')";
				int result1 = statement.executeUpdate(query1);
				if(result1==1)
				{
					System.out.println("The data to be inserted");
				}
				else
				{
					System.out.println("The data not be inserted");
				}
			}	
		} else {
			System.out.println("enter valid length");
		}

		con.close();
	}
	}
}
