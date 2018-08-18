package com.hung.stackandqueue;

import java.util.LinkedList;
import java.util.Stack;

public class SwitchBase {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Swicth(243435.4375,16);
	}
	
	static void Swicth(double g, int R) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		int integer;
		double balance;
		
		integer = (int) g/1;
		balance = g%1;
		
		//switch a part integer
		while(integer != 0) {
			stack.push(integer % R);
			integer = integer / R;
		}
		//switch a part balance
		while(balance != 0) {
			queue.add((int)(balance*R)/1);
			balance = (balance*R)%1;
		}
		
		//print result
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			if(temp<10) {
				System.out.print(temp);
			}
			else {
				switch (temp) {
				case 10:
					System.out.print("A");
					break;
				case 11:
					System.out.print("B");
					break;
				case 12:
					System.out.print("C");
					break;
				case 13:
					System.out.print("D");
					break;
				case 14:
					System.out.print("E");
					break;
				case 15:
					System.out.print("F");
					break;
				}
			}
			
		}
		System.out.print(".");
		while(!queue.isEmpty()) {
			int temp = queue.get(0);
			queue.remove(0);
			if(temp<10) {
				System.out.print(temp);
			}
			else {
				switch (temp) {
				case 10:
					System.out.print("A");
					break;
				case 11:
					System.out.print("B");
					break;
				case 12:
					System.out.print("C");
					break;
				case 13:
					System.out.print("D");
					break;
				case 14:
					System.out.print("E");
					break;
				case 15:
					System.out.print("F");
					break;
				}
			}
		}
	}

}
