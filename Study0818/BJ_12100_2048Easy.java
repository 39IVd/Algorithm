package Study0818;

import java.util.Scanner;

public class BJ_12100_2048Easy {
    static int n;
    static int[][] o_matrix;
    static int[][] n_matrix;
    static int max = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        o_matrix = new int[n][n];
        n_matrix = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                o_matrix[i][j] = in.nextInt();
            }
        }
        move(o_matrix, 0);
        System.out.println(max);
    }
    public static void move(int[][] matrix, int cnt) {
        if(cnt==5) {
//            System.out.println("end");
            return;
        }
        initMatrix(matrix);
        for(int i=0;i<n;i++) { // left
            for(int j=n-1;j>0;j--) {
                if(n_matrix[i][j]!=0) {
                    if(n_matrix[i][j]==n_matrix[i][j-1]) {
                        n_matrix[i][j-1] += n_matrix[i][j];
                        n_matrix[i][j] = 0;
                    }
                    else if(n_matrix[i][j-1]==0) {
                        n_matrix[i][j-1] = n_matrix[i][j];
                        n_matrix[i][j] = 0;
                    }
                }
            }
        }
//        System.out.println("left");
//        printMatrix(n_matrix);
        move(n_matrix, cnt+1);
        initMatrix(matrix);
        for(int j=n-2;j>=0;j--) {
            for(int i=0;i<n;i++) { // right
                if(n_matrix[i][j]!=0) {
                    if(n_matrix[i][j]==n_matrix[i][j+1]) {
                        n_matrix[i][j+1] += n_matrix[i][j];
                        n_matrix[i][j] = 0;
                    }
                    else if(n_matrix[i][j+1]==0) {
                        n_matrix[i][j+1] = n_matrix[i][j];
                        n_matrix[i][j] = 0;
                    }
                }
            }
        }
//        System.out.println("right");
//        printMatrix(n_matrix);
        move(n_matrix, cnt+1);
        initMatrix(matrix);
        for(int i=n-2;i>=0;i--) { // down
            for(int j=0;j<n;j++) {
                if(n_matrix[i][j]!=0) {
                    if(n_matrix[i][j]==n_matrix[i+1][j]) {
                        n_matrix[i+1][j] += n_matrix[i][j];
                        n_matrix[i][j] = 0;
                    }
                    else if(n_matrix[i+1][j]==0) {
                        n_matrix[i+1][j] = n_matrix[i][j];
                        n_matrix[i][j] = 0;
                    }
                }
            }
        }
//        System.out.println("down");
//        printMatrix(n_matrix);
        move(n_matrix, cnt+1);
        initMatrix(matrix);
        for(int i=1;i<n;i++) { // up
            for(int j=0;j<n;j++) {
                if(n_matrix[i][j]!=0) {
                    if(n_matrix[i][j]==n_matrix[i-1][j]) {
                        n_matrix[i-1][j] += n_matrix[i][j];
                        n_matrix[i][j] = 0;
                    }
                    else if(n_matrix[i-1][j]==0) {
                        n_matrix[i-1][j] = n_matrix[i][j];
                        n_matrix[i][j] = 0;
                    }
                }
            }
        }
//        System.out.println("up");
//        printMatrix(n_matrix);
        move(n_matrix, cnt+1);
        initMatrix(matrix);
    }
    public static void initMatrix(int[][] matrix) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                n_matrix[i][j] = matrix[i][j];
                max = Math.max(max, n_matrix[i][j]);
            }
        }
    }
//    public static void printMatrix(int[][] matrix) {
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
