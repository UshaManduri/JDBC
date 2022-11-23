package com.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class Auto_Generate_Insert_ex {
	public static void main(String[] args) throws SQLException {
		String insertUsers = "insert into public.users(username, enabled, last_login) values (?, ?, ?)";
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1234");
		
		PreparedStatement ps = con.prepareStatement(insertUsers, Statement.RETURN_GENERATED_KEYS);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name");
		ps.setString(1,sc.nextLine());
		System.out.println("enter true/false");
		ps.setBoolean(2, Boolean.parseBoolean(sc.nextLine()));
		ps.setTimestamp(3, new Timestamp(new Date().getTime()));
		
		ResultSet rs = ps.getGeneratedKeys();
		int useId = 0;
		while(rs.next()) {
			useId = rs.getInt(1);
			
			System.out.println("auto generated key is userId -> ");
		}
		
		String insertAddress = "insert into public.addresses(user_id, street, city, state) values (?, ?, ?, ?)";
		PreparedStatement pss = con.prepareStatement(insertAddress);
		
		pss.setInt(1,useId);
		System.out.println("enter street name");
		pss.setString(2, sc.nextLine());
		System.out.println("enter city name");
		pss.setString(3, sc.nextLine());
		System.out.println("enter state name");
		pss.setString(4,sc.nextLine());
		
		System.out.println(pss.executeUpdate());
		sc.close();
		
	}
}
