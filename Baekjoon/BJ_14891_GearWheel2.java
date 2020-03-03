package Baekjoon;
//톱니바퀴 

import java.util.HashMap;
import java.util.Scanner;

public class BJ_14891_GearWheel2 {
	static int[][] gear = new int[4][8];
	static int K;
	static HashMap<Integer, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] s = new String[8];
		for(int i=0;i<4;i++) {
			s = scan.nextLine().split("");
			for(int j=0;j<8;j++) {
				gear[i][j] = Integer.parseInt(s[j]);
			}
		}
		K = scan.nextInt();
		scan.nextLine();
		String[] s2 = new String[2];
		for(int l=0;l<K;l++) {
			map.clear();
			s2 = scan.nextLine().split(" ");
			Rotate(Integer.parseInt(s2[0]), Integer.parseInt(s2[1])); 
			for(int i=0;i<4;i++) {
				if(map.containsKey(i+1)) {
					if(map.get(i+1)==1) { // 시계방향.
						int tmp2 = gear[i][7];
						for(int j=7;j>0;j--) {
							gear[i][j] = gear[i][j-1];
						}
						gear[i][0] = tmp2;
					}
					else {
						int tmp2 = gear[i][0];
						for(int j=0;j<7;j++) {
							gear[i][j] = gear[i][j+1];
						}
						gear[i][7] = tmp2;
					}
				}
			} 
		} 
		System.out.println(Calculate());
	}
	
	public static void Rotate(int node, int direction) {
		map.put(node, direction);
		if(node<4) {
			if(gear[node-1][2]!=gear[node][6]) {
				RightR(node+1, -direction); 
			}
		}
		if(node>1) {
			if(gear[node-2][2]!=gear[node-1][6]) {
				LeftR(node-1, -direction); 
			}
		}
	} 
	public static void RightR(int node, int direction) {
		map.put(node, direction);
		if(node<4) {
			if(gear[node-1][2]!=gear[node][6]) {
				RightR(node+1, -direction);
			}
		}
	}
	public static void LeftR(int node, int direction) {
		map.put(node, direction);
		if(node>1) {
			if(gear[node-2][2]!=gear[node-1][6]) {
				LeftR(node-1, -direction);
			}
		}
	}

	public static int Calculate() {
		int score = 0;
		for(int i=0;i<4;i++) {
			score += gear[i][0]*Math.pow(2, i); 
		}
		return score;
	} 
}
