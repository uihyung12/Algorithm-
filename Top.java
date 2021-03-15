package com.java.practice;

import java.util.Scanner;

public class Top {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] data = new int[500500];
		int[] myStack = new int[500500];
		boolean[] check = new boolean[500500];
		for(int i = 0 ; i<n ; i++) {
			data[i] = sc.nextInt();
		}
		
		int max = 0;
		int index = 0;
		int cursor = 0;
		int result = 0;
		System.out.printf("%d ",0);
		myStack[cursor++] = data[index++];
		result = cursor;
		while(true) {
			
			if(check[n-1]) {
				break;
			}
			
			if(myStack[cursor-1]>=data[index]) {
				System.out.printf("%d ",result);
				myStack[cursor++] = data[index++];
				result = cursor;
			}else {
				if(cursor>0) {
					myStack[--cursor] = 0;					
					check[cursor] = true;
				}
				
				
			}
			
			if(cursor == 0) {
				for(int i = 0 ; i<n ; i++) {
					if(!check[i]) {
						check[i] = true;
						index = i+1;
						myStack[cursor++] = data[i];
						result = i+1;
						System.out.printf("%d ",0);
					}
				}
			}
			
			
		}
		
		
		
		
	}

}
