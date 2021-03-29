package com.java.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class two_coloring_BFS {

	static ArrayList<Integer>[] graph;
	static boolean[] check = new boolean[1010];
	static boolean flag = false;
	static int[] group = new int[1010];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m = sc.nextInt();
		
		graph = new ArrayList[n+10];
		
		for(int i = 0 ; i<n ; i++) {
			graph[i] = new ArrayList<>();
		}
		int min = 987987;
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(min>a) min = a;
			if(min>b) min = b;
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		
		getResult(min,1);
		if(!flag) System.out.println("Yes");
		else System.out.println("No");

	}
	
	
	static void getResult(int node, int color) {
		check[node] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		group[node] = color;
		if(color == 1) color = 2;
		else color = 1;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i = 0 ; i<graph[current].size(); i++) {
				int next = graph[current].get(i);
				if(group[next] != 0 && group[next] == group[current]) {
					flag = true;
					return;
				}
				
				int c1;
				if(group[current] == 1) c1=2;
				else c1=1;
				
				if(!check[next]) {
					check[next] = true;
					group[next] = c1;
					queue.add(next);
				}
				
				
			}
			
			
			
		}
		
		
	}
	
	
	

}
