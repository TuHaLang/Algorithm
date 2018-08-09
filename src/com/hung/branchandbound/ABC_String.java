package com.hung.branchandbound;

public class ABC_String {
	
	final static int MAX = 100;
	static int n=10, minC;
	static char[] x = new char[MAX];
	static char[] best = new char[MAX];
	static int[] t = new int[MAX];
	
	static boolean Same(int i, int l) {
		int j=i-l;
		for(int k=0; k<l; k++) {
			if(x[i-k]!=x[j-k]) return false;
		}
		return true;
	}
	
	static boolean Check(int i) {
		for(int l=1; l<=i/2; l++) {
			if(Same(i,l)) return false;
		}
		return true;
	}
	
	static void KeepResult() {
		minC = t[n];
		best=x.clone();
	}
	
	static void Try(int i) {
		for(char j='a'; j<='c'; j++) {
			x[i]=j;
			if(Check(i)) {
				if(j=='c') {
					t[i]=t[i-1]+1;
				}
				else {
					t[i]=t[i-1];
				}
				if((t[i]+(int)(n-i)/4) < minC) {
					if(i==n) KeepResult();
					else Try(i+1);
				}
			}
		}
	}
	
	static void printResult() {
		for(int i=1; i<=n; i++) {
			System.out.print(best[i]);
		}
		System.out.println("\n\"C\" Letter Count: " + minC);
	}
	
	public static void main(String[] args) {
		t[0]=0;
		minC=n;
		Try(1);
		printResult();
	}

}
