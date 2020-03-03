package Study0807;

import java.util.Scanner;
import java.util.Stack;

public class BJ_1922_NetworkConnection {
    static int N, M;
    static int[] network;
    static int[][] matrix;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); M = in.nextInt();
        network = new int[N+1];
        matrix = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            network[i] = 1000;
            for(int j=1;j<=N;j++) {
                matrix[i][j] = 1000;
            }
        }
        for(int i=0;i<M;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            matrix[a][b] = in.nextInt();
            matrix[b][a] = matrix[a][b];
        }

        Calculate();
    }
    public static void Calculate() {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            visit[curr] = true;
            for(int i=1;i<=N;i++) {
                if(network[i]>matrix[curr][i]) {
                    network[i] = matrix[curr][i];
                    if(visit[i]!=true) {
                        stack.push(i);
                    }
                }
            }
        }
        int result = 0;
        for(int i=1;i<=N;i++) {
            result += network[i];
        }
        System.out.println(result);
    }
}
