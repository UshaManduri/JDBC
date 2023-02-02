package com.MultiThreading;

public class Walmart {

	static String inputString = "agdefb";
	static char charToFind = 'd';

	static int stringLength = 13;

	static int remainder = stringLength%inputString.length() ;     //needs to be 3

	static int length = stringLength/inputString.length() ; 

	String infiniteString = "agdefbagdefbagde";


	//Find number of occurences of <charToFind> in first <stringLength> characters of <infiniteString>.

	public static int findOccurences(String inputString, final char charToFind, int length, int remainder)
	{

	  
	     int count =  (int) (inputString.chars().filter(c-> c==charToFind).count()*length);
	     
	     String remainiingString = inputString.substring(0, remainder);
	     
	      int remaininStringCount =  (int) remainiingString.chars().filter(c-> c==charToFind).count();
	     
	     return count +remaininStringCount ;
	    
	}
	
	public static void main(String[] args){
	    
	    System.out.println(findOccurences(inputString, charToFind, length, remainder));
	}
}
