package com.java.practice;

import java.util.Scanner;

/**
 *	문제 : n과 m이 주어질 때, n의 m승을 구하는 프로그램을 작성하시오. 
 *		단, n의 m승의 값이 커질 수 있기 때문에, 
 *		정답을 10,007 으로 나눈 나머지를 출력한다.
 *	입력 : 첫 번째 줄에 숫자 n과 m이 주어진다. 
 *		( 1 ≤ n ≤ 100, 1 ≤ m ≤ 1,000,000,000,000,000,000 ) 
 *	출력 : 첫째 줄에 n의 m승을 10,007 으로 나눈 나머지를 출력한다.
 *
 *  예제 : 3 4
 *  출력 : 81
 *
 */

public class Find_the_power_L {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long m = sc.nextLong();
		
		int sum = getResult(n,m);
		System.out.println(sum);
		

	}
	
	static int getResult(int n, long m) {
		if(m == 0) {
			return 1;
		}else {
			if(m%2==0) {
				int temp = getResult(n,m/2);
				return (temp*temp)%10007;
			}else {
				int temp = getResult(n, m-1);
				return (temp*n)%10007;
			}
			
		}
		
		
	}

}
