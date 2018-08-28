package com.hung.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class BFS {
	
	final static int MAX = 100;
	static int n,m,start,end;
	static int[][] c = new int[MAX][MAX];
	static int[] list = new int[MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			getData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Solve();
		System.out.println("From 1 yout can visit: ");
		for(int i=1;i<=n; i++) {
			if(list[i]!=0) System.out.print(i+"    ");
		}
		System.out.println("\nThe path from 1 to 5 :");
		int f = list[end];
		System.out.print("5 -> ");
		while(f!=start) {
			System.out.print(f + " -> ");
			f=list[f];
		}
		System.out.print(1);
	}
	
	static void Solve() {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(start);
		Arrays.fill(list, 0, n+1, 0);
		list[start] =-1;
		do {
			int u = queue.poll();
			for(int v=1; v<=n; v++) {
				if(c[u][v]==1 && list[v]==0) {
					queue.add(v);
					list[v]=u;
				}
			}
		}
		while(queue.size()!=0);
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
			c[i][j]=c[j][i]=1;
			line = br.readLine();
		}
	}
}
