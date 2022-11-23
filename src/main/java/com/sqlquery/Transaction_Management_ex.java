package com.sqlquery;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

public class Transaction_Management_ex {
	public static void main(String[] args) throws SQLException {
		String insertUsers = "insert into public.users(username, enabled, last_login) values (?, ?, ?)";
		java.sql.Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1234");
		
		connection.setAutoCommit(false);
		PreparedStatement ps = connection.prepareStatement(insertUsers, Statement.RETURN_GENERATED_KEYS);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter user name");
		ps.setString(1, sc.nextLine());
		System.out.println("enter true or false -> ");
		
		ps.setBoolean(2, Boolean.parseBoolean(sc.nextLine()));
		//ps.setTimestamp(3, new Timestamp(new Date().getTime()));
		ps.setTimestamp(3, new Timestamp(new Date().getTime()));
		
		int result = ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		int useId = 0;
		while(rs.next()) {
			useId = rs.getInt(1);
			System.out.println("GeneratedKey is: "+useId);
		}
		// in Addresses Table
		String insertAddress = "insert into public.addresses(user_id, street, city, state) values (?, ?, ?, ?)";
		
		PreparedStatement ps2 = connection.prepareStatement(insertAddress);
		ps2.setInt(1, useId);
		System.out.println("enter street");
		ps2.setString(2, sc.nextLine());
		System.out.println("enter city");
		ps2.setString(3, sc.nextLine());
		System.out.println("enter state");
		ps2.setString(4, sc.nextLine());
		ps2.executeUpdate();
	
		connection.commit();
	}
}
