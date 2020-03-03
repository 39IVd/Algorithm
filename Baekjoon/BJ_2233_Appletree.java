package Baekjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

class Node {
	Node parent;
	int data;
	Node(int data, Node parent) {
		this.data = data;
		this.parent = parent;
	}
}

public class BJ_2233_Appletree {
	static int N;
	static int[][] path;
	static int X, Y;
	static Stack stack = new Stack();
	static ArrayList<Node> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		path = new int[2][2*N];
		scan.nextLine();
		String[] s = new String[2*N];
		s = scan.nextLine().split("");
		int num = 1;
		for(int i=0;i<2*N;i++) {
			path[0][i] = Integer.parseInt(s[i]);
			if(path[0][i]==0) {
				path[1][i] = num;
				Node n;
				if(stack.isEmpty()) {
					n = new Node(num, null);
				}
				else {
					n = new Node(num, (Node) stack.peek());
				}
				list.add(n);
				stack.push(n); 
				num++;
			}
			else {
				path[1][i] = ((Node)stack.pop()).data;
			}
		}
		X = scan.nextInt(); Y = scan.nextInt(); scan.nextLine();
//		System.out.println();
//		for(int i=0;i<2;i++) {
//			for(int j=0;j<2*N;j++) {
//				System.out.print(path[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println(X+""+Y);
//		for(Node n : list) {
//			if(n.parent==null) {
//				System.out.println("data:"+n.data+", parent:null");
//			}
//			else {
//				System.out.println("data:"+n.data+", parent:"+n.parent.data);
//			}
//		}
		removeApple();
	}
	public static void removeApple() {
		int n1 = path[1][X-1];
		int n2 = path[1][Y-1];
		HashSet<Integer> hs1 = new HashSet<>();
		HashSet<Integer> hs2 = new HashSet<>();
		for(Node node : list) {
			if(node.data==n1) {
				hs1.add(node.data);
				while(node.parent!=null) {
					node = node.parent;
					hs1.add(node.data); 
				}
			}
		}
		for(Node node : list) {
			if(node.data==n2) {
				hs2.add(node.data);
				while(node.parent!=null) {
					node = node.parent;
					hs2.add(node.data); 
				}
			}
		}
//		System.out.println(hs1+" "+hs2);
		hs1.retainAll(hs2); 
//		System.out.println(hs1);
		int max = 0; 
		for(int data : hs1) {
			if(max<data) {
				max = data;
			}
		}
		for(int i=0;i<2*N;i++) {
			if(path[1][i]==max) {
				System.out.print((i+1)+" ");
			}
		}
	} 
}
