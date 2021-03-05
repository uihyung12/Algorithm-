package com.java.practice;

import java.util.Scanner;

public class tobin2 {
	static int n,k;
	static int[] data = new int[35];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		getResult(0,0);

	}
	
	
	static void getResult(int x, int y) {
		if(x>=n) {
			if(y==k) {
				for(int i = 0 ; i<n ; i++) {
					System.out.print(data[i]);
				}
				System.out.println();
			}
		}else {
			if(y<k) {
				data[x] = 1;
				getResult(x+1,y+1);
			}
			data[x] = 0;
			getResult(x+1,y);
		}
		
	}

}
