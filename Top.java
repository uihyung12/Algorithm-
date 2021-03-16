package com.java.practice;

import java.util.Scanner;

public class Top {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] data = new int[500500];
		for(int i = 1 ; i<=n ; i++) {
			data[i] = sc.nextInt();
		}
		
		int[] myStack = new int[500500];
		int index = 1;
		System.out.printf("%d ",0);
		myStack[index] = data[1];
		int which = 2;
		int result = 1;
		while(true) {
			
			if(which>n) {
				break;
			}
			
			if(myStack[index] >= data[which]) {
				System.out.printf("%d ",result);
				myStack[++index] = data[which++];
				result = index;
				
			}else {
				result = index;
				myStack[index--] = 0;
			}
			
			if(index == 0) {
				result = which;
				myStack[++index] = data[which++];
				System.out.printf("%d ",0);
			}
			
			
			
		}
		
		
		
		
		
		
	}

}
