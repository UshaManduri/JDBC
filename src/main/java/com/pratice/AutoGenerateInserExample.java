package com.pratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class AutoGenerateInserExample {


	public static void main(String[] args) throws SQLException {
		String insertUsers = "INSERT INTO PUBLIC.USERS( USERNAME, ENABLED, LAST_LOGIN) 	VALUES ( ?, ?, ?)";

		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1234");

		// String insertQuery="insert into emp(name,salary) values(?, ?)";
		PreparedStatement ps = connection.prepareStatement(insertUsers, Statement.RETURN_GENERATED_KEYS);

		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name :");
		ps.setString(1, sc.nextLine());
		System.out.println("enter true or false :");
		ps.setBoolean(2, Boolean.parseBoolean(sc.nextLine()));
		ps.setTimestamp(3, new Timestamp(new Date().getTime()));
		
//		int rs = ps.executeUpdate();
		
		ResultSet gk = ps.getGeneratedKeys();
		
		int useId = 0;
		while(gk.next()) {
			useId=gk.getInt(1);
			
			System.out.println("Auto generated key is userId "+useId);
		}
		
		String insertAdress = "INSERT INTO public.addresses( user_id, street, city, state) VALUES (?, ?, ?, ?)";
		PreparedStatement ps1 = connection.prepareStatement(insertAdress);
		
		ps1.setInt(1, useId);
		System.out.println("enter street name :");
		ps1.setString(2, sc.nextLine());
		System.out.println("Enter city name :");
		ps1.setString(3, sc.nextLine());
		System.out.println("Enter state name :");
		ps1.setString(4, sc.nextLine());
		
		System.out.println(ps1.executeUpdate());
		sc.close();
	}


}
