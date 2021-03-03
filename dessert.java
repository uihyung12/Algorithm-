package edu.java.algorithm;

import java.util.Scanner;

public class dessert {

	static int n;
	static int[] data = new int[20];
	static char[] result = new char[30];
	static int cnt = 0;
	static boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		getResult(1, n, 0);

		System.out.println(cnt);

	}

	static void getResult(int start, int end, int sum) {
		if (start > end) {
			if (sum == 0) {
				if(!flag) {
					System.out.print(data[1]);
					for (int i = 2; i <= end; i++) {
						System.out.printf(" %c %d",result[i],data[i]);
//					System.out.print(data[i]);
					}
					System.out.println();
					
				}
				cnt++;
				if(cnt>20) flag = true;
			}
		} else {
			if (start == 1) {
				data[start] = start;
				sum += start;
				getResult(start + 1, end, sum);
			} else {
				data[start] = start;
				for (int i = 0; i < 3; i++) {
					if (i == 0) {
						result[start] = '+';
						sum += start;
						getResult(start + 1, end, sum);
						sum -= start;
						result[start] = 0;
					} else if (i == 1) {
						result[start] = '-';
						sum -= start;
						getResult(start + 1, end, sum);
						sum += start;
						result[start] = 0;

					} else {
						result[start] = '.';
						if(result[start-1] == '+') {
							sum -= data[start-1];
							String number1 = Integer.toString(data[start-1]);
							String number2 = Integer.toString(data[start]);
							String number3 = number1+number2;
							int number = Integer.parseInt(number3);
							sum += number;
							getResult(start+1, end, sum);
							sum -= number;
							sum += data[start-1];
							result[start] = 0;
						}else if(result[start-1] == '-') {
							sum += data[start-1];
							String number1 = Integer.toString(data[start-1]);
							String number2 = Integer.toString(data[start]);
							String number3 = number1+number2;
							int number = Integer.parseInt(number3);
							sum -= number;
							getResult(start+1, end, sum);
							sum += number;
							sum -= data[start-1];
							result[start] = 0;
							
						}else if(result[start-1]=='.'){
//							System.out.printf("start : %d\n",start);
//							System.out.printf("sum : %d\n",sum);
							String number1 = String.valueOf(sum);
							System.out.printf("number1 : %d\n",number1);
							String number2 = Integer.toString(data[start]);
							System.out.printf("number2 : %d\n",number2);
							sum = 0;
							String number3 = number1+number2;
							System.out.printf("number3 : %d\n",number3);
							int number = Integer.parseInt(number3);
							sum += number;
							getResult(start+1, end, sum);
							sum -= number;
							sum += Integer.parseInt(number1);
							result[start] = 0;
							
						}else {
							sum -= data[start-1];
							String number1 = Integer.toString(data[start-1]);
							String number2 = Integer.toString(data[start]);
							String number3 = number1+number2;
							int number = Integer.parseInt(number3);
							sum += number;
							getResult(start+1, end, sum);
							sum -= number;
							sum += data[start+1];
							result[start] = 0;
						}
					}
				}

			}

		}

	}

}
