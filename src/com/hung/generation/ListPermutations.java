package com.hung.generation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ListPermutations {

	/*-----Describe Algorithm-----
	 * 
	 * 
	 * 
	 * */

	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(
					new File("C:\\Users\\PHAMHUNG\\eclipse-workspace\\Algorithm\\src\\com\\hung\\generation\\testLP.txt"));
			br = new BufferedReader(fr);
			String line = br.readLine();
			line = line.trim();
			int arr[] = new int[line.length()];
			for(int i=0; i< arr.length; i++) {
				arr[i] = Integer.parseInt(line.charAt(i)+"");
			}
			permutation(arr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void permutation(int[] arr) {
		int[] temp = arr.clone();
		int n=arr.length;
		int i=n-1;
		print(temp);
		while(!checkFinish(arr, temp)) {
			if(temp[i-1]<temp[i]) {
				int x = temp[i];
				temp[i]=temp[i-1];
				temp[i-1]=x;
				print(temp);
				i=n-1;
			}
			else {
				if(i>1) i--;
			}
		}
	}

	private static void print(int[] temp) {
		// TODO Auto-generated method stub
		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i]);
		}
		System.out.println();
	}

	private static boolean checkFinish(int[] arr, int[] temp) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			if(temp[i]!=arr[n-i-1]) return false;
		}
		return true;
	}

}
