package com.java.practice;

import java.util.Scanner;

/**
 *	문제 연속된 부분으로 이루어진 배열에 최대 합을 구하여라 
 *	예제) 1 -2 3 -4 5 -> max = 5	
 *
 */


public class Maximum_sum_of_consecutive_parts1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int[] data = new int[110];
		
		for(int i = 0 ; i<n ; i++) {
			data[i] = sc.nextInt();			
		}
		
		//start~n O(n)
		//end~n O(n)
		//sum O(n)
		//max O(1)
		
		int max = -987987987;
		for(int start = 0 ; start<n ; start++) {
			for(int end = start ; end<n ; end++) {
				int mySum = 0;
				
				for(int k = start ; k<=end ; k++) {
					mySum += data[k];
				}
				
				if(mySum>max) {
					max = mySum;
				}
			}
		}
		
		System.out.println(max);

	}

}
