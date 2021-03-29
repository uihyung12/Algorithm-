package com.java.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Worm_virus_BFS {
	
	static ArrayList<Integer>[] list;
	static int cnt = 0;
	static boolean[] check = new boolean[100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		list = new ArrayList[n+10];
		for(int i = 0 ; i<=n ; i++) list[i] = new ArrayList<>();
		
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		getResult(1);
		System.out.println(cnt);

	}
	
	static void getResult(int node) {
		check[node] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(node);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i = 0 ; i<list[current].size(); i++) {
				int next = list[current].get(i);
				if(!check[next]) {
					queue.add(next);
					check[next] = true;
					cnt++;
				}
				
				
			}
			
			
		}
		
		
	}

}
