package com.hung.generation;

import java.util.Scanner;

public class ListSubsets {
	
	/*-----Describe algorithm-----
	 * Program which listed the subsets with k element of assemblage {1,2,3,...,n} in the order of the dictionary
	 * So, the first subset is {1,2,3,...,k} and the finally subset is {n-k+1, n-k+2, ..., n}
	 * The upper limit of x[i] = n-k+i and the lower limit of x[i]=x[i-1]+1
	 * So, the technique generate the next subset is:
	 * - Finding from end of sequence to top until see a element not reached the top limit
	 * - if found:
	 * 		+ x[i]++
	 * 		+ x[j]= [the upper limit] with j>i
	 * - if not found: this is the finally subset
	 * */

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number integer which less 10: ");
		int n = input.nextInt();
		System.out.println("Enter a number which is the length of subset: ");
		int k = input.nextInt();
		GetListSubset(n,k);
		input.close();
	
	}

	private static void GetListSubset(int n, int k) {
		StringBuilder subset = fistSubset(n, k);
		
		System.out.println(subset);
		int i=k-1;
		while(true) {
			if(((int) subset.charAt(i)-48) < (n-k+i+1) ) {
				subset.setCharAt(i, (char) ((int)subset.charAt(i)+1));
				for(int j=i+1; j<k; j++) {
					subset.setCharAt(j, (char) ((int)subset.charAt(j-1)+1));
				}
				i=k-1;
				System.out.println(subset);
				
			}
			else {
				if(i>0) i--;
				else break;
			}
		}
	}
	

	
	private static StringBuilder fistSubset(int n, int k) {
		StringBuilder subset = new StringBuilder();
		for(int i=0; i< k; i++) {
			subset.append(i+1);
		}
		return subset;
		
	}

}
