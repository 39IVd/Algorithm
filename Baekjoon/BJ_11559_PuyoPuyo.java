package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point_Puyo {
	int x;
	int y;
	point_Puyo(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BJ_11559_PuyoPuyo {
	static String[][] matrix  = new String[12][6];
	static int[][] visit = new int[12][6];
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0}; 
	static ArrayList<point_Puyo> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[6];
		for(int i=0;i<12;i++) {
			arr = sc.nextLine().split("");
			for(int j=0;j<6;j++) {
				matrix[i][j] = arr[j];
			}
		}
		Pang();
	}
	public static void Pang() {
		int result = 0;
		while(true) { // bfs>=4 인게 없으면 종료. (터질게 없으면 종료.)
			boolean isPang = false;
			initVisit();
			for(int i=11;i>=0;i--) {
				for(int j=0;j<6;j++) {
					if(!matrix[i][j].equals(".")) {
						if(BFS(i, j)) { // 터질게 한번이라도 있으면. 
							isPang = true; // 터질게 있다.
						}
					}
				}
			}
			if(isPang) { 
				// 연쇄 + 1
				result++;
				Down(); // 아래로 내려옴
			}
			else {
				break;
			}
		}
		System.out.println(result);
	}
	public static void Down() {
		 for(int i=11;i>=0;i--) {
			 for(int j=0;j<6;j++) {
				 int column = i+1;
				 if(!matrix[i][j].equals(".")) {
					 String mark = matrix[i][j];
					 matrix[i][j] = ".";
					 while(isRange(column, j) && matrix[column][j].equals(".")) {
						 column++;
					 }
					 matrix[column-1][j] = mark;
				 } 
			 }
		 }
	}
	public static boolean BFS(int h, int v) {
		Queue q = new LinkedList();
		q.add(new point_Puyo(h, v));
		int cnt = 1;
		visit[h][v] = 1;  
		
		while(!q.isEmpty()) {
			point_Puyo pt = (point_Puyo) q.poll();  
			list.add(pt);
			String color = matrix[pt.x][pt.y];
			for(int i=0;i<4;i++) {
				int horizon = pt.x + dx[i];
				int vertical = pt.y + dy[i];
				if(isRange(horizon, vertical)) {
					if(matrix[horizon][vertical].equals(color) && visit[horizon][vertical]!=1) {
						visit[horizon][vertical]=1;  
						q.add(new point_Puyo(horizon, vertical));  
						cnt++;
					}
				} 
			}
		}
		if(cnt>=4) { // cnt>=4 이면 .으로 변경.
			for(point_Puyo point : list) {
				matrix[point.x][point.y] = ".";
			}
			list.clear();
			return true;
		}
		else {  
			list.clear();
			return false;
		}
	}
	public static void initVisit() {
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				visit[i][j] = 0;
			}
		}
	}
	public static boolean isRange(int x, int y) {
		if(x>=0 && x<12 && y>=0 && y<6) {
			return true;
		}
		else {
			return false;
		}
	}
}
