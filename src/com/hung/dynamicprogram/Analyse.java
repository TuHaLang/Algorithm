package com.hung.dynamicprogram;

import java.util.Arrays;

public class Analyse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MAX = 1000;
		int n=100;
		long[][] F = new long[MAX][MAX];
		Arrays.fill(F[0], 0);
		F[0][0]=1;
		for(int m=1; m<=n; m++ ) {
			for(int v=0; v<=n; v++) {
				if(v<m) F[m][v] = F[m-1][v];
				else F[m][v]=F[m-1][v]+F[m][v-m];
			}
		}
		System.out.println(F[n][n]);
	}

}
