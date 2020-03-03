package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SafeRegion2 {
	static int region[][] = new int[50][50];
	static boolean visit[][] = new boolean[50][50];
	static int N;
	static Queue q = new LinkedList();
	static int dx[] = {0, -1, 0, 1};
	static int dy[] = {-1, 0, 1, 0};
	static int max_high = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		for (int i=0; i<N; i++) {
			String arr[] = scan.nextLine().split(" ");
			for (int j=0;j<N;j++ ) {
				region[i][j] = Integer.parseInt(arr[j]);
				visit[i][j] = false;
				if(region[i][j]>max_high) {
					max_high = region[i][j];
				}
			}
		}
		int count = 0;
		int regionCount = 0;
		for (int k=0; k<max_high; k++) {
			
			for (int i=0;i<N;i++) {
				for(int j=0; j<N;j++) {
					if(region[i][j]>k && visit[i][j]==false) {
						count++;
						bfs(i, j, k);
					} 
				}
			}
			for(int i=0; i<N;i++) {
				for(int j=0;j<N;j++ ) {
					visit[i][j] = false;
				}
			}
			if(count>regionCount) {
				regionCount = count;
			}
			count = 0;
		}
	}
	public static void bfs(int horizon, int vertical, int high) {
		visit[horizon][vertical] = true;
		q.add(new Point(vertical, horizon));
		while(!q.isEmpty()) {
			Point pt = (Point)q.poll();
			for(int i=0;i<4;i++) {
				int x = dx[i] +pt.x;
				int y = dy[i] +pt.y;
				if(x>=0 && x<N && y>=0 && y<N) {
					if(region[y][x]>high && !visit[y][x]) {
						q.add(new Point(y,x));
						visit[y][x] = true;
					}
				}
			}
		}
	}
	
	
}
