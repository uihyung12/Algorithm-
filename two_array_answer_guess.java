package com.java.practice;

import java.util.Scanner;

public class two_array_answer_guess {
	
	/**
	 * 문제 :  2차식 f(x) = x*x+ x 가 있고, 숫자 a가 주어진다. 우리는 f(x) = a 를 만족하는 x의 값을 찾고 싶지만, 보통 이 값은 정수로 떨어지지 않는 경우가 많다. 
	 * 예를 들어, f(x) = 20 을 풀고자 한다면, x = 4이기 때문에 이는 정수이지만, f(x) = 103 을 풀고자 한다면 이는 x = 9.6612... 로써 정수가 아니다.

		이 문제에서는 x의 정수부분이 얼마인지를 구하는 프로그램을 작성하시오. 단, x 는 음수를 제외한 정수이다. 예를 들어, f(x) = 103 을 풀고자 한다면, x = 9.6612... 이기 때문에 
		정수부분은 9가 된다.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		long root = (long) Math.sqrt(n);
		long result = getResult(root-1,n/2,n);
		
		System.out.println(result);
		

	}
	
	private static long getResult(long start, long end, long label) {
		while(start+1<end) {
			long mid = (start+end)/2;
			
			if(mid*mid+mid>label) {
				end = mid;
			}else {
				start = mid;
			}
			
			
			
		}
		
		return start;
		
		
	}
	
	

}
