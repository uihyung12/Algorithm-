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

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		getResult(1, n);

		System.out.println(cnt);
	}

	public static void getResult(int start, int end) {
		if (start >= end) {
			data[start] = start;
			int sum = 0;
			String result = "";
			int index = -1;
			for (int i = 1; i <= end; i++) {
				if (!check[i]) {
					if (!check[1]) {
						sum += data[i];
						index = i;
						check[1] = true;
						continue;
					}
					else {
							if(!result.isEmpty()) {
								result += Integer.toString(data[i]);
								if(index<0) {
									sum += Integer.parseInt(result);
									index = i;
									result = "";
								}else {
									if(temp[index] == '+') {
										sum += Integer.parseInt(result);
										index = i;
										result = "";
										
									}else if(temp[index] == '-') {
										sum -= Integer.parseInt(result);
										index = i;
										result = "";
									}
									
								}
								
							}else {
								if(temp[index] == '+') {
									sum += data[i];
									index = i;
								}else if(temp[index] == '-'){
									sum -= data[i];
									index = i;
								}
							}
							
						
						
					}
					/**
					if (temp[i + 1] == '.') {
//						System.out.println("if 부분");
						if (!result.isEmpty()) {
							if (index <= 0) {
								result += Integer.toString(data[i]);
								sum += Integer.parseInt(result);
								result = "";
								index = i;

							} else {
								result += Integer.toString(data[i]);
								if(end-1 == i) {
									result += Integer.toString(data[i+1]);
									if(temp[index] == '+') {
										sum += Integer.parseInt(result);
									}else if(temp[index] == '-') {
										sum -= Integer.parseInt(result);
									}
									
								}
								
								if (temp[index] == '+') {
									sum += Integer.parseInt(result);
									result = "";
								} else if (temp[index] == '-') {
									sum -= Integer.parseInt(result);
									result = "";
								}

								index = i;

							}
						} else {
							result += Integer.toString(data[i]);
							index = i;
						}

					} else {
//						System.out.println("else");
						if (result.isEmpty()) {
							if (temp[index] == '+') {
								sum += data[i];
								index = i;
								if (end - 1 == index) {
									if (temp[index] == '+') {
										sum += data[i + 1];
									} else if (temp[index] == '-') {
										sum -= data[i + 1];
									}
								}
							} else if (temp[index] == '-') {
								sum -= data[i];
								index = i;
								if (end - 1 == i) {
									if (temp[index] == '+') {
										sum += data[i + 1];
									} else if (temp[index] == '-') {
										sum -= data[i + 1];
									}
								}
							}

//    							

						} else {
							result += Integer.toString(data[i]);
							sum += Integer.parseInt(result);
							result = "";
							index = i;

						}
					}

//    				}*/

				} else {
//					System.out.println(". 부분");
					result += Integer.toString(data[i]);
//					if (i == end - 1) {
//						result += Integer.toString(data[end]);
//						if (index <= 0) {
//							sum += Integer.parseInt(result);
//						} else {
//							if (temp[index] == '+') {
//								sum += Integer.parseInt(result);
//								result = "";
//
//							} else if (temp[index] == '-') {
//								sum -= Integer.parseInt(result);
//								result = "";
//
//							}
//
//						}
//					}
				}

			}
			check[1] = false;
			if (sum == 0) {
				if(!flag) {
					for (int i = 1; i < end; i++) {
						System.out.printf("%d %c ", data[i], temp[i]);
					}
					System.out.printf("%d", data[end]);
					System.out.println();
					
				}
				cnt++;
				if(cnt>20) flag = true;
			}

		} else {
			data[start] = start;
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					temp[start] = '+';
					getResult(start + 1, end);
					temp[start] = 0;
				} else if (i == 1) {
					temp[start] = '-';
					getResult(start + 1, end);
					temp[start] = 0;
				} else {
					temp[start] = '.';
					check[start] = true;
					getResult(start + 1, end);
					check[start] = false;
					temp[start] = 0;
				}

			}

		}

	}

}
