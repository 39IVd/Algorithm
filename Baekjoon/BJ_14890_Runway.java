package Baekjoon;

import java.util.Scanner;

// 경사로
class point_Runway {
	int x;
	int y;
	point_Runway(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class BJ_14890_Runway {
	static int N;
	static int L;
	static int[][] matrix;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		L = scan.nextInt();
		matrix = new int[N][N];
		scan.nextLine();
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr = scan.nextLine().split(" ");
			for (int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(arr[j]);
			}
		}
		findWay();
	}
	public static void findWay() {
		// column
		for(int i=0;i<N;i++) {
			int currH = matrix[i][0]; // 첫번째 칸의 높이 저장.
			int count = 1;
			int j=1;
			int tmp = matrix[i][j];
			while(tmp==currH) { // 전 칸과 높이 같으면 반복.
				count++;
				j++;
			}
			if(tmp==currH-1) {
				
			}
			else if(tmp==currH+1) {
				
			}
			else {
				// fail
			} 
		}
		
		// row
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
//				matrix[j][i]
			}
		}
	}
	

}
