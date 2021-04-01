package com.java.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Carpenter_maze_escape {
	
	final static int MAX = 1050; 
	static int n,m;
	static int[][] Map = new int[MAX][MAX];
	static boolean[][] check = new boolean[MAX][MAX];
	static int[][] c1 = new int[MAX][MAX];
	static int[][] c2 = new int[MAX][MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0 ; i<n ; i++) {
			for(int j = 0 ; j<m ; j++) {
				Map[i][j] = sc.nextInt();
			}
		}
		
		getResult(n-1,0,c1);
		
		for(int i = 0 ; i<n ; i++) {
			for(int j = 0 ; j<m ; j++) {
				check[i][j] = false;
			}
		}
		
		getResult(0,m-1,c2);
		
		int result = 987987987;
		
		for(int i = 0 ; i<n ; i++) {
			for(int j = 0 ; j<m ; j++) {
				if(Map[i][j] == 1 && c1[i][j]>0 && c2[i][j]>0) {
					result = Math.min(result, c1[i][j]+c2[i][j]);
				}
			}
		}
		
		System.out.println(result);
		

	}
	
	static void getResult(int y, int x, int[][] cost) {
		Queue<p> queue = new LinkedList<p>();
		
		queue.add(new p(y,x));
		check[y][x] = true;
		int[] dy = {-1,0,0,1};
		int[] dx = {0,1,-1,0};
		
		while(!queue.isEmpty()) {
			p front = queue.poll();
			
			int curY = front.y;
			int curX = front.x;
			
			for(int k = 0 ; k<4 ; k++) {
				int yy = curY+dy[k];
				int xx = curX+dx[k];
				
				if(0<=yy && yy<n && 0<=xx && xx<m && !check[yy][xx]) {
					check[yy][xx] = true;
					cost[yy][xx] = cost[curY][curX]+1;
					
					if(Map[yy][xx] == 0) queue.add(new p(yy,xx));
				}
				
			}
			
		}
	}

}

class p{
	int y;
	int x;
	
	public p(int y, int x) {
		this.y = y;
		this.x = x;
		
	}
	
}
