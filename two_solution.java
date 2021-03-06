package com.java.practice;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * 다시 풀어볼 문제 두 용액 문제
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
		
		int countA = 0, countB = 0;
		
		int min = 987987987;
		for(int i = 0 ; i<n ; i++) {
			index = i;
			int number = getResult(list.get(i));
			
			int result;
			if(list.get(i)<0) {
				result = Math.abs(number+list.get(i));
			}else {
				result = Math.abs(list.get(i)-number);
			}
			System.out.printf("result : %d \n",result);
			if(result<=min) {
				min = result;
				
				countA = list.get(i);
				countB = number;
				
				if(countA<a || countB <b) {
					a = countA;
					b = countB;
				}
				
			}
			
			
		}
		
		System.out.println(min);

	}
	
	public static int getResult(int label) {
		
		
		
		return 0;
	}
	
	
		
		
		
		
	

}
