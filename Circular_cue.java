package com.java.practice;

import java.util.Scanner;

public class Circular_cue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Queue_number queue = new Queue_number();
		
		queue.capacity = sc.nextInt();
		int m = sc.nextInt();
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			
			if(a == 1) {
				queue.push(sc.nextInt());
			}else if(a == 2) {
				queue.pop();
			}else {
				queue.Front();
			}
			
			
		}

	}

}

class Queue_number{
	int front = 0;
	int rear = 0;
	int capacity = 0;
	int count = 0;
	int[] data = new int[110];
	
	void push(int number) {
		if(capacity>count) {
			data[rear++] = number;
			count++;
			rear = rear%capacity;
		}else {
			System.out.println("Overflow");
		}		
		
	}
	
	void pop() {
		if(count == 0) {
			System.out.println("Underflow");
		}else {
			data[front++] = 0;
			count--;
			front = front%capacity;
		}
		
	}
	
	void Front() {
		if(count == 0) {
			System.out.println("NULL");
		}else {
			System.out.println(data[front]);
		}
		
		
	}
	
	
	
}
