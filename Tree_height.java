package com.java.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tree_height {
	
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static Graph graph;
	private static int[] visitedH;
	private static int count;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new Graph(n);
		visitedH = new int[n];
		Arrays.fill(visitedH, -1);
		for(int i = 0 ; i< n-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.put(a, b);			
		}
		dfs(m,0);
		int max = -987987987;
		for(int i = 0 ; i<n ; i++) {
			if(max<visitedH[i]) max = visitedH[i]; 
		}
		bw.write(max+"");
		br.close();
		bw.flush();
		bw.close();

	}
	
	private static void dfs(int v, int height) {
		visitedH[v] = height;
		for(int i = 0 ; i< graph.getNode(v).size() ; i++) {
			int w = graph.getNode(v).get(i);
			if(visitedH[w] == -1) dfs(w, height+1);
		}
	}

}

class Graph{
	private ArrayList<ArrayList<Integer>> graph;
	public Graph(int nodeSize) {
		graph = new ArrayList<>();
		for(int i = 0 ; i< nodeSize+1 ; i++) {
			graph.add(new ArrayList<>());
		}
	}
	public void put(int n , int m) {
		graph.get(n).add(m);
		graph.get(m).add(n);
	}
	public ArrayList<Integer> getNode(int n){
		return graph.get(n);
	}
	
	
}
