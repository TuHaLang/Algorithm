package com.hung.branchandbound;

public class Parentheses {
	// 0<=>) 1<=>(
	final static int MAX = 100;
	static int n = 10;
	static int deep = 3;

	static int[] parenthese = new int[MAX];

	public static void main(String[] args) {
		if(n<2*deep) {
			System.out.println("can't");
			return;
		}
		Try(0);
	}

	static boolean checkRegular(int i) {
		int open = 0, close = 0;
		for (int j = 0; j < i + 1; j++) {
			if (parenthese[j] == 0)
				close++;
			if (parenthese[j] == 1)
				open++;
		}
		if (open >= close && open <= n / 2)
			return true;
		else
			return false;
	}

	static int countDeep(int i) {
		int countOpen = 0;
		int countClose = 0;
		int curDeep = 0;
		for (int j = 0; j <= i; j++) {
			if (parenthese[j] == 1) {
				countOpen++;
				if(i==j) {
					if (countOpen > curDeep) {
						curDeep = countOpen;
					}
				}
			} else {
				if (countOpen > curDeep) {
					curDeep = countOpen;
					countOpen = 0;
				} else {
					countOpen = 0;
				}
			}
		}
		for (int j = 0; j <= i; j++) {
			if (parenthese[j] == 0) {
				countClose++;
				if(i==j) {
					if (countClose > curDeep) {
						curDeep = countClose;
					}
				}
			} else {
				if (countClose > curDeep) {
					curDeep = countClose;
					countClose = 0;
				} else {
					countClose = 0;
				}
			}
		}
		return curDeep;
	}

	static void Try(int i) {

		if (i == 0) {
			parenthese[0] = 1;
			Try(i + 1);
		} else {
			if (i == n - 1) {
				parenthese[n - 1] = 0;
				if (countDeep(i) == deep)
					print();
			} else {
				for (int j = 0; j < 2; j++) {
					parenthese[i] = j;
					if (checkRegular(i)) {
						if (countDeep(i) <= deep)
							Try(i + 1);
					}
				}
			}
		}

	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(parenthese[i] == 0 ? " ) " : " ( ");
		}
		System.out.println();
	}
}
