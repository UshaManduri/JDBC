package com.MultiThreading;

import java.util.Scanner;

public class PalindromeExample {
	
	public static void main(String[] args) {
		String original, reverse = "";
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a String/number to check if it is a palindrome");
		
		original = in.nextLine();
		
		int length = original.length();
		
		System.out.println("Length of string "+ length);
		for(int i = length - 1; i>=0; i--)
			reverse = reverse + original.charAt(i);
		
		if(original.equals(reverse))
			System.out.println("Entered string/number is a Palindrome.");
		else
			System.out.println("Entered string/number is not a Palindrome.");
	}
}
