package com.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQL_Injection_Query {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = null;
		
		//1.Establish connection
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1234");
		sc = new Scanner(System.in);
		System.out.println("Enter Data");
		System.out.println("enter name:");
		String name = sc.nextLine();
		
		System.out.println("enter empId:");
		Long empId = Long.parseLong(sc.nextLine());
		
		String sql = "Select * from emp where name = ? and emp_id = ? ";
		
		//2.Create Statement
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setLong(2, empId);
		
		System.out.println("query is -> "+sql);
		
		//3. execute Query
		rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}
		
	}
}
