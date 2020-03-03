package Study0803;

import java.util.Scanner;

public class BJ_1890_Jump {
    static int N;
    static int[][] matrix;
    static long[][] dm;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        matrix = new int[N][N];
        dm = new long[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                matrix[i][j] = in.nextInt();
                dm[i][j] = 0;
            }
        }
        DP();
    }
    public static void DP() {
        dm[0][0] = 1;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i<N-1||j<N-1) {
                    int jump = matrix[i][j];
                    if(j+jump<N) { // right
                        dm[i][j+jump] += dm[i][j];
                    }
                    if(i+jump<N) { // down
                        dm[i+jump][j] += dm[i][j];
                    }
                }
            }
        }
        System.out.println(dm[N-1][N-1]);
    }
}
