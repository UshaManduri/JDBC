package com.MultiThreading;

public class MyThread extends Thread{
	public void run() {
		System.out.println("run executed");
	}
	
	public void run(String s) {
		System.out.println("I am in run string method");
	}
	
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
		
		System.out.println("main executed");
	}
}
