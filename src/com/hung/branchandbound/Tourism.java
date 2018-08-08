package com.hung.branchandbound;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Tourism {
	
	//the max amount of city
	final static int MAX=20;
	
	//the max cost, considered by infinity
	final static int MAXC= MAX*100+1;
	
	//moving expenses between the two cities
	static int [][] c = new int[MAX][MAX];
	
	//the way to move
	static int [] x = new int[MAX+1];
	
	//the best direction move
	static int [] bestWay = new int[MAX+1];
	
	//the cost when went through i city
	static int [] t = new int[MAX+1];
	
	//check the city arrived through
	static boolean[] arrived = new boolean[MAX];
	
	//amount city
	static int n=0;
	
	//amount the way to move
	static int m=0;
	
	//the min cost for way to move
	static int minCost=0;
	
	
	
	public static void main(String[] args) {
		getData();
		init();
		solve(1);
		print();
	}
	
	// A utility function to get data from file and assign for variables
	private static void getData() {
		BufferedReader br = null;
		FileReader fr = null;
		File file = new File("src/com/hung/branchandbound/testTourism.txt");
	
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = br.readLine().trim();
			String[] arrString = line.split("\\s+");
			n = Integer.parseInt(arrString[0].trim());
			m = Integer.parseInt(arrString[1].trim());
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(i==j) c[i][j]=0;
					else c[i][j] = MAXC;
				}
			}

			for(int k=0; k<m; k++) {
				line = br.readLine().trim();
				arrString = line.split("\\s+");
				int i = Integer.parseInt(arrString[0].trim())-1;
				int j = Integer.parseInt(arrString[1].trim())-1;
				int cost = Integer.parseInt(arrString[2].trim());
				c[i][j] = cost;
				c[j][i] = cost;
			}
			
			
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
	
	// A utility function to Initialize the start values ​​for variables 
	private static void init() {
		Arrays.fill(arrived, false);
		arrived[0]=true;
		x[0]=0;
		t[0]=0;
		minCost = MAXC;
	}
	
	// A utility function to solve solution
	private static void solve(int i) {
		for(int j=0; j<n; j++) //check all cities
		{
			if(!arrived[j]) //check have arrived the city?
			{
				x[i]=j;
				t[i]=t[i-1] + c[x[i-1]][x[i]];
				
				if(t[i] < minCost) //check is this cost less than minCost? 
				{
					if(i < n-1) //check have gone through all the city yet?
					{
						arrived[j]=true; //mark is arrived
						solve(i+1); // backtracking
						arrived[j]=false; //unmarked
					}
					else 
					{
						if((t[i] + c[x[i]][0]) < minCost) //check is this cost less than minCost? 
						{
							bestWay=x.clone(); //assign value for betWay
							minCost = t[i] + c[x[i]][0]; //sum cost from city n-1 to 0
						}
					}
				}
			}
		}
	}
	
	// A utility function to print result
	private static void print() {
		for(int i=0; i<n-1; i++) {
			System.out.print(bestWay[i] + " --> ");
		}
		System.out.print(bestWay[n-1] + " --> 0");
		System.out.println("\nCost = " + minCost);
	}
}
