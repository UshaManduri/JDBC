package com.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pojo.SelExample;


public class Select_Query {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Scanner sc = null;
		
		try {
			//1.establish connection
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
					"postgres", "1234");
			System.out.println(con.getClass());
			
			//2.create statement object
			if(con != null)
				st = con.createStatement();
			
			sc=new Scanner(System.in);
			System.out.println("enter emp id: ");
			
			String empidStr = sc.nextLine();
			Long empId = Long.parseLong(empidStr);
			String sql = "Select emp_id, name, salary from public.emp where emp_id = "+empId;
			
			//3.execute query
			if(st!= null)
				rs = st.executeQuery(sql);
			System.out.println(rs.getClass());
			
			List<Sel_ex> data = new ArrayList<Sel_ex>();
			
			while (rs.next()) {
				Sel_ex pojo = new Sel_ex();
				pojo.setEmp_id(rs.getLong("emp_id"));
				pojo.setName(rs.getString("name"));
				pojo.setSalary(rs.getDouble("salary"));
				
				data.add(pojo);
			}
			System.out.println(data);
			
			//close all the objects
			con.close();
			st.close();
			rs.close();
						
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
