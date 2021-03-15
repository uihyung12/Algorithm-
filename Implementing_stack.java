package com.java.practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *이 문제에서는 스택을 구현한다. 스택은 다음 세 개의 연산을 지원한다.

Push X : 스택에 정수 X를 push한다. 만약 스택이 꽉 차서 push를 할 수 없다면, “Overflow”를 출력한다.
Pop : 스택에서 정수 하나를 pop한다. 만약 스택이 비어있어서 pop을 할 수 없다면, “Underflow”를 출력한다.
Top : 스택의 top에 있는 정수를 출력한다. 만약 스택이 비어있다면 “NULL”을 출력한다.
크기가 n인 스택에 m개의 연산을 하는 프로그램을 작성하시오. 입력의 편의를 위해서 Push는 “1”, Pop은 “2”, Top은 “3”으로 표현한다. 
 *
 */

public class Implementing_stack{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		stack_Implementing stack = new stack_Implementing();
		
		stack.capacity = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i = 0 ; i<m ; i++) {
			int a = sc.nextInt();
			
			if(a == 1) {
				int b = sc.nextInt();
				stack.push(b);
			}else if(a == 2) {
				stack.pop();
			}else {
				stack.Top();
			}
			
		}

	}
	
	
}






interface Stack{
	void push(int number);
	void pop();
	void Top();
}

class stack_Implementing implements Stack {

	
	
	int cnt = 0;
	int capacity = 0;
	int[] array = new int[110];
	
	
	
	@Override
	public void push(int number) {
		// TODO Auto-generated method stub
		if(capacity>cnt) {
			array[cnt++] = number;
		}else {
			System.out.println("Overflow");
		}
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		if(cnt<=0) {
			System.out.println("Underflow");
		}else {
			array[--cnt] = 0;
		}
		
	}

	@Override
	public void Top() {
		// TODO Auto-generated method stub
		if(cnt<=0) {
			System.out.println("NULL");
		}else {
			System.out.println(array[cnt-1]);
		}
		
	}

	
	
	

}
