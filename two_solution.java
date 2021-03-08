package com.java.practice;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * 다시 풀어볼 문제 두 용액 문제
 * 
 * 예제 ) 5
 * 		-2 4 -99 1 98
 * 
 * 정답) -99 98
 * 
 * 문제 : 두 용액을 혼합하여 가장 0에 가까운 수를 구한다
 *
 */

public class two_solution {
	static int a = 0;
	static int b = 0;
	static int n;
	static ArrayList<Integer> list;
	static int index;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		list = new ArrayList<>();
		n = sc.nextInt();
		for(int i = 0 ; i<n ; i++) {
			int a = sc.nextInt();
			list.add(a);
		}
		
		list.sort(null);
		
		int min = 987987987;
		int countA=999, countB = 999;
		
		
		for(int i = 0 ; i<n ; i++) {
			int number = list.get(i);
			
			int result = Math.abs(number+list.get(i));
			
			if(result<=min) {
				if(min == result) {
					if(countA>number || countA>list.get(i) || countB>number || countB>list.get(i)) {
						countA = number;
						countB = list.get(i);
					}
				}else {
					min = result;					
				}
			}
			
		}
		int[] result = new int[3];
		if(countA<countB) {
			result[0] = countA;
			result[1] = countB;
		}else {
			result[0] = countB;
			result[1] = countA;
		}
		
		for(int i = 0 ; i<2 ; i++) {
			System.out.printf("%d ",result[i]);
		}
		
		System.out.println();
		System.out.println(min);
	}
	
	public static int getResult(int label) {
		label *= -1;
		
		int start = 0;
		int end = n-1;
		
		while(start+1<end) {
			int mid = (start+end)/2;
			
			if(list.get(mid)<=label) {
				start = mid;
			}else {
				end = mid;
			}
			
		}
		
		if(label<0) {
			//label은 +로 전환 그러니 start와 end는 -를 가져옴
			label *= -1;
			int num1 = Math.abs(label+list.get(start));
			int num2 = Math.abs(label+list.get(end));
			
			return (num1<=num2)?list.get(start):list.get(end);
			
		}else {
			//label은 -로 전환되니 start와 end는 -를 가져옴
			label *= -1;
			int num1 = Math.abs(label+list.get(start));
			int num2 = Math.abs(label+list.get(end));
			
			return (num1<=num2)?list.get(start):list.get(end);
			
		}
		
	}
	
	
		
		
		
		
	

}
