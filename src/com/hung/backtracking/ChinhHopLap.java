package com.hung.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class ChinhHopLap {
	static int n,k;
	static int[] x;
	static boolean[] y;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter n,k =");
		n = input.nextInt();
		k= input.nextInt();
		x = new int[k+1];
		y = new boolean[n+1];
		Arrays.fill(y,true);
		//start try first element
		generationSequence(1);
		input.close();
	}

	private static void generationSequence(int i) {
		for(int j=1;j<=n;j++) //try alternate element in the assemblage
		{
			if(y[j]) //if the element haven't used yet
			{
				x[i]=j; //set this element in the sequence
				if(i==k) //if have already set 
					print();
				else 
				{
					y[j]=false; //tick this element have use
					generationSequence(i+1); //continue try...
					y[j]=true; //untick
				}
			}
		}
	}

	private static void print() {
		for(int i=1; i<k+1; i++) {
			System.out.print(x[i]);
		}
		System.out.println();
	}

}
