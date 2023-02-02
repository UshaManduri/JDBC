package com.MultiThreading;

import java.util.Scanner;

public class SumOfNaturalNumbers {
	public static void main(String[] args) {
		int num, i, sum = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Sum from: ");
		
		i = sc.nextInt();
		System.out.println("Sum upto: ");
		
		num = sc.nextInt();
		while(i <= num) {
			
			sum = sum + i;
			i++;
		}
		
		System.out.println("Sum of Natural numbers: " + sum);
	}
}
