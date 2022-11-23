package com.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert_Query_eg {
	public static void main(String[] args) throws SQLException {
		System.out.println("Hello World");
		
		Connection con = null;
		Scanner sc = null;
		Statement st = null;
		
		
		//1.establish connection
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
				sc = new Scanner (System.in);
				System.out.println("Enter name: ");
				String name = sc.nextLine();
				
				System.out.println("enter salary: ");
				Double salary = Double.parseDouble(sc.nextLine());
				
				System.out.println("enter emp id: ");
				Long empId = Long.parseLong(sc.nextLine());
				
				String insertQuery = "Insert into public.emp(emp_id, name, salary) values('"+empId+"'  ,  '"+name+"'  , '"+salary+"')";
				
				System.out.println("Query is "+insertQuery);
				
				//2. create statement
				st = con.createStatement();
				
				//3.execute Statement
				System.out.println("ResultSet: "+st.executeUpdate(insertQuery));
		
	}
}
