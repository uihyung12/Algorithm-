package com.java.practice;

import java.util.Scanner;

/**
 *	문제 : N개의 정수가 주어질 때, 연속된 부분을 선택하여 합을 최대화 하는 프로그램을 작성하시오. 
 *	예를 들어, 아래와 같이 8개의 숫자가 있을 경우, 색칠된 부분을 선택했을 때 그 합이 가장 최대가 된다. 
 *	입력 : 첫 번째 줄에 n이 주어진다. ( 1 ≤ n ≤ 100,000 ) 두 번째 줄에 n개의 정수가 주어진다.
 *	출력 : 연속된 부분을 선택하였을 때의 최댓값을 출력한다.
 *	예제 : 8
		 2 3 -5 8 -3 4 2 -9
 *	출력 : 11
 */

public class Maximum_sum_of_consecutive_parts_divide_and_conquer {
	
	static int[] data = new int[100100];
	static int n;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i = 0 ; i<n ; i++) {
			data[i] = sc.nextInt();
		}
		
		System.out.println(getResult(0,n-1));

	}
	
	static int getResult(int start, int end) {
		if(start>=end) {
			return data[start];
		}else {
			int mid = (start+end)/2;
			
			int left = getResult(start,mid);
			int right = getResult(mid+1,end);
			
			int leftSum = 0, leftMax = -987987987;
			for(int i = mid ; i>=start ; i--) {
				leftSum = leftSum+data[i];
				if(leftSum>leftMax) leftMax = leftSum;
				
			}
			int rightSum = 0, rightMax = -987987987;
			for(int i = mid+1 ; i<=end ; i++) {
				rightSum = rightSum+data[i];
				if(rightSum>rightMax) rightMax = rightSum;
			}
			
			
			int midMax = leftMax+rightMax;
			
			if(left>=right && left>=midMax) return left;
			else if(right>=left && right>=midMax) return right;
			else return midMax;
			
			
		}
		
		
	}

}
