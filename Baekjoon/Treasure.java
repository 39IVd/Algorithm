package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class point {
	int x;
	int y;
	point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Treasure { 
	static String[][] map = new String[51][51];
	static boolean[][] visit = new boolean[51][51];
	static int N;
	static int M; 
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String[] arr = sc.nextLine().split("");
			for (int j = 0; j < arr.length; j++) {
				map[i][j] = arr[j];
				visit[i][j] = false;
			}
		}
		// 2차원 배열의 크기와 L/W 입력
		findWay();
	}

	public static void findWay() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j].equals("W"))
					continue;
				// "L"지역인 곳을 찾아 차례대로 bfs 한다.
				int temp = bfs(i, j);
				// bfs 해서 최단 거리를 temp에 저장.
				if (temp > max) {
					max = temp;
				}
			}
		}
		System.out.println(max);
	}

	public static int bfs(int sero, int garo) {
		int cnt = -1;
		initBool(); // visit을 전부 false로 초기화.

		Queue q = new LinkedList();
		point p = new point(sero, garo);
		q.add(p); // queue에 현재 노드 추가.
		visit[sero][garo] = true;

		while (!q.isEmpty()) { // queue가 전부 빌때까지 반복.
			cnt++;
			int qsize = q.size();
 
			for (int k = 0; k < qsize; k++) {
				point pt = (point) q.poll();
				// queue에 있는 노드를 꺼냄.
				for (int i = 0; i < 4; i++) { // 상 하 좌 우 이동.
					int x = dx[i] + pt.x;
					int y = dy[i] + pt.y;
					if (y >= 0 && y < N && x >= 0 && x < M) {  
						// 노드가 말단에 있지 않으면.
						if (map[x][y].equals("L") && !visit[x][y]) {
							// "L"지역이고 방문하지 않았으면 queue에 추가.
							q.add(new point(x, y));
							visit[x][y] = true;
						}
					}
				}
			}
		}
		return cnt;
		// 최단 거리를 return.
	}

	public static void initBool() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = false;
			}
		}
	}

}
