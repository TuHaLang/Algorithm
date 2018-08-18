package com.hung.stackandqueue;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CovertInfixtoRPN {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		System.out.println("Enter the expression: ");
		s = new Scanner(System.in).nextLine();
		System.out.println(s);
		LinkedList<String> queue = covert(s);
		while(!queue.isEmpty()) {
			System.out.println(queue.pollFirst());
		}
	}

	private static LinkedList<String> covert(String s) {
		s.replaceAll("\\s+", "");
		Stack<String> stack = new Stack<>();
		LinkedList<String> queue = new LinkedList<>();
		int i=0;
		while(i<s.length()) {
			char ch = s.charAt(i);
			if(!isNumber(ch)) {
				switch (ch) {
				case '(':
					stack.push(ch+"");
					break;
				case ')':
					String x = stack.pop();
					do{
						queue.add(x);
						x = stack.pop();
					}
					while(!x.equals("("));
					break;
				case '+': case '-': case '*': case '/':
					if(!stack.isEmpty() && priority(stack.peek())== priority(ch+"") &&  priority(ch+"")==1) {
						queue.add("0");
					}
					else
						while(!stack.isEmpty() && priority(ch+"")<=priority(stack.peek())) {
							queue.add(stack.pop());
						}
					if(!stack.isEmpty() && stack.peek().equals("(") && !isNumber(queue.getLast().charAt(0))) queue.add("0");
					
					stack.push(ch+"");
					break;
				}
				i++;
			}
			else {
				String strNum = ch +"";
				i++;
				while(i<s.length() && isNumber(s.charAt(i))) {
					strNum += s.charAt(i);
					i++;
				}
				queue.add(strNum);
			}
		}
		while(!stack.isEmpty()) queue.add(stack.pop());
		return queue;
	}
	
	private static boolean isNumber(char ch) {
		return (ch>=48 && ch<=57);
	}
	private static int priority(String ch) {
		if(ch.equals("*") || ch.equals("/")) return 2;
		if(ch.equals("+") || ch.equals("-")) return 1;
		if(ch.equals("(") || ch.equals("")) return 0;
		return -1;
	}

}
