package edu.java.algorithm;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner sc = new Scanner(System.in);
	       
	       int n = sc.nextInt();
	       int[] array = new int[100100];
	       
	       for(int i = 0 ; i<n ; i++){
	         array[i] = sc.nextInt();
	       }
	       
	       
	       mergeSort(0,n-1,array);

	}
	
	 public static void mergeSort(int start, int end, int[] array){
	      if(start>=end){
	        return;
	      }else{
	        int mid = (start+end)/2;
	        mergeSort(start,mid,array);
	        mergeSort(mid+1,end,array);
	        
	        mergeNumber(start,mid,mid+1,end,array);
	        
	      }
	    }
	    
	    public static void mergeNumber(int s1, int e1, int s2, int e2, int[] array){
	      
	    	int e = s1;
	    	int q = s2;
	    	
	    	while(e<=e1 ||)
	    	
	    }
	

}
