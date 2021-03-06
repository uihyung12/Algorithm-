package com.java.practice;

import java.util.Scanner;

public class desert2 {

	
	static int n;
	static int[] data = new int[20];
	static String[] result = new String[20];
	static char[] temp = new char[30];
	static char[] member = new char[30];
	static int cnt = 0;
	static boolean[] check = new boolean[20];
	static boolean flag = false;
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);

	   n = sc.nextInt();
	    	
	   getResult(0,n);
    	
    }
    
    public static void getResult(int start, int end) {
    	if(start>=end) {
    		for(int i = 0 ; i<end; i++) {
    			
    			
    		}
    		
    		
    	}else {
    		result[start] = Integer.toString(start+1);
    		
    		for(int i = 0 ; i<3 ; i++) {
    			if(i == 0) {
    				temp[start] = '+';
    				getResult(start+1,end);
    				temp[start] = 0;
    			}else if(i==1) {
    				temp[start] = '-';
    				getResult(start+1,end);
    				temp[start] = 0;
    			}else {
    				temp[start] = '.';
    				check[start] = true;
    				getResult(start+1,end);
    				check[start] = false;
    				temp[start] = '.';
    			}
    			
    		}
    		
    		
    		
    	}
    	
    }
	
	
	

}
