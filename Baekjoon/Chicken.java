package Baekjoon;


import java.util.*;

public class Chicken {

	static int n, m, cnt, ans = 987654321;

	static int[][] a = new int[51][51];

	static List<Point> chi = new ArrayList<>();

	static List<Point> home = new ArrayList<>();

	static boolean[] c = new boolean[14];

	static int dist(Point a, Point b) {

		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);

	}

	static void go(int idx, int num) {

		if (idx > chi.size())
			return;

		if (num == m) {

			int total = 0;

			for (int i = 0; i < home.size(); i++) {

				int temp = 987564321;

				for (int j = 0; j < chi.size(); j++) {

					if (!c[j])
						continue;

					temp = Math.min(temp, dist(chi.get(j), home.get(i)));

				}

				total += temp;

			}

			ans = Math.min(ans, total);

			return;

		}

		go(idx + 1, num);

		c[idx] = true;

		go(idx + 1, num + 1);

		c[idx] = false;

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		m = in.nextInt();

		for (int i = 0; i < n; i++)

			for (int j = 0; j < n; j++) {

				a[i][j] = in.nextInt();

				switch (a[i][j]) {

				case 1:

					home.add(new Point(i, j));

					break;

				case 2:

					chi.add(new Point(i, j));

					break;

				}

			}

		go(0, 0);

		System.out.println(ans);

		in.close();

	}

	

}