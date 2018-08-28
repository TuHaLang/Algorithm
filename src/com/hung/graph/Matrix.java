package com.hung.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Matrix {

	static int[] moveX = { 1, -1, 0, 0 };
	static int[] moveY = { 0, 0, 1, -1 };
	static String positionEnd="";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = loadData();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println("==========================================");
		String position = findPosition(matrix);
		String[][] list = findWay(position, matrix);
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				if (list[i][j].length() <= 2) {

					System.out.print("  " + list[i][j] + "      ");
				} else {

					System.out.print(list[i][j] + "      ");

				}
			}
			System.out.println();
		}
		System.out.print("Way: \n" + positionEnd + " <-- ");
		String[] arrS = positionEnd.split("\\s+");
		int x = Integer.parseInt(arrS[0]);
		int y = Integer.parseInt(arrS[1]);
		while(!list[x][y].equals(position)) {
			System.out.print(list[x][y] + " <-- ");
			arrS = list[x][y].split("\\s+");
			x = Integer.parseInt(arrS[0]);
			y = Integer.parseInt(arrS[1]);
		}
		System.out.print(position);
	}

	static int[][] loadData() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(new File("src/com/hung/graph/matran.txt"));
			br = new BufferedReader(fr);
			String line = br.readLine().trim();
			String[] arrString = line.split("\\s+");
			int n = Integer.parseInt(arrString[0]);
			int m = Integer.parseInt(arrString[1]);
			line = br.readLine();
			int arr[][] = new int[n][m];
			int i = 0;
			while (line != null) {
				arrString = line.split("\\s+");
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(arrString[j]);
				}
				i++;
				line = br.readLine();
			}
			return arr;

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

		return null;
	}

	static String findPosition(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 2)
					return (i + " " + j);
			}
		}
		return null;
	}

	static String[][] findWay(String position, int[][] matrix) {
		String[] arrS = position.split("\\s+");
		int x = Integer.parseInt(arrS[0]);
		int y = Integer.parseInt(arrS[1]);
		String[][] list = new String[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			Arrays.fill(list[i], "0");
		}
		list[x][y] = "-1";
		LinkedList<String> queue = new LinkedList<>();
		queue.add(position);
		do {
			String u = queue.poll();
			arrS = u.split("\\s+");
			for (int v = 0; v < 4; v++) {
				x = Integer.parseInt(arrS[0]);
				y = Integer.parseInt(arrS[1]);
				if(x==0 || y==0 || x==9 || y==9) {
					positionEnd = x+" "+y;
					return list;
				}
				int nextX = x + moveX[v];
				int nextY = y + moveY[v];
				if (nextX >= 0 && nextY >= 0 && nextX < 10 && nextY < 10 && matrix[nextX][nextY] == 1
						&& list[nextX][nextY].equals("0")) {
					queue.add(nextX + " " + nextY);
					list[nextX][nextY] = u;
				}
			}
		} while (queue.size() != 0);
		return list;
	}

}
