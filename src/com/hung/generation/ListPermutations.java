package com.hung.generation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ListPermutations {

	/*-----Describe Algorithm-----
	 * I gonna enumerate permutation assemblage in the order of the dictionary
	 * So, the first permutation is [1,2,3,...,n], the finally permutation is [n,n-1,n-1,...,1]
	 * Finding from end to top until found arr[i]<arr[i+1]
	 * If found:
	 * 		+ Finding from end to i the first value arr[k]>arr[i] and convert index of them
	 * 		+ Reverse the last section order
	 * If didn't find: 
	 * 		+ Finish program
	 * */

	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(

					new File("src/com/hung/generation/testLP.txt"));

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


	//function generate permutation

	private static void permutation(int[] arr) {
		int[] temp = arr.clone();
		int n=arr.length;
		int i=n-1; 
		print(temp);
		while(true) {
			if(temp[i-1]<temp[i]) {
				for(int j=n-1; j>i-1; j--) {
					if(temp[i-1]<temp[j]) {
						int x=temp[j];
						temp[j]=temp[i-1];
						temp[i-1]=x;
						
						for(int k=i; k<n-1; k++) {
							x=temp[k];
							temp[k]=temp[n-k+i-1];
							temp[n-k+i-1]=x;
						}
						break;
					}
				}
				print(temp);
				i=n-1;
			}
			else {
				if(i>1) i--;
				else break;
			}
		}
	}

	private static void print(int[] temp) {
		
		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i]);
		}
		System.out.println();
	}
}
