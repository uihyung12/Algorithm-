package com.java.practice;

import java.util.Scanner;

public class two_array_answer_guess_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long index = 0;
		while(true) {
			if(index*index+index>n) {
				break;
			}
			
			index += 1000;
		}
		
		for(long i = index-1000 ; i<=index ; i++) {
			if(i*(i+1)>n) {
				System.out.println(i-1);
				break;
			}
		}
		

	}

}
