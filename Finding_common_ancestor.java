package com.java.practice;

import java.util.Scanner;

public class Finding_common_ancestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] data = new int[1010];
		boolean[] check = new boolean[1010];
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		for(int i = 0 ; i<n-1 ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			data[b] = a;
		}
		
		int index = data[x];
		check[x] = true;
		while(true) {
			
			
			if(!check[index]) {
				check[index] = true;
				index = data[index];
				if(check[0]) {
					break;
				}
			}
			
		}
		
		int yIndex = data[y];
		if(check[y]) {
			System.out.println(y);
			return;
		}
		while(true) {
			
			if(check[yIndex]) {
				System.out.println(yIndex);
				break;
			}else {
				check[yIndex] = true;
				yIndex = data[yIndex];
				
			}
			
			
		}
		

	}

}
