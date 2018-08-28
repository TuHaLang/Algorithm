package com.hung.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Interconnection {
	
	final static int MAX = 30;
	static int n;
	static int m;
	static int[][] c = new int[MAX][MAX];
	static int[] p = new int[MAX];

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(new File("src/com/hung/graph/test.txt"));
			br = new BufferedReader(fr);
			String line = br.readLine();
			String[] strNum = line.split("\\s+");
			n = Integer.parseInt(strNum[0]);
			m = Integer.parseInt(strNum[1]);
			System.out.println(n+"    "+m);
			for(int i=0; i< MAX; i++){
				Arrays.fill(c[i], 0);
			}
			line = br.readLine();
			while(line != null) {
				strNum = line.split("\\s+");
				for(int i=0; i<strNum.length; i=i+2) {
					int x = Integer.parseInt(strNum[i]);
					int y = Integer.parseInt(strNum[i+1]);
					c[x][y]=1;
				}
				line = br.readLine();
			}
			for(int i=1; i<=n; i++) {
				System.out.print("Line "+i+" :  ");
				for(int j=1; j<=n; j++) {
					System.out.print(c[i][j] + "    ");
				}
				System.out.println();
			}
			
			Arrays.fill(p, 0);
			
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
	
	static void Try(int i) {
		for(int j=1; j<=n; j++) {
			//if(c[i][j]==1 && )
		}
	}
}
