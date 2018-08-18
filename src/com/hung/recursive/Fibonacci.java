package com.hung.recursive;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a number: ");
		int n = new Scanner(System.in).nextInt();
		if(n<0) System.out.println("Please enter a number greater than 0!");
		else System.out.println("F("+n+")= " + Calculate(n));
		Solve(10);
	}
	
	public static int Calculate(int n) {
		if(n==1 || n==2) return 1;
		else return Calculate(n-1) + Calculate(n-2);
	}
	
	//giả thuyết của Collazt
	public static void Solve(int n) {
		if(n==1) System.out.println(n);
		else {
			if(n==((n/2)*2)) {
				System.out.println("*2");
				Solve(n/2);
			}
			else {
				System.out.println("div 3");
				Solve(n*3+1);
			}
		}
		
	}

}
