package com.hung.graph;

import java.math.BigInteger;

public class test {
	static int n = 22;
	static int m = 4;
	static int curplus=n;
	static int curPow=1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp=1;
		int k=m;
		
		for(int i=0; i<m;) {
			solve(k);
			temp = (temp*curplus)%100;
			i+=curPow;
			k=m-i;
			curplus=n;
			curPow=1;
		}
		System.out.println(temp);
		test();
		
	}
	
	static int mode(int n, int k){
	    return (int) Math.pow(n,k)%100;
	}
	
	static int maxPow(int temp) {
		return ((int) (Math.log(32768)/Math.log(temp)));
	}

	static void solve(int stop){
	    int maxPow=0;
		if(curPow==1) {
	    	maxPow = maxPow(n);
	    }
		else {
			maxPow = maxPow(curplus);
		}
		if((stop-curPow) < maxPow && curPow==1) {
			curplus = mode(curplus,stop-curPow+1);
			curPow = stop-curPow +1;
			return;
		}
		curPow *=maxPow;
		if(curPow<stop) {
			curplus = mode(curplus,maxPow);
			solve(stop);
		}else {
			curPow/=maxPow;
			if(curPow == stop) {
				curplus = mode(curplus,maxPow);
			}
			
			return;
		}
	}
	
	static void test() {
		BigInteger nn = new BigInteger(n+"");
		BigInteger temp = nn; 
		for(int i=1; i<m; i++) {
			temp = temp.multiply(nn);
		}
		System.out.println(temp);
	}

}
