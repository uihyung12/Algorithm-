package com.java.practice;

import java.util.Scanner;

public class desert_update {
	
	static int n;
	static int[] data;
	static char[] temp;
	static boolean flag = false;
	static int cnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		
		
		getResult(1,n);
		

	}
	
	static void getResult(int start, int end) {
		if(start>end) {
			String[] result = new String[30];
			int sum = 0;
			char[] reason = new char[20];
			int number = 0;
			
			for(int i = 1 ; i<end ; i++) {
				if(i==1) {
					if(temp[i] == '.') {
						result[number] += Integer.toString(data[i]);
					}else {
						result[number] = Integer.toString(data[i]);
						reason[number++] = temp[i];
					}
				}else {
					if(temp[i] == '.') {
						result[number] += Integer.toString(data[i]);
					}else {
						if(temp[i-1] == '.') {
							result[number] += Integer.toString(data[i]);
							reason[number++] = temp[i];
							
						}else {
							result[number] = Integer.toString(data[i]);
							reason[number++] = temp[i];
						}						
					}					
				}				
			}
			
			if(temp[end-1] == '.') {
				result[number] = Integer.toString(data[end]);
			}else {
				result[number] = Integer.toString(data[end]);				
			}
			
			for(int i = 1 ; i<=number ; i++) {
				System.out.print(result[i]);
				sum += Integer.parseInt(result[i]);
			}
			System.out.println();
			
			
			
		}else {
			data[start] = start;
			for(int i = 0 ; i<3 ; i++) {
				if(i == 0) {
					temp[start] = '+';
					getResult(start+1,end);
					temp[start] = 0;
				}else if(i==1) {
					temp[start] = '-';
					getResult(start+1,end);
					temp[start] = 0;
				}else {
					temp[start] = '.';
					getResult(start+1,end);
					temp[start] = 0;
				}
				
			}
			
		}
		
	}

}

