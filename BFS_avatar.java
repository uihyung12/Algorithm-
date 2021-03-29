package com.java.practice;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 깊이우선탐색 (BFS)
 * 
 * 1------2-------6
 * \     /\       /
 *  \   /  4-----5
 *   \ /  / \
 *    3  7   8-9
 */

/*
 * 9 12
 * 1 2
 * 1 3
 * 2 3
 * 2 4
 * 2 6
 * 3 7
 * 4 5
 * 4 7
 * 4 8
 * 5 6
 * 7 8
 * 8 9
 */

public class BFS_avatar {
	static ArrayList<Integer>[] myGraph;
	static boolean[] check = new boolean[100];
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		myGraph = new ArrayList[n+1];
		for(int i = 0 ; i<=n ; i++) {
			myGraph[i] = new ArrayList<Integer>();
		}
		
		
		
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			myGraph[a].add(b);
			myGraph[b].add(a);
			
			
		}
		
		DFS(1);

	}
	
	
	static void DFS(int x) {
		
		check[x] = true;
		System.out.println(x);
		for(int i = 0 ; i<myGraph[x].size() ; i++) {
			int y = myGraph[x].get(i);
			
			if(!check[y]) {
				DFS(y);
			}
			
		}
		
	}

}
