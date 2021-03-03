package edu.java.algorithm;

import java.util.Scanner;

public class binarySearch {
	
	/**
	 * 문제 : n개의 오름차순으로 정렬된 숫자가 주어지고, 그 후 q개의 질문이 주어진다. 
	 * 각각의 질문은 특정 숫자가 n개의 숫자 내에 존재하는지를 판별하는 것이다. 
	 * 모든 q개의 질문에 대하여 답을 하는 프로그램을 작성하시오.
	 * 
	 * 입력 : 첫 번째 줄에 숫자의 개수 n, 그리고 질문의 개수 q가 주어진다 ( 1 ≤ n ≤ 100,000, 1 ≤ q ≤ 100,000) 
	 * 이는 오름차순으로 정렬되어 주어진다.
	 *  두 번째 줄에 n개의 숫자가 주어진다. 
	 *  세 번째 줄에 q개의 질문이 주어진다. 
	 *  각 수는 21억보다 작은 정수다.  
	 * 
	 *  출력 : 각 질문에 대하여 숫자가 존재하면 YES, 아니면 NO를 한 줄에 하나씩 출력한다.
	 */
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] data = new int[100100];
		
		for(int i = 0 ; i<n ; i++) {
			data[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i<k ; i++) {
			int a = sc.nextInt();
			
			int start = 0;
			int end = n-1;
			int mid = (start+end)/2;
			boolean flag = false;
			if(data[mid] == a) flag = true;
			if(data[start] == a) flag = true;
			if(data[end] == a) flag = true;
			while(start+1<end) {
				if(data[mid] == a) {
					flag = true;
					break;
				}else if(data[mid]>a) {
					end = mid;
					mid = (start+end)/2;
				}else if(data[mid]<a) {
					start = mid;
					mid = (start+end)/2;
				}
				
			}
			
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		
		
		
	}

}
