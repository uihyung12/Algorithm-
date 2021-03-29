package com.java.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_search {
	static ArrayList<Integer>[] list;
	static boolean[] check = new boolean[100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		list = new ArrayList[n+1];
		for(int i = 0 ; i<=n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);
			for(int i = 0 ; i<list[current].size(); i++) {
				int next = list[current].get(i);
				
				if(check[next] == false) {
					check[next] = true;
					queue.add(next);
				}
				
			}
			
		}
		

	}

}
