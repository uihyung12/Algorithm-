package com.java.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree_cutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int label = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		long end = 0;
		
		for(int i = 0 ; i<n ; i++) {
			list.add(sc.nextInt());
			if(end<list.get(i)) end = list.get(i);
		}
		
		
		long start = 1;
		long result = 0;
		while(start+1<end) {
			long mid = (start+end)/2;
			long sum = 0;
			for(int i = 0 ; i<n ; i++) {
				if(list.get(i)-mid>0) {
					sum += list.get(i)-mid;
				}
				
			}
			
			if(sum>=label) {
				if(mid>result) result = mid;
				
				
				start = mid;
			}else {
				end = mid;
				
			}			
			
		}
		
		System.out.println(result);
		
		

	}

}
