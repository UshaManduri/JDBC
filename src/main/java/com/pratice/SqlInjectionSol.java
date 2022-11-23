package com.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SqlInjectionSol {

	public static void main(String[] args) throws SQLException {
		//1. Establish connection
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1234");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter data");
		System.out.println("Enter name");
		String name = sc.nextLine();
		
		System.out.println("Enter emp id");
		Long empId = Long.parseLong(sc.nextLine());
		
		String sql = "Select * from emp where name =? and emp_id = ?";
		
		//2. create preparedstatement
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setLong(2, empId);
		//preparedstatemnt is used to fill the sql query
		
		System.out.println("query is "+sql);
		//3. execute query
		
		ResultSet rs = ps.executeQuery();
		
		//here 1,2,3 represents the column number
		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString("salary"));
		}
		//2. update query
		//3. insert query
	}

}
