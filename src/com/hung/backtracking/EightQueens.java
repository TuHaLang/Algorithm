package com.hung.backtracking;

import java.util.Arrays;

public class EightQueens {
	static int n=8;
	static int[] x = new int[n+1];
	static boolean[] a = new boolean[n+1];
	static boolean[] b = new boolean[2*n+1];
	static boolean[] c = new boolean[2*n-1];
	
	public static void main(String[] args) {
		Arrays.fill(a, true);
		Arrays.fill(b, true);
		Arrays.fill(c, true);
		Try(1);
	}
	 
	static void print() {
		for(int i=1; i<=n; i++) {
			System.out.print("["+i+";"+x[i]+"]   ");
		}
		System.out.println();
	}
	
	static void Try(int i) {
		for(int j=1; j<=n; j++) {
			if(a[j] && b[i+j] && c[i-j+n-1]) {
				x[i]=j;
				if(i==n) print();
				else {
					a[j]=false;
					b[i+j]=false;
					c[i-j+n-1]=false;
					Try(i+1);
					a[j]=true;
					b[j+i]=true;
					c[i-j+n-1]=true;
				}
			}
		}
	}
}
