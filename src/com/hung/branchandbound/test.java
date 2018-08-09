package com.hung.branchandbound;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] parenthese = {1,1,0,1,1,0,0,0};
		System.out.println(countDeep(parenthese));
	}
	static int countDeep(int[] parenthese) {
		int i=7;
		int countOpen=0;
		int countClose=0;
		int curDeep=0;
		for(int j=0; j<=i; j++) {
			if(parenthese[j]==1) {
				countOpen++;
			}else {
				if(countOpen>curDeep) {
					curDeep=countOpen;
					
					countOpen=0;
				}
				else countOpen=0;
			}
		}
		for(int j=0; j<=i; j++) {
			if(parenthese[j]==0) {
				countClose++;
				if(i==j) {
					if (countClose > curDeep) {
						curDeep = countClose;
					}
				}
			}else {
				if(countClose>curDeep ) {
					curDeep=countClose;
					
					countClose=0;
				}
				else countClose=0;
			}
		}
		return curDeep;
	}
}
