package com.java.practice;

import java.util.ArrayList;
import java.util.Scanner;
/*	예제
	8 11 0 6
	0 1 3
	0 5 1
	1 2 4
	1 3 1
	1 5 1
	2 4 6
	2 6 9
	2 7 4
	3 4 2
	4 6 9
	6 7 3
	
	답
	13
 */

public class Dijkstra_Algorithm_Shortest_distance {
	
	final static int MAX = 100;
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer>[] cost;
	static int n,m,start,end2;
	static int[] Table = new int[MAX];
	static boolean[] check = new boolean[MAX];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();
		end2 = sc.nextInt();
		graph = new ArrayList[MAX];
		cost = new ArrayList[MAX];
		
		for(int i = 0 ; i<MAX ; i++) {
			graph[i] = new ArrayList<>();
			cost[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph[a].add(b);
			graph[b].add(a);
			
			cost[a].add(c);
			cost[b].add(c);
		}
		
		for(int i = 0 ; i<n ; i++) Table[i] = 987987987;
		Table[start] = 0;
		
		for(int i = 0 ; i<n ; i++) {
			
			int minValue = 987987987, minIndex = -1;
			
			for(int j = 0 ; j<n ; j++) {
				if(!check[j] && minValue>Table[j]) {
					minValue = Table[j];
					minIndex = j;
				}
				
			}
			
			check[minIndex] = true;
			
			for(int j = 0 ; j<graph[minIndex].size() ; j++) {
				int Node2 = graph[minIndex].get(j);
				int Cost2 = cost[minIndex].get(j);
				
				if(Table[Node2]>Table[minIndex]+Cost2) {
					Table[Node2] = Table[minIndex]+Cost2;
				}
				
			}
			
		}
		
		System.out.println(Table[end2]);

	}

}
