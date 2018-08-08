package com.hung.backtracking;

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
		for(int i=0; i<4; i++) {
			y[i]=true;
		}
		generationSequence(1);
		input.close();
	}

	private static void generationSequence(int i) {
		for(int j=1;j<=n;j++) {
			if(y[j]) {
				x[i]=j;
				if(i==k) print();
				else {
					y[j]=false;
					generationSequence(i+1);
					y[j]=true;
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
