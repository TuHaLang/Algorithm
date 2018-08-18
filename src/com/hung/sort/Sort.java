package com.hung.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Sort {

	static Integer[] k;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br =null;
		FileReader fr = null;
		k = new Integer[CreateFileTest.MAX];
		try {
			fr = new FileReader(new File("src/com/hung/sort/test.txt"));
			br = new BufferedReader(fr);
			String line = br.readLine();
			int i=0;
			while(!line.equals("")) {
				k[i]=Integer.parseInt(line.trim());
				i++;
				line = br.readLine();
			}
			
			/*
			 * TODO call function sort
			 * */
			//----------------------------
			
			//FunctionSort();
			//SelectionSort();
			//BubbleSort();
			//InsertionSort();
			//InsertSortwithBinarySearching();
			//ShellSort();
			//QuickSort();
			//HeapSort();
			MergeSort();
			
			//----------------------------
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//--------------------------------------------------------------------------------
	
	static void FunctionSort() {
		long timeStart = System.currentTimeMillis();
		System.out.println("Sorting..." + timeStart);
		Arrays.sort(k);
		long timeEnd = System.currentTimeMillis();
		System.out.println("Sorted!" + timeEnd);
		WriteResult(k, (timeEnd-timeStart), "FunctionSort");
	}
	
	//--------------------------------------------------------------------------------
	
	static void SelectionSort() {
		long timeStart = System.currentTimeMillis();
		System.out.println("Sorting..." + timeStart);
		int n = k.length;
		int jMin;
		for(int i=0; i<n-1; i++ ) {
			jMin = i;
			for(int j=i+1; j<n; j++) {
				if(k[j]<k[jMin]) jMin=j;
			}
			if(jMin!=i) {
				int temp = k[i];
				k[i]=k[jMin];
				k[jMin]=temp;
			}
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("Sorted!" + timeEnd);
		WriteResult(k, (timeEnd-timeStart), "SelectionSort");
	}
	
	//--------------------------------------------------------------------------------
	
	static void BubbleSort() {
		long timeStart = System.currentTimeMillis();
		System.out.println("Sorting..." + timeStart);
		int n = k.length;
		for(int i=1; i<n; i++) {
			for(int j=n-1; j>=i; j--) {
				if(k[j]<k[j-1]) {
					int temp = k[j];
					k[j]=k[j-1];
					k[j-1]=temp;
				}
			}
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("Sorted!" + timeEnd);
		WriteResult(k, (timeEnd-timeStart), "BubbleSort");
	}
	
	//--------------------------------------------------------------------------------
	
	static void InsertionSort() {
		
		long timeStart = System.currentTimeMillis();
		System.out.println("Sorting..." + timeStart);
		int n = k.length;
		int tmp;
		for(int i=1; i<n; i++) {
			tmp = k[i];
			int j=i-1;
			while((j>=0) && (tmp<k[j])) {
				k[j+1]=k[j];
				j=j-1;
			}
			k[j+1]=tmp;
		}
		
		long timeEnd = System.currentTimeMillis();
		System.out.println("Sorted!" + timeEnd);
		WriteResult(k, (timeEnd-timeStart), "InsertionSort");
	}
	
	//--------------------------------------------------------------------------------
	
	static void InsertSortwithBinarySearching() {
		
		long timeStart = System.currentTimeMillis();
		System.out.println("Sorting..." + timeStart);
		int n = k.length;
		int tmp, inf, sup, median;
		for(int i=1; i<n; i++) {
			tmp=k[i];
			inf=0;
			sup=i-1;
			do {
				median = (inf+sup)/2;
				if(tmp<k[median]) {
					sup=median-1;
				}
				else {
					inf=median+1;
				}
			}while(inf<=sup);
			for(int j=i; j>inf; j--) {
				k[j]=k[j-1];
			}
			k[inf]=tmp;
		}
		
		long timeEnd = System.currentTimeMillis();
		System.out.println("Sorted!" + timeEnd);
		WriteResult(k, (timeEnd-timeStart), "InsertionSortwithBinarySearching");
	}
	
	//--------------------------------------------------------------------------------
	
	static void ShellSort() {
	
		long timeStart = System.currentTimeMillis();
		System.out.println("Sorting..." + timeStart);
		int h, tmp;
		int n = k.length;
		h=n/2;
		while(h!=0) {
			for(int i=h; i<n; i++) {
				tmp = k[i];
				int j=i-h;
				while((j>=0) && (k[j]>tmp)) {
					k[j+h] = k[j];
					j=j-h;
				}
				k[j+h]=tmp;
			}
			h=h/2;
		}
		
		long timeEnd = System.currentTimeMillis();
		System.out.println("Sorted!" + timeEnd);
		WriteResult(k, (timeEnd-timeStart), "ShellSort");
		
	}
	
	//--------------------------------------------------------------------------------
	
	
	static void QuickSort() {
		long timeStart = System.currentTimeMillis();
		System.out.println("Sorting..." + timeStart);
		partition(0, k.length-1);
		long timeEnd = System.currentTimeMillis();
		System.out.println("Sorted!" + timeEnd);
		WriteResult(k, (timeEnd-timeStart), "QuickSort");
		
	}
	
	static void partition(int L, int H) {
		int pivot;
		if(L>H) return;
		pivot = k[(int) (Math.random()*(H-L)+L)];
		int i=L;
		int j=H;
		do {
			while(k[i] < pivot) {
				i=i+1;
			}
			while(k[j] > pivot) {
				j=j-1;
			}
			
			if(i<=j) {
				if(i<j) {
					int temp = k[i];
					k[i] = k[j];
					k[j] = temp;
				}
				i=i+1;
				j=j-1;
			}
		}while(i<=j);
		partition(L, j);
		partition(i, H);
	}
	
	//--------------------------------------------------------------------------------
	
	static void HeapSort() {
		long timeStart = System.currentTimeMillis();
		System.out.println("Sorting..." + timeStart);
		
		int n= k.length;
		for(int r=n/2-1; r>=0; r--) Adjust(r, n-1);
		for(int i=n-1; i>0; i--) {
			int temp = k[0];
			k[0]=k[i];
			k[i]=temp;
			Adjust(0, i-1);
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("Sorted!" + timeEnd);
		WriteResult(k, (timeEnd-timeStart), "HeapSort");
	}
	
	static void Adjust(int root, int endnode) {
		int c, key;
		key = k[root];
		while((root*2)<endnode) {
			c=root*2;
			if(c<endnode && k[c]<k[c+1]) c++;
			if(k[c]<=key) break;
			k[root] = k[c];
			root=c;
		}
		k[root]=key;
	}
	
	//--------------------------------------------------------------------------------
	
	static void MergeSort() {
		long timeStart = System.currentTimeMillis();
		System.out.println("Sorting..." + timeStart);
		Comparator<Integer> comparator = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1>o2) return 1;
				else
					if(o1<o2) return -1;
					else return 0;
			}
		};
		
		Integer[] k2 = doMergeSort(k, comparator);
		long timeEnd = System.currentTimeMillis();
		System.out.println("Sorted!  " + timeEnd);
		WriteResult(k2, (timeEnd-timeStart), "MergeSort");
	}
	
	
	public static <K> K[] doMergeSort(K[] arrayNeedToSort, Comparator<K> comparator) {
		int n = arrayNeedToSort.length;
		if (n < 2) {
			return arrayNeedToSort;
		}
 
		int middle = n / 2;
 
		K[] subArrayFirst = Arrays.copyOfRange(arrayNeedToSort, 0, middle);
		K[] sortedSubArrayFirst = doMergeSort(subArrayFirst, comparator);
 
		K[] subArrayLast = Arrays.copyOfRange(arrayNeedToSort, middle, n);
		K[] sortedSubArraySecond = doMergeSort(subArrayLast, comparator);
 
		return merge(sortedSubArrayFirst, sortedSubArraySecond, comparator);
	}
 
	private static <K> K[] merge(K[] sortedSubArrayFirst, K[] sortedSubArraySecond, Comparator<K> comparator) {
		int n = sortedSubArrayFirst.length + sortedSubArraySecond.length;
 
		@SuppressWarnings("unchecked")
		K[] sortedArray = (K[]) Array.newInstance(sortedSubArrayFirst[0].getClass(), n);
 
		int i = 0;
		int j = 0;
		for (int k = 0; k < n; k++) {
			if (j == sortedSubArraySecond.length || (i < sortedSubArrayFirst.length
				&& comparator.compare(sortedSubArrayFirst[i], sortedSubArraySecond[j]) < 1)) {
				sortedArray[k] = sortedSubArrayFirst[i++];
			} else {
				sortedArray[k] = sortedSubArraySecond[j++];
			}
		}
 
		return sortedArray;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 	static void WriteResult(Integer[] k, long executionTime, String nameAlgorithm) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			String path = "src/com/hung/sort/result"+ nameAlgorithm+".txt";
			fw = new FileWriter(new File(path));
			bw = new BufferedWriter(fw);
			bw.write("Algorithm: " + nameAlgorithm);
			bw.newLine();
			bw.write("Execution Time: "+ executionTime + " milliseconds");
			bw.newLine();
			for(int i=0; i<k.length; i++) {
				bw.write(k[i]+"");
				bw.newLine();;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
