package com.java.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree_depth {

	static int max = 0;
	static ArrayList<Integer>[] list;
	static boolean[] check = new boolean[110];
	static int[] myStack = new int[110];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int root = sc.nextInt();
		list = new ArrayList[110];

		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();

		}

		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			list[a].add(b);
		}
		check[root] = true;
		getResult(root, 0);
		System.out.println(max);

	}

	static void getResult(int root, int cnt) {
		if (max < cnt) {
			max = cnt;
		}
		for (int i = 0; i < list[root].size(); i++) {
//				System.out.println(list[root].get(i));

			if (!check[list[root].get(i)]) {
				check[list[root].get(i)] = true;
				cnt++;
				myStack[cnt] = list[root].get(i);
				getResult(list[root].get(i), cnt);
				myStack[cnt] = 0;
				cnt--;
			}
		}

	}

}
