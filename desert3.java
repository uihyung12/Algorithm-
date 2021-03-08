package com.java.practice;

import java.util.Scanner;

public class desert3 {
	
	static int totalCount = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0;
		
		int[] array = new int[25];
		int[] temp = new int[25];
		
		for(int i = 0 ; i<n ; i++) {
			array[i] = i+1;
		}
		
		int[] ine = new int[3];
		ine[0] = '+';
		ine[1] = '-';
		ine[2] = '.';
		
		dessert(0,n-1,0,temp,array,ine);

	}

	private static void dessert(int start, int end, int sum, int[] temp, int[] array, int[] ine) {
		// TODO Auto-generated method stub
		if(start>=end) {
			int result = array[0];
			
			int count = 0;
			int countSum = 0;
			int countTemp = 1;
			
			 for(int i=0; i<end; i++){
			      //
			      //printf("%d ",arr[i]);
			      //printf("%c ",temp[i]);
			      //
			      
			      if(i==0 && temp[i]==46){
			        result -= 1;
			      }
			      
			      if(temp[i-1]==46 && temp[i] !=46){
			        result += countSum;
			        count = 0;
			        countSum = 0;
			      }
			      
			      if(temp[i]==43 && temp[i+1]!=46){
			        result += array[i+1];
			        
			      }else if(temp[i]==45 && temp[i+1]!=46){
			        result -= array[i+1];
			        
			      }else if(temp[i]==46){
			        
			        if(count == 0){
			          if(i!=0 && temp[i-1]==43){
			            countTemp = 1;
			          }else if(temp[i-1]==45){
			            countTemp = -1;
			          }
			          if(array[i]>=9){
			            countSum = (array[i]*100 + array[i+1])*countTemp;
			          }else{
			            countSum = (array[i]*10 + array[i+1])*countTemp;
			          }
			          count++;
			          
			        }else{
			          if(array[i]>=9){
			            countSum = countSum * 100 + (array[i+1]*countTemp);
			          }else{
			            countSum = countSum * 10 + (array[i+1]*countTemp);
			          }
			          
			          count++;
			        }
			        
			        if(i==end-1){
			          result += countSum;
			        }
			        
			        if(count==end){
			          result -= 1;
			        }
			        
			      }
			    }
				
				
				
				
			}
			
			
			
		}
		
		
	}


