package com.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
	8 10
	1 2 1
	1 3 2
	2 3 3
	2 4 4
	4 5 1
	4 6 2
	5 6 2
	5 8 2
	6 7 3
	7 8 4	
	
	
	15
 */

//mst 구하는 방법인 알고리즘
public class Kruskal_Algorithm {
	
	static int n,m;
	static ArrayList<edge> edgeList = new ArrayList<>();
	static int parent[] = new int[100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * (1) 그래프를 입력을 받는다.
		 * (2) 간선 가중치가 작은 순서대로 정렬을 한다.
		 * (3) 간선 가중치가 작은 간선부터 차례대로 선택하려는 시도를 해본다.
		 * 	(3-1) 시작점과 끝점이 같은 그룹에 속한다면, 그냥 넘어간다.
		 * 	(3-2) 그게 아니라면, 이 간선을 선택한다. 이 간선의 가중치를 더한다.
		 * 		   시작점과 끝점을 같은 그룹으로 만들어 준다.
		 * 	
		 */
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			
			edgeList.add(new edge(a,b,c));
		}
		//객체 배열, 오름차순
		Collections.sort(edgeList,new Comparator<edge>() {

			@Override
			public int compare(edge e1, edge e2) {
				// TODO Auto-generated method stub
				if(e1.cost<e2.cost) return -1;
				else return 1;
			}			
		});
		
		for(int i = 1 ; i<=n ; i++) parent[i] = i;
		
//		for(int i = 0; i<m ; i++) {
//			System.out.printf("%d %d %d\n",edgeList.get(i).p, edgeList.get(i).q, edgeList.get(i).cost);
//		}
		
		int result = 0;
		for(int i = 0 ; i<m ; i++) {
			
			if(Union(edgeList.get(i).p, edgeList.get(i).q)) {
				result += edgeList.get(i).cost;
			}
			
		}
		
		System.out.println(result);

	}

	private static boolean Union(int a, int b) {
		// TODO Auto-generated method stub
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		else {
			parent[rootA] = rootB;
			return true;
		}
		
	}

	private static int find(int x) {
		// TODO Auto-generated method stub
		if(x == parent[x]) return x;
		else {
			int y = find(parent[x]);
			parent[x] = y;
			return y;
		}
	}
	
	

}

class edge {
	int p;
	int q;
	int cost;
	
	public edge(int p, int q, int cost) {
		this.p = p;
		this.q = q;
		this.cost = cost;
	}

	

	
	
}
