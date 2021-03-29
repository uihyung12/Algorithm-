package com.java.practice;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제 : 이분 그래프란, 아래 그림과 같이 정점을 크게 두 집합으로 나눌 수 있는 그래프를 말한다. 
 * 여기서 같은 집합에 속한 정점끼리는 간선이 존재해서는 안된다. 
 * 예를 들어, 아래 그래프의 경우 정점을 크게 {1, 4, 5}, {2, 3, 6} 의 두 개의 집합으로 나누게 되면,
 *  같은 집합에 속한 정점 사이에는 간선이 존재하지 않으므로 이분 그래프라고 할 수 있다.
 *  그래프가 입력으로 주어질 때, 이 그래프가 이분그래프인지를 판별하는 프로그램을 작성하시오.
 *  
 *  입력 : 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. 
 *  ( 2 ≤ N ≤ 1,000, N-1 ≤ M ≤ 100,000 ) 둘째 줄부터 간선의 정보가 주어진다.
 *   각 줄은 두 개의 숫자 a, b로 이루어져 있으며, 이는 정점 a와 정점 b가 연결되어 있다는 의미이다.
 *  (1 ≤ a, b ≤ N)
 *  
 *  출력 : 주어진 그래프가 이분 그래프이면 Yes, 아니면 No를 출력한다.
 *  
 *  예제 입력 : 6 5
			1 2
			2 4
			3 4
			3 5
			4 6
 *  
 *  예제 출력 : Yes
 */


public class Binary_graph_discrimination {
	
	static ArrayList<Integer>[] graph;
	static boolean flag = false;
	static int[] coloring = new int[1010];
	static boolean[] check = new boolean[1010];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		graph = new ArrayList[n+10];
		
		for(int i = 0 ; i<=n ; i++) {
			graph[i] = new ArrayList<>();
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
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		isResult(min,1);
		
		if(!flag) System.out.println("Yes");
		else System.out.println("No");

	}
	
	static void isResult(int node, int color) {
		check[node] = true;
		coloring[node] = color;
		
		for(int i = 0 ; i<graph[node].size() ; i++) {
			int node2 = graph[node].get(i);
			
			if(coloring[node2] != 0 && coloring[node2] == color) {
				flag = true;
				return;
			}
			
			int c1;
			if(color == 1) c1 = 2;
			else c1 = 1;
			
			if(check[node2] == false) isResult(node2,c1);
			
		}
		
		
	}

}
