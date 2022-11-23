package com.pratice;

import java.sql.Timestamp;
import java.util.Date;

public class SQLDate {

	public static void main(String[] args) {
		
		java.sql.Date sqlDate1 = new java.sql.Date(System.currentTimeMillis());
		
		System.out.println("Current sql date is "+ sqlDate1);
		
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		
		System.out.println("Current sql date from util date "+ sqlDate);

		
		
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		
		System.out.println("Current timestamp using ms "+ timeStamp);
		
		//new Timestamp(new Date().getTime())
		java.util.Date utilDate = new java.util.Date();
		Timestamp timeStamp1 = new Timestamp(utilDate.getTime());
		
		Timestamp timeStamp2 = new Timestamp(new java.util.Date().getTime());
		
		System.out.println("Timestamp using util date "+timeStamp1);
		
	}

}
