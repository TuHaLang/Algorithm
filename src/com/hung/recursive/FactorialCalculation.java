package com.hung.recursive;

import java.util.Scanner;

public class FactorialCalculation {

	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		int n = new Scanner(System.in).nextInt();
		if(n<0) System.out.println("Pleasr enter a number greater than 0!");
		else System.out.println(n + "!= " + Calculate(n));
	}
	
	public static int Calculate(int n) {
		if(n==0 || n==1) return 1;
		else return n*Calculate(n-1);
	}

}
