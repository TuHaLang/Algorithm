package com.hung.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
	
	final static int MAX = 100;
	static int[][] c = new int[MAX][MAX];
	static int n,m,start,end;
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[] arrived = new boolean[MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<MAX; i++) {
			Arrays.fill(c[i], 0);
		}
		Arrays.fill(arrived, false);
		try {
			getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arrived[start]=true;
		list.add(start);
		Solve(start);
		System.out.println("From 1 you can visit: ");
		for(int x : list) {
			System.out.print(x + "    ");
		}
		System.out.println("\nThe path from 1 to 5: ");
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i)==5) {
				System.out.print("5");
				break;
			}
			else {
				System.out.print(list.get(i) + " -> ");
			}
		}
	}
	
	private static void Solve(int i) {
		for(int j=1; j<=n; j++) {
			if(!arrived[j] && c[i][j]==1) {
				list.add(j);
				arrived[j]=true;
				Solve(j);
			}
		}
	}

	static void getData() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		
		fr = new FileReader(new File("src/com/hung/graph/testDFS.txt"));
		br = new BufferedReader(fr);
		
		String line = br.readLine(); 
		String[] arrNum = line.split("\\s+");
		
		n = Integer.parseInt(arrNum[0]);
		m = Integer.parseInt(arrNum[1]);
		start = Integer.parseInt(arrNum[2]);
		end = Integer.parseInt(arrNum[3]);
		
		line = br.readLine();
		while(line != null) {
			arrNum = line.split("\\s+");
			int i = Integer.parseInt(arrNum[0]);
			int j = Integer.parseInt(arrNum[1]);
			c[i][j]=1;
			line = br.readLine();
		}
	}

}
