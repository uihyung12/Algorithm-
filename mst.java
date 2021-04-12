package com.java.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 최소 신장 트리 
 */

public class mst {

	static final int MAX = 10000;
	static int[] root = new int[MAX];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<number> graph = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.add(new number(a, b, c));			
			
		}
		
		Collections.sort(graph, new Comparator<number>() {

			@Override
			public int compare(number n1, number n2) {
				// TODO Auto-generated method stub
				if(n1.cost<n2.cost) return -1;
				else return 1;				
			}			
		});
		
		
		for(int i = 1 ; i<=n ; i++) root[i] = i;
		
		//cutproperty
		int result = 0;
		for(int i = 0 ; i<m ; i++) {
			
			if(Union(graph.get(i).p, graph.get(i).q)) {
				result += graph.get(i).cost;
			}
			
		}	
		
		System.out.println(result);

	}
	
	static boolean Union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		else {
			root[rootA] = rootB;
			return true;
		}
		
		
	}

	private static int find(int a) {
		if(root[a] == a) return a;
		else {
			int y = find(root[a]);
			root[a] = y;
			return y;
		}
		
		
	}
	

}

//클래스 만들어 주기
class number{
	
	int p;
	int q;
	int cost;
	
	public number(int p , int q , int cost) {
		this.p = p;
		this.q = q;
		this.cost = cost;
	}
	
}

