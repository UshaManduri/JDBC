package com.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertQueryExample {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("Hello World");
		//1. establish the connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1234");
		//

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter salary ");
		Double salary = Double.parseDouble(sc.nextLine());
		System.out.println("Enter emp id ");
		Long empId = Long.parseLong(sc.nextLine());
		String test = "'"+"'"+"abc";
		
		String insertQuery = "Insert into public.emp(emp_id, name, salary) values('"+empId +"','"+name+"',"+salary+")";
		
		System.out.println("Query is "+ insertQuery);
		
		//2. create statament
		Statement st = con.createStatement();
		
		//3. execute statement
		System.out.println("Resulet :"+ st.executeUpdate(insertQuery));
	}

}
