package com.pratice;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class JdbcTransactionExample {
	
	
	public static void main(String[] args) throws SQLException {
		String insertUsers = "INSERT INTO PUBLIC.USERS( USERNAME, ENABLED, LAST_LOGIN) 	VALUES ( ?, ?, ?)";

		java.sql.Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1234");

		connection.setAutoCommit(false);
		PreparedStatement ps = connection.prepareStatement(insertUsers, Statement.RETURN_GENERATED_KEYS);

		Scanner sc = new Scanner(System.in);
		System.out.println("Entere Usr Name:");
		ps.setString(1, sc.nextLine());
		System.out.println("Enter True or false:");
		
		ps.setBoolean(2, Boolean.parseBoolean(sc.nextLine()));
		ps.setTimestamp(3, new Timestamp(new Date().getTime()));

		//int result = ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		int useId = 0;
		while (rs.next()) {
			useId = rs.getInt(1);
			System.out.println("GenerateKey is "+ useId);
		} 

		String insertAddress = "INSERT INTO PUBLIC.ADDRESSES(USER_ID, STREET, CITY, STATE) VALUES (?, ?, ?, ?)";

		PreparedStatement ps2 = connection.prepareStatement(insertAddress);
		ps2.setInt(1, useId);
		System.out.println("Enter Street:");
		ps2.setString(2, sc.nextLine());
		System.out.println("Enter City:");
		ps2.setString(3, sc.nextLine());
		System.out.println("Enter State:");
	//	ps2.setString(40, sc.nextLine());
		ps2.setString(4, sc.nextLine());
		ps2.executeUpdate();
		
		connection.commit();
	}
}