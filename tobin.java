package com.java.practice;

import java.util.Scanner;

public class tobin {

	static int n,k;
	static int[] data = new int[35];
	static boolean[] check = new boolean[35];
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		if(k==0) {
			for(int i = 0 ; i<n ; i++) {
				System.out.print(data[i]);
			}
			return;
		}
		
		
		getResult(0,n,1);
		

	}
	
	private static void getResult(int start, int end, int s1) {
		if(start>=end) {
			if(cnt == k) {
				for(int i = 0 ; i<end ; i++) {
					System.out.print(data[i]);
				}
				System.out.println();
				
			}
			
		}else {
			for(int i = s1 ; i>=0 ; i--) {
				data[start] = i;
				if(cnt<k) {
					if(i==1) {
						cnt++;
						check[start] = true;
					}
				}
				
				if(cnt>=k) {
					getResult(start+1,end,0);//2.start(1):(2,3,0),3.start(2):(3,3,0),6.start(2):(3,3,0)
				}else {
					getResult(start+1,end,1);//1.start(0):(1,3,1),5.start(1):(2,3,1)
				}
				check[start] = false;
				
				cnt--;
			}
			
		}
	}
	

}
