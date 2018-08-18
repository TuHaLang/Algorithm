package com.hung.recursive;

public class HanoiTower {

	public static void main(String[] args) {
		Solve(3, 'A', 'B', 'C');
		Solve1(6, 4);
		System.out.println(Solve2(3, 5));
	}
	
	static void Solve(int n, char a, char b, char c) {
		if(n==1) System.out.println("move: " + a + "  -->  " + b);
		else {
			Solve(n-1, a, c, b);
			Solve(1, a, b, c);
			Solve(n-1, c, b, a);
		}
	}
	
	//UCLN
	static void Solve1(int n, int m) {
		if(m==n) System.out.println("UCLN = " + m);
		else {
			if(m>n) Solve1(n, m-n);
			else Solve1(n-m,m);
		}
	}
	
	//Tổ hợp
	static int Solve2(int k, int n) {
		if(n==k || k==0) return 1;
		else return Solve2(k-1, n-1) + Solve2(k, n-1);
	}
	

}
