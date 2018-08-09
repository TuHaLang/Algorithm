package com.hung.backtracking;

import java.util.Scanner;

public class ListSubsets {
	/*
	 * x[k]<=n
	 * x[k-1]<=x[k]-1<=n-1
	 * ...
	 * x[i]<n-k+i
	 * 
	 * x[1]<n-k+1
	 * =>>>x[i-1]+1<=x[i]<=n-k+i
	 * */
	
	
	static int[] x;
	static int n,k;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("n=");
		n = input.nextInt();
		System.out.println("k=");
		k = input.nextInt();
		
		x = new int[k+1];
		for(int i=0; i<=k; i++) {
			x[i]=0;
		}
		generationSubset(1);
		input.close();
	}

	private static void generationSubset(int i) {
		for(int j=x[i-1]+1; j<=n-k+i; j++) {
			x[i]=j;
			if(i==k) print();
			else generationSubset(i+1);
		}
	}

	private static void print() {
		for(int i=1; i<k+1; i++) {
			System.out.print(x[i]);
		}
		System.out.println();
	}

}
