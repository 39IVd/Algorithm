package Baekjoon;

import java.util.Scanner;

// 숫자 정사각형

public class BJ_1051_NumberSquare {
	static int N, M;
	static int[][] matrix;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		scan.nextLine();
		String arr[] = new String[M];
		matrix = new int[N][M];
		for(int i=0;i<N;i++) {
			arr = scan.nextLine().split("");
			for(int j=0;j<M;j++) {
				matrix[i][j] = Integer.parseInt(arr[j]);
			}
		} 
		System.out.println(findSquare());
	}
	public static int findSquare() {
		int max_length = 1; // 길이 1로 초기화.
		int min = Math.min(N, M);
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<M-1;j++) {
				int k = j+1;
				while(k<N+j && k<M) {
					if(matrix[i][j]==matrix[i][k]) {
						int sub = k-j;
						if(i+sub<N && matrix[i][j]==matrix[i+sub][j]
								&&matrix[i][j]==matrix[i+sub][k]) {
							if(max_length<sub+1) {
								max_length = sub+1;
							}
						} 
					}
					k++;
				}
			}
		}
		return (int) Math.pow(max_length, 2);
	}
}
