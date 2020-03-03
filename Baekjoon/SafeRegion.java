package Baekjoon;
//안전 지역

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Point_ {
	int x;
	int y;
	Point_(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
public class SafeRegion {
	static int[][] map = new int[101][101];
	static boolean[][] visit = new boolean[101][101];
	static Queue q = new LinkedList();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;
	static int max_High = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				visit[i][j] = false;
				if (max_High < map[i][j]) {
					max_High = map[i][j];
				} // 모든 지역 중 가장 높은 지역을 max_High에 저장.
			}
		}
		int ans = 0;
		int cnt = 0;
		
		for (int k = 0; k < max_High; k++) {
			// 물에 잠기는 높이를 0부터 max_High까지 설정.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > k && !visit[i][j]) {
						// 물에 잠기지 않을 지역 중 방문하지 않은 지역을 차례대로 방문.
						cnt++; 
						bfs(i, j, k);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visit[i][j] = false;
				}
			} // 모든 지역의 visit를 false로 초기화.

			if (ans < cnt) {
				ans = cnt;
			} // 안전 영역이 최대인 곳을 ans에 저장.
			
			cnt = 0;
		}
		System.out.println(ans);
	}

	public static void bfs(int sero, int garo, int high) {
		visit[sero][garo] = true;
		q.add(new Point_(sero, garo));
		while (!q.isEmpty()) {
			Point_ pt = (Point_) q.poll();
			for (int i = 0; i < 4; i++) {
				int x = dx[i] + pt.x;
				int y = dy[i] + pt.y;
				if (x >= 0 && x < N && y >= 0 && y < N) {
					if (map[y][x] > high && !visit[y][x]) {
						// System.out.println(y + " " + x);
						q.add(new Point_(y, x));
						visit[y][x] = true;
					}
				}
			}
		}
	}
}