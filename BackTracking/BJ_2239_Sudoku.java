package BackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class BJ_2239_Sudoku {
    static int[][] question = new int[9][9];
    static int[][] answer = new int[9][9];
    static int[] other = new int[10];
    static List<Point_Sudoku> empty = new LinkedList<>();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        for(int i=0;i<9;i++) {
            String[] s = in.nextLine().split("");
            for(int j=0;j<9;j++) {
                question[i][j] = Integer.parseInt(s[j]);
                if(question[i][j]==0) {
                    empty.add(new Point_Sudoku(i, j));
                }
            }
        }
        find(-1, question);
    }
    public static void find(int cnt, int[][] matrix) {
        int[][] n_matrix = new int[9][9];
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                n_matrix[i][j] = matrix[i][j];
            }
        }
        for(int i=cnt+1;i<empty.size();i++) {
            Point_Sudoku curr = empty.get(i);
            for(int j=0;j<9;j++) {
                if(n_matrix[curr.y][j]!=0) {
                    int number = n_matrix[curr.y][j];
                    other[number] = 1;
                }
                else if(n_matrix[j][curr.x]!=0) {
                    int number = n_matrix[j][curr.x];
                    other[number] = 1;
                }
            }
            int ygroup = (int)(Math.floor(curr.y/3.0)*3);
            System.out.println(curr.y+"=>"+ygroup);
            int xgroup = (int)(Math.floor(curr.x/3.0)*3);
            System.out.println(curr.x+"=>"+xgroup);
            for(int j=ygroup;j<ygroup+3;j++) {
                for(int k=xgroup;k<xgroup+3;k++) {
                    if(n_matrix[j][k]!=0) {
                        int number = n_matrix[j][k];
                        other[number] =1;
                    }
                }
            }

        }
    }
}
