package com.java.practice;

import java.util.Scanner;

/**
 * 입력 : 첫 번째 줄에 N, M, Q가 주어진다. ( 1 ≤ N, M ≤ 1,000, 1 ≤ Q ≤ 1,000,000 ) 두 번째 줄부터
 * N x M 직사각형이 주어진다. 직사각형 안의 숫자 S는 -100이상 100이하이다. 그 후 Q개의 질문이 주어진다. 각각의 질문은 “a
 * b c d” 로 이루어 져 있으며 , 이는 (a, b) 부터 (c, d) 까지의 직사각형에 들어있는 정수의 합을 묻는다. (0 ≤ a ≤
 * c < N, 0 ≤ b ≤ d < M) 출력 : 각 질문에 대한 답을 출력한다.
 *
 * 예제 입력 5 5 3 1 -2 3 2 8 -8 -9 3 4 5 2 4 7 8 2 1 4 3 1 4 -1 2 5 -6 3 1 2 3 4 0
 * 0 1 1 2 0 2 1
 * 
 * 예제 출력 37 -18 6
 */

public class Rectangular_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();
		long area[][] = new long[n][m];

		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = 0; j < m; j++) {
				sum += sc.nextLong();
				if (i > 0)
					area[i][j] = sum + area[i - 1][j];
				else
					area[i][j] = sum;
			}
		}
		

		for (int i = 0; i < q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			long sum = 0;
			if (a == 0 && b == 0)
				sum = area[c][d];
			else if (a > 0 && b > 0)
				sum = area[c][d] - area[c][b - 1] - area[a - 1][d] + area[a - 1][b - 1];
			else if (a == 0)
				sum = area[c][d] - area[c][b - 1];
			else if (b == 0)
				sum = area[c][d] - area[a - 1][d];

			System.out.println(sum);

		}
	}

}
