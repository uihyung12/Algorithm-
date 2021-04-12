package com.java.practice;

import java.util.Scanner;

/*입력 예제
5
1 2 3
2 4 5
3 -1 -1
4 -1 -1
5 -1 -1

출력 예제
1 2 4 5 3
4 2 5 1 3
4 5 2 3 1*/


public class Binary_tree {
	public Node root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Binary_tree t = new Binary_tree();
		
		for(int i = 0 ; i<n ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			t.createNode(a, b, c);
		}
		System.out.println("전위 순회");
		t.preOrder(t.root);
		
		System.out.println();
		System.out.println("중위 순회");
		t.inOrder(t.root);
		System.out.println();
		System.out.println("후위 순회");
		t.postOrder(t.root);

	}
	
	public void createNode(int data ,int leftData ,int rightData) {
		if(root == null) {//초기 상태 - 루트 노드 생성
			root = new Node(data);
			
			if(leftData != -1) {
				root.left = new Node(leftData);
			}
			if(rightData != -1) {
				root.right = new Node(rightData);
			}
			
		}else {
			searchNode(root,data,leftData,rightData);
		}
	}

	private void searchNode(Node node, int data, int leftData, int rightData) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}else if(node.data == data) {
			if(leftData != -1) {
				node.left = new Node(leftData);
			}
			if(rightData != -1) {
				node.right = new Node(rightData);
			}
		}else {
			searchNode(node.left, data, leftData, rightData);
			searchNode(node.right, data, leftData, rightData);
		}
		
	}
	
	public void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.data+" ");
			if(node.left != null) preOrder(node.left);
			if(node.right != null) preOrder(node.right);
		}
		
	}
	
	public void inOrder(Node node) {
		if(node != null) {
			if(node.left != null) inOrder(node.left);
			System.out.print(node.data+" ");
			if(node.right != null) inOrder(node.right);
		}		
	}
	
	public void postOrder(Node node) {
		if(node != null) {
			if(node.left != null) postOrder(node.left);
			if(node.right != null) postOrder(node.right);
			System.out.print(node.data+" ");
		}
		
	}

}


class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
	}
	
	
}