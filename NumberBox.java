package edu.java.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberBox {
	/**
	 * 문제 : 숫자박스에는 자연수들이 적혀있는 종이들이 N장 들어있다.
	 *  숫자 M개가 주어졌을 때, 이 숫자가 적혀있는 숫자가 상자 안에 있는지 아닌지를 구하는 프로그램을 작성하시오.  
	 *  
	 *  입력 : 첫째 줄에 윤성이가 가지고 있는 숫자 정보의 개수 N (1 ≤ N ≤ 300,000)이가 주어진다. 
	 *  둘째 줄에는 숫자 정보들이 주어진다. 숫자는 절댓값 1,000,000 이하의 정수이다.
	 *   두 숫자 카드에 같은 숫자가 적혀있는 경우는 없다.
	 *   셋째 줄에는 M (1 ≤ M ≤ 500,000)이 주어진다. 
	 *   넷째 줄에는 윤성이가 숫자 박스에 있는지 아닌지를 구해야 할 M개의 숫자가 주어지며, 
	 *   이 숫자는 공백으로 구분되어져 있다. 이숫자도 1,000,000이하의 정수이다. 
	 *   
	 *    출력 :첫째 줄에 입력으로 주어진 M개의 숫자에 대해서, 각 숫자가 숫자 상자안에 있으면 1, 아니면 0을 개행으로 구분해 출력한다.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0 ; i<n ; i++) {
			int number = sc.nextInt();
			list.add(number);
		}
		
		list.sort(null);
		
		int m = sc.nextInt();
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			int start = 0;
			int end = list.size()-1;
			int inx = getResult(start,end,a,list);
			System.out.println(inx);
//			boolean check = false;
//			while(start+1<end) {
//				if(list.get(start)>=a) {
//					if(list.get(start) == a) {
//						check = true;
//						break;
//					}else {
//						check = false;
//						break;
//					}
//				}else if(list.get(end)<=a) {
//					if(list.get(end)==a) {
//						check = true;
//						break;
//					}else {
//						break;
//					}
//				}
//				int mid = (start+end)/2;
//				if(list.get(mid) == a) {
//					check = true;
//					break;
//				}else if(list.get(mid)>a) {
//					end = mid;
//				}else if(list.get(mid)<a) {
//					start = mid;
//				}
//				
//			}
//			
//			if(!check) {
//				System.out.println(0);
//			}else {
//				System.out.println(1);
//			}
			
			
		}

	}
	
	static int getResult(int start, int end, int a, ArrayList<Integer> list) {
		if(list.get(start)>a) {
			return -1;
		}else if(list.get(end)<a) {
			return -1;
		}else {
			int mid = (start+end)/2;
			if(list.get(mid) == a) {
				return 1;
			}else if(list.get(mid)>a) {
				return getResult(start, mid-1, a, list);
			}else {
				return getResult(mid+1,end,a,list);
			}
			
		}
	}
	

}
