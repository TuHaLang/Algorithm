package com.hung.sort;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		int[] x = {1,23,4,53,4,55,3};
		sort(x);
		print(x);
	}
	
	static void print(int[] x) {
		System.out.print("[ ");
		for(int i=0; i< x.length-1; i++) {
			System.out.print(x[i]+" , ");
		}
		System.out.print(x[x.length-1]+" ]");
	}
	static void sort(int[] x) {
		Arrays.sort(x);
	}

}
