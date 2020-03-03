package Baekjoon;
//톱니바퀴 

import java.util.HashMap;
import java.util.Scanner;

public class BJ_14891_GearWheel {
	static int[][] gear = new int[4][8];
	static int K;
	static int[][] rotation;
	static HashMap<Integer, Integer> map = new HashMap<>();
	static boolean[] adjNode = new boolean[3]; // 인접한 톱니바퀴의 극이 다르면 t, 같으면 n
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
		rotation = new int[K][2];
		scan.nextLine();
		String[] s2 = new String[2];
		for(int i=0;i<K;i++) {
			s2 = scan.nextLine().split(" ");
			Rotate(Integer.parseInt(s2[0]), Integer.parseInt(s2[1])); 
		} 
		System.out.println(Calculate());
	} 
	public static void Rotate(int node, int direction) {
		initAdjacent();
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(node, direction);
		int tmp = node;
		while(tmp<4) {
			if(!adjNode[tmp-1]) {
				break;
			} 
			direction = -direction;
			map.put(tmp+1, direction); 
			tmp++;
		}
		
		tmp = node;
		while(tmp>1) {
			if(!adjNode[tmp-2]) {
				break;
			}
			direction = -direction;
			map.put(tmp-1, direction); 
			tmp--;
		} 
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
	public static int Calculate() {
		int score = 0;
		for(int i=0;i<4;i++) {
			score += gear[i][0]*Math.pow(2, i); 
		}
		return score;
	}
	public static void initAdjacent() { // 인접한 톱니바퀴 의 극 확인
		for(int i=0;i<3;i++) {
			if(gear[i][2]==gear[i+1][6]) {
				adjNode[i] = false;
			}
			else {
				adjNode[i] = true; // 극이 다름.
			}
		} 
//		System.out.print("adjNode: ");
//		for(int i=0;i<3;i++) {
//			System.out.print(adjNode[i]+" ");
//		}
//		System.out.println("\n");
		// ex> adjNode = {false, true, false} : 2번째와 3번째 톱니바퀴의 극만 다름.
	}
}
