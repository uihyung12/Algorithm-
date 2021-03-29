package com.java.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;

/*
 * 문제 : 그래프가 주어질 때, 0번 정점을 시작으로 하여 깊이우선탐색과 너비우선탐색의 결과를 출력하는 
 * 프로그램을 작성하시오. 단, 노드를 방문할 때는 노드 번호가 작은 순서대로 방문한다고 하자.
 * 
 * 입력 : 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다.
 *  (1 ≤ N ≤ 1,000, 1 ≤ M ≤ 100,000 ) 둘째 줄부터 간선의 정보가 주어진다. 
 *  각 줄은 두 개의 숫자 a, b로 이루어져 있으며, 이는 정점 a와 정점 b가 연결되어 있다는 의미이다.
 *   정점의 번호는 0번부터 N-1번까지이다.
 *   
 * 출력 : 첫 번째 줄에 깊이우선탐색 결과, 두 번째 줄에 너비우선탐색 결과를 출력한다.
 * 
 * 예제입력
 * 9 12
	0 1
	0 2
	0 3
	1 5
	2 5
	3 4
	4 5
	5 6
	5 7
	5 8
	6 7
	7 8
	
	예제 출력
	0 1 5 2 4 3 6 7 8
	0 1 2 3 5 4 6 7 8 
 */


public class Depth_first_search_and_width_first_search {
	static int[] data = new int[1010];
	static ArrayList<Integer>[] list;
	static boolean[] dfsCheck = new boolean[1010];
	static boolean[] bfsCheck = new boolean[1010];
	static ArrayList<Integer> dfsList = new ArrayList<>();
	static ArrayList<Integer> bfsList = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		list = new ArrayList[n+10];
		
		for(int i = 0 ; i<=n ; i++) {
			list[i] = new ArrayList<>();
		}
		int min = 987987;
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(min>a) {
				min = a;
			}
			if(min>b) {
				min = b;
			}
			
			list[a].add(b);
			list[b].add(a);
		}
		
		DFS(min);
		BFS(min);
		
		for(int i = 0 ; i<dfsList.size() ; i++) {
			System.out.println(dfsList.get(i));
		}
		System.out.println();
		for(int i = 0 ; i<bfsList.size() ; i++) {
			System.out.println(bfsList.get(i));
		}
		

	}
	
	static void DFS(int node) {
		dfsCheck[node] = true;
		dfsList.add(node);
		
		for(int i = 0 ; i<list[node].size() ; i++) {
			int node2 = list[node].get(i);
			
			if(!dfsCheck[node2]) {
				DFS(node2);
			}
			
		}
		
		
	}
	
	static void BFS(int node) {
		bfsCheck[node] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		while(!queue.isEmpty()) {
			int current = queue.poll();
			dfsList.add(current);
			
			for(int i = 0 ; i<list[current].size() ; i++) {
				int node2 = list[current].get(i);
				if(!bfsCheck[node2]) {
					bfsCheck[node2] = true;
					queue.add(node2);
				}
				
			}
			
		}
		
	}

	

}
