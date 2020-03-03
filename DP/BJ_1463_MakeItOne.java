package DP;
//1로 만들기

import java.util.Scanner;

public class BJ_1463_MakeItOne {
	static int result = 100;
	static int N;
	static int[] d;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
//		Calculate(N, 0);
//		System.out.println(result);
		d = new int[N+1];
		d[0] = d[1] = 0;
		DP();
		System.out.println(d[N]);
	}
	public static void DP() {
		 for(int i=2;i<=N;i++) {
			 d[i] = d[i-1]+1;
			 if(i%3==0 && d[i]>d[i/3]+1) {
				 d[i] = d[i/3]+1;
			 }
			 if(i%2==0 && d[i]>d[i/2]+1) {
				 d[i] = d[i/2]+1;
			 }
		 }
	}
	public static void Calculate(int num, int count) {
		if(num==1) {
			if(count<result) {
				result = count;
			}
		}
		else {
			if(num%3==0) {
				int threeCnt = count+1;
				Calculate(num/3, threeCnt);
			}
			if(num%2==0) {
				int twoCnt = count+1;
				Calculate(num/2, twoCnt);
			}
			int oneCnt = count+1;
			Calculate(num-1, oneCnt);
		}
	}
}
