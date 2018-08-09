package com.hung.backtracking;

import java.util.Arrays;

public class EightQueens {
	
	//size of chess board is 8x8 
	static int n=8;
	
	//store position which queen went through
	static int[] x = new int[n+1];
	
	//check have had a queen in the row yet?
	static boolean[] a = new boolean[n+1];
	
	//check have had a queen in the diagonal line yet?
	static boolean[] b = new boolean[2*n+1];
	static boolean[] c = new boolean[2*n-1];
	
	public static void main(String[] args) {
		
		//initialization all position are unoccupied
		Arrays.fill(a, true);
		Arrays.fill(b, true);
		Arrays.fill(c, true);
		
		//start try with first row
		Try(1);
	}
	 
	//display result
	static void print() {
		for(int i=1; i<=n; i++) {
			System.out.print("["+i+";"+x[i]+"]   ");
		}
		System.out.println();
	}
	
	//a function to solve algorithm
	static void Try(int i) {
		//check alternate the position in the row
		for(int j=1; j<=n; j++)
		{
			if(a[j] && b[i+j] && c[i-j+n-1]) //if position is unoccupied
			{
				x[i]=j; //try set position for the queen
				if(i==n) //if have already set position for 8 queen
					print();
				else 
				{
					//set position is occupied
					a[j]=false;
					b[i+j]=false;
					c[i-j+n-1]=false;
					
					//try with next row
					Try(i+1);
					
					//set position is unoccupied again
					a[j]=true;
					b[j+i]=true;
					c[i-j+n-1]=true;
				}
			}
		}
	}
}
