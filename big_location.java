package com.java.practice;

import java.util.Scanner;

public class big_location {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String num1 = sc.next();
		int[] first = new int[105];
		for(int i = 0 ; i<num1.length() ; i++) {
			first[104-num1.length()+i+1] = num1.charAt(i) - '0';
		}
		
		String num2 = sc.next();
		int[] second = new int[105];
		for(int i = 0 ; i<num2.length() ; i++) {
			second[104-num2.length()+i+1] = num2.charAt(i) - '0';
		}
		
		int[] result = new int[220];
		int index = 219;
		for(int i = 104 ; i>104-num1.length() ; i--) {
			int localIndex = index;
			for(int j = 104 ; j>104-num2.length() ; j--) {
				if(first[i]*second[j]>=10) {
					result[localIndex] += first[i]*second[j]%10;
					if(result[localIndex]>=10) {
						result[localIndex-1]+=result[localIndex]/10;
						result[localIndex] %=10;
						
					}
					result[localIndex-1] += first[i]*second[j] / 10;
					if(result[localIndex-1]>=10) {
						result[localIndex-2] += result[localIndex-1]/10;
						result[localIndex-1] %= 10;
					}					
				}else {
					result[localIndex] += first[i]*second[j];
					if(result[localIndex] >= 10) {
						result[localIndex-1] += result[localIndex]/10;
						result[localIndex] %=10;
					}
				}
				localIndex--;
			}
			index--;
		}
		
		for(int i = 0 ; i<220 ; i++) {
			boolean flag = false;
			if(result[i] != 0) {
				for(int j = i ; j<220 ; j++) {
					System.out.print(result[j]);
				}
				flag = true;
			}
			if(flag) break;
		}
		

	}

}
