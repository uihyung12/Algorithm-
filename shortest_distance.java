package com.java.practice;
/*
 * 문제 :그래프와 출발점, 도착점이 주어질 때 출발점에서 도착점까지 이동하기 위한 최단거리를 출력하는 프로그램을 작성하시오. 
 * 예를 들어, 아래 그림에서 출발 정점이 0, 도착 정점이 10이라고 할 때, 최단거리는 3이다.
 * 
 * 입력 : 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
 * ( 1 ≤ N ≤ 10,000, 1 ≤ M ≤ 1,000,000 ) 둘째 줄부터 간선의 정보가 주어진다. 
 * 각 줄은 두 개의 숫자 a, b로 이루어져 있으며, 이는 정점 a와 정점 b가 연결되어 있다는 의미이다.
 *  M+1 번째 줄에 대하여 출발점과 도착점의 정점 번호가 주어진다. 정점의 번호는 0번부터 N-1번까지이다.
 *  
 *  출력 : 출발점에서 도착점까지 이동하기 위한 최단거리를 출력한다.
 *  
 *  예제 입력
 *  11 14
	0 1
	0 2
	1 2
	1 4
	1 5
	2 3
	3 7
	4 7
	4 9
	4 10
	5 6
	6 8
	6 10
	7 8
	0 10
	
	예제 출력
	3

 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class shortest_distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] Table = new int[10100];
		int start = 0,end = 0;
		boolean[] check = new boolean[10100];
		ArrayList<Integer>[] graph;
		graph = new ArrayList[n+1];
		
		for(int i = 0 ; i<=n ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		
		
		for(int i = 0 ; i<=m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(i == m) {
				start = a;
				end = b;
			}else {
				graph[a].add(b);
				graph[b].add(a);
			}			
			
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		check[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i = 0 ; i<graph[current].size(); i++) {
				int y = graph[current].get(i);
				if(!check[y] && Table[y] == 0) {
					check[y] = true;
					Table[y] = Table[current]+1;
					queue.add(y);
				}
				
			}
			
			
		}
		System.out.println(Table[end]);

	}

}
