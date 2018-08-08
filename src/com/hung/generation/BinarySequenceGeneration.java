package com.hung.generation;

import java.util.Scanner;

/*-----Describe algorithm-----
 * A binary sequence of length n is a array x[1..n] in which x[i]=0 or 1;
 * So, the first sequence will be 00...0 and finally the sequence 11...1
 * We will start in last index of sequence and finish index of sequence
 * Finding the first number 0 and replace it by number 1(if found it)
 * if not found, all index of sequence is 1 and it is the finally sequence. 
 * */



public class BinarySequenceGeneration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = scanner.nextInt();
		SequenceGeneration(n);
		scanner.close();
	}
	
	public static StringBuilder SequenceGeneration(int n) {
		StringBuilder binarySequence = new StringBuilder();
		StringBuilder firstConfiguration = FirstConfiguration(n);
		StringBuilder finallyConfiguration = FinallyConfiguration(n);
		binarySequence.append(firstConfiguration);
		
		//display first configuration
		System.out.println(firstConfiguration);
		
		int i=n-1;
		
		while(!firstConfiguration.equals(finallyConfiguration)) //when first configuration not same as finally configuration 
		{
			if(firstConfiguration.charAt(i) == '0') 
			{
				firstConfiguration.setCharAt(i, '1');
				for(int j=i+1; j<n; j++) 
				{
					firstConfiguration.setCharAt(j, '0');
				}
				System.out.println(firstConfiguration);
				i=n-1;
			}
			else 
			{
				if(i!=0) i--;
			}
		}
		return binarySequence;
	}

	//first configuration as same as 00...0
	public static StringBuilder FirstConfiguration(int n) {
		StringBuilder s = new StringBuilder();
		for(int i=0; i<n; i++) {
			s.append('0');
		}
		return s;
	}
	
	//finally configuration as same as 11...1
	public static StringBuilder FinallyConfiguration(int n) {
		StringBuilder s = new StringBuilder();
		for(int i=0; i<n; i++) {
			s.append('1');
		}
		return s;
	}
	
	
}
