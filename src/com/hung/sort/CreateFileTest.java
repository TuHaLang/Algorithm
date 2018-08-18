package com.hung.sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileTest {
	
	public static final int MAX = 1000000;

	public static void main(String[] args) {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File("src/com/hung/sort/test.txt"));
			bw = new BufferedWriter(fw);
			for(int i=0; i<MAX; i++) {
				String strNum = (int)(Math.random()*100000000) +"";
				bw.write(strNum);
				bw.newLine();
			}
			bw.newLine();
			System.out.println("successful!");
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
