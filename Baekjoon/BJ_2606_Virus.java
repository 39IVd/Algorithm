package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2606_Virus {
	static int vNum;
	static int eNum;
	static int[][] Graph;
	static int[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vNum = sc.nextInt();
		eNum = sc.nextInt();
		sc.nextLine();
		Graph = new int[vNum][vNum];
		visit = new int[vNum];
		for(int i=0;i<eNum;i++) {
			int k = sc.nextInt();
			int v = sc.nextInt();
			Graph[k-1][v-1] = 1;
			Graph[v-1][k-1] = 1;
		}
		BFS(1);
	} 
	public static void BFS(int v) {
		int cnt = -1;
		Queue q = new LinkedList();
		q.add(v);
		visit[v-1] = 1;
		while(q.size()>0) {
			int node = (int) q.poll();
			for(int i=0;i<vNum;i++) { 
				if(Graph[node-1][i]==1 && visit[i]!=1) {
					visit[i] = 1;
					q.add(i+1);
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
