package com.hung.generation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ListSubsetsOfArrayRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arrInput = null;
		int k = 0;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(new File(
					"C:\\Users\\PHAMHUNG\\eclipse-workspace\\Algorithm\\src\\com\\hung\\generation\\testLSOAR.txt"));
			br = new BufferedReader(fr);
			String line = br.readLine();
			String[] arrLine = line.split("\\s");
			arrInput = new int[arrLine.length];
			
			for (int i = 0; i < arrLine.length; i++) {
				arrInput[i] = Integer.parseInt(arrLine[i]);
			}
			
			k = Integer.parseInt(br.readLine());
			GenerationSubsets(arrInput, k);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

	private static void GenerationSubsets(int[] arr, int k) {
		int[] arrSubset = CreateFirstSubset(arr, k);
		Print(arrSubset);
		int i = k - 1;
		int n = arr.length;
		while (!CheckFinish(arrSubset, arr)) {
			if (arrSubset[i] < arr[n - k + i]) {
				arrSubset[i] = arr[RetrieveIndexInArray(arrSubset[i], arr) + 1];
				for (int j = i + 1; j < k; j++) {
					arrSubset[j] = arr[RetrieveIndexInArray(arrSubset[j - 1], arr) + 1];
				}
				Print(arrSubset);
				i = k - 1;
			} else {
				if (i > 0)
					i--;
			}
		}
	}

	private static void Print(int[] arrSubset) {
		System.out.print("[");
		for (int i = 0; i < arrSubset.length; i++) {
			System.out.print(arrSubset[i]);
			if (i < arrSubset.length - 1)
				System.out.print(" ; ");
		}
		System.out.print("]");
		System.out.println();

	}

	private static int RetrieveIndexInArray(int x, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}

	private static boolean CheckFinish(int[] arrSubset, int[] arr) {
		int k = arrSubset.length;
		int n = arr.length;
		for (int i =0; i < k; i++) {
			if (arrSubset[i] != arr[n-k+i])
				return false;
		}
		return true;
	}

	private static int[] CreateFirstSubset(int[] arr, int k) {
		int[] firstSubset = new int[k];
		for (int i = 0; i < k; i++) {
			firstSubset[i] = arr[i];
		}
		return firstSubset;
	}

}
