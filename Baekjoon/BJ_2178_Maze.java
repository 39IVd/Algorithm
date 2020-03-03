package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class point_Maze {
	int x;
	int y;
	point_Maze(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class BJ_2178_Maze {
	static int N, M;
	static int[][] matrix;
	static int[][] visit;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		String[] h = new String[M];
		matrix = new int[N][M];
		visit = new int[N][M];
		for(int i=0;i<N;i++) {
			h = sc.nextLine().split("");
			for(int j=0;j<M;j++) {
				matrix[i][j] = Integer.parseInt(h[j]);
			}
		}
		findWay(0,0);
		System.out.println(matrix[N-1][M-1]); 
	}
	public static void findWay(int garo, int sero) {
		Queue q = new LinkedList();
		q.add(new point_Maze(garo,sero)); 
		visit[garo][sero] = 1;
		while(!q.isEmpty()) {
			point_Maze pt = (point_Maze) q.poll(); 
			for(int i=0;i<4;i++) {
				int horizon = pt.x + dx[i];
				int vertical = pt.y + dy[i];
				if(horizon>=0 && horizon<N && vertical>=0 && vertical<M) {
					if(matrix[horizon][vertical]==1 && visit[horizon][vertical]!=1) {
						visit[horizon][vertical]=1;  
						q.add(new point_Maze(horizon, vertical)); 
						matrix[horizon][vertical] = matrix[pt.x][pt.y]+1;
					}
				} 
			}
		} 
	}
}
