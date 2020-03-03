package Baekjoon;
 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1260_BFSandDFS {
	static int vNum;
	static int eNum;
	static int startV;
	static int[][] vertex;
	static boolean[] visit;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vNum = sc.nextInt();
		eNum = sc.nextInt();
		startV = sc.nextInt();
		sc.nextLine();
		vertex = new int[vNum][vNum];
		visit = new boolean[vNum];
		
		for(int i=0;i<eNum;i++) {
			int k = sc.nextInt();
			int v = sc.nextInt();
			vertex[k-1][v-1] = 1;
			vertex[v-1][k-1] = 1;
		}
		initVisit();
		DFS(startV);
		System.out.println();
		initVisit();
		BFS(startV);
	}
	public static void DFS(int start) {
		System.out.print(start+" ");
		visit[start-1] = true;
		for(int i=0;i<vNum;i++) {
			if(vertex[start-1][i]==1 && visit[i]==false) {
				DFS(i+1);
			}
		}
	}
	public static void BFS(int start) {
		Queue q = new LinkedList();
		q.add(start);
		visit[start-1] = true;
		int qsize = q.size(); 
		while(!q.isEmpty()) {
			int node = (int) q.poll();
			System.out.print(node+" ");
			for(int i=0;i<vNum;i++) {
				if(vertex[node-1][i]==1 && visit[i]==false) {
					q.add(i+1);
					visit[i] = true;
				}
			}
		}
	}
	public static void initVisit() {
		for(int i=0;i<vNum;i++) {
			visit[i] = false;
		}
	}
}
