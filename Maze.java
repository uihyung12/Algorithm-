package com.java.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제 : 아래와 같이 이동할 수 있는 길, 그리고 이동할 수 없는 벽으로 이루어진 크기 N x M 의 지도가 주어진다. 
 * 이 때, (N-1, 0) 에서 출발하여 (0, M-1) 까지 도착하는 최단거리를 출력하는 프로그램을 작성하시오.
 *  아래 그림에 대하여 S에서 E까지 가는 최단거리는 22이다.
 * 
 * 입력 : 첫째 줄에 지도의 세로 길이 N과 지도의 가로 길이 M이 주어진다. 
 * ( 1 ≤ N, M ≤ 1,000 ) 둘째 줄부터 지도의 정보가 주어진다.
 *  0은 이동할 수 있는 부분, 1은 이동할 수 없는 부분을 나타낸다.
 *  
 *  출력 : (N-1, 0) 에서 출발하여 (0, M-1) 까지 이동하는 데 필요한 최단거리를 출력한다.
 *  
 *  예제 입력 : 
 *  10 10
	0 0 0 0 0 0 1 1 0 0
	0 1 1 1 0 0 1 0 1 0
	0 1 1 1 0 0 1 0 1 0
	0 0 0 0 0 0 0 0 1 0
	0 0 1 1 1 1 0 0 1 0
	0 0 0 0 0 0 1 1 0 0
	0 0 1 1 1 0 1 1 0 0
	0 0 1 1 1 0 0 0 0 0
	0 0 0 0 0 1 1 1 0 0
	0 0 0 0 0 0 0 1 0 0
	
	예제출력:
	22

 
 */

public class Maze {
	
	static int[][] map = new int[1010][1010];
	static boolean[][] check = new boolean[1010][1010];
	static int[][] cost = new int[1010][1010];
	static int n;
	static int m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0 ; i<n ; i++) {
			for(int j = 0 ; j<m ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		getResult(n-1,0);
		
		System.out.println(cost[0][m-1]);
		
		

	}
	
	static void getResult(int y, int x) {
		int[] dx = {0,-1,1,0};
		int[] dy = {1,0,0,-1};
		Queue<q> queue = new LinkedList<q>();
		
		queue.add(new q(y,x));
		check[y][x] = true;
		
		while(!queue.isEmpty()) {
			q current = queue.poll();
			
			int curY = current.y;
			int curX = current.x;
			
			for(int k = 0 ; k<4 ;k++) {
				int yy = curY+dy[k];
				int xx = curX+dx[k];
				if(0<=yy && yy<n && 0<=xx && xx<m) {
					if(!check[yy][xx] && map[yy][xx]==0) {
						check[yy][xx] = true;
						cost[yy][xx] = cost[curY][curX]+1;
						queue.add(new q(yy,xx));
					}
				}
				
			}
			
			
			
			
			
		}
		
		
	}
	

}


class q{
	
	int y;
	int x;
	
	public q(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	
	
}
