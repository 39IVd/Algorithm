package BackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Point_Sudoku {
    int y, x;
    Point_Sudoku(int y, int x) {
        this.y=y;this.x=x;
    }
}
public class BJ_2239_Sudoku2 {
    static int[][] question = new int[9][9];
    static List<Point_Sudoku> empty = new LinkedList<>();
    static Scanner in = new Scanner(System.in);
    static boolean clear = false;
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
        Point_Sudoku first = empty.get(0);
        for(int i=1;i<10;i++) {
            question[first.y][first.x]=i;
            find(0, question);
        }
    }
    public static void find(int cnt, int[][] matrix) {
        if(cnt==empty.size()) {
//            System.out.println();
            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++) {
                    System.out.print(matrix[i][j]);
                }
                if(i!=8) {
                    System.out.println();
                }
            }
            clear = true;
            return;
        }
        if(clear) return;
        Point_Sudoku curr = empty.get(cnt);
        int num = matrix[curr.y][curr.x];

        for(int j=0;j<9;j++) {
            if(matrix[curr.y][j]==num&&curr.x!=j) {
                return;
            }
            else if(matrix[j][curr.x]==num&&curr.y!=j) {
                return;
            }
        }
        int ygroup = (int)(Math.floor(curr.y/3.0)*3);
        int xgroup = (int)(Math.floor(curr.x/3.0)*3);
        for(int j=ygroup;j<ygroup+3;j++) {
            for(int k=xgroup;k<xgroup+3;k++) {
                if(curr.y==j&&curr.x==k) {
                    continue;
                }
                if(matrix[j][k]==num) {
                    return;
                }
            }
        }
//        System.out.println(curr.y+","+curr.x+" : "+num);

        int[][] n_matrix = new int[9][9];
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                n_matrix[i][j] = matrix[i][j];
            }
        }
        if(cnt<empty.size()-1) {
            Point_Sudoku next = empty.get(cnt+1);
            for(int j=1;j<10;j++) {
                n_matrix[next.y][next.x]=j;
                find(cnt+1, n_matrix);
            }
        }
        else {
            find(cnt+1, n_matrix);
        }


    }
}
