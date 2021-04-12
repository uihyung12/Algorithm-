package com.java.practice;

public class heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		heapProvide he = new heapProvide();
		he.push(2);
		he.push(80);
		he.push(1);
		System.out.println(he.top());
		he.pop();
		System.out.println(he.top());

	}

}


class heapProvide{
	
	
	int[] data = new int[110];
	int len = 1;
	
	
	void push(int x) {
		data[len++] = x;
		int inx = len-1;
		
		while(inx>1) {
			if(data[inx]<data[inx/2]) {
				int temp = data[inx];
				data[inx] = data[inx/2];
				data[inx/2] = temp;
			}else break;
			
			inx = inx/2;
			
		}
		
	}
	
	void pop() {
		
		//먼저 처음것을 지운다
		//그 이후에 마지막에 있는 노드를 가지고 와서 맨 위로 올린 후에
		//정렬을 한다.
		
		data[1] = data[len-1];
		data[len-1] = 0;
		len--;
		
		//노드의 탐색 3가지 경우
		//1. 자식 노드가 왼쪽, 오른쪽 둘 다 없는 경우
		//2. 자식 노드가 왼쪽만 있는 경우
		//3. 자식 노드가 둘 다 있는 경우
		int inx = 1;
		
		while(true) {
			
			int pInx = -1;
			if(len<=inx*2) break;
			else if((1<=inx*2 && inx*2 <len) && len <= inx*2+1) {
				pInx = inx*2;
			}else {
				if(data[inx*2] < data[inx*2+1]) {
					pInx = inx*2;
				}else {
					pInx = inx*2+1;
				}
			}
			
			if(data[inx]>data[pInx]) {
				int temp = data[inx];
				data[inx] = data[pInx];
				data[pInx] = temp;
				
				inx = pInx;
			}else break;
			
			
		}
		
		
		
		
	}
	
	int top() {
		if(len>=1) {
			return data[1];
		}else {
			
			return -1;
		}
	}
	
	
	
	
}
