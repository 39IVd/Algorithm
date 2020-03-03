package Study0803;

import java.util.Scanner;

public class BJ_1018_PaintChessBoard {
    static int N, M;
    static String[][] board;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); M = in.nextInt();
        in.nextLine();
        board = new String[N][M];
        for(int i=0;i<N;i++) {
            board[i] = new String[M];
            board[i] = in.nextLine().split("");
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<=N-8;i++) {
            for(int j=0;j<=M-8;j++) {
                result = Math.min(result, Solve(i, j));
            }
        }
        System.out.println(result);
    }
    public static int Solve(int x, int y) {
        int cnt1 = 0;
        String tmp = "W";
        for(int i=x;i<x+8;i++) {
            if(!board[i][y].equals(tmp)) {
                cnt1++;
            }
            for(int j=y+1;j<y+8;j++) {
                if(board[i][j].equals(tmp)) {
                    cnt1++;
                    if (tmp.equals("W")) {
                        tmp = "B";
                    } else {
                        tmp = "W";
                    }
                }
                else {
                    tmp = board[i][j];
                }
            }
        }
        int cnt2 = 0;
        tmp = "B";
        for(int i=x;i<x+8;i++) {
            if(!board[i][y].equals(tmp)) {
                cnt2++;
            }
            for(int j=y+1;j<y+8;j++) {
                if(board[i][j].equals(tmp)) {
                    cnt2++;
                    if (tmp.equals("W")) {
                        tmp = "B";
                    } else {
                        tmp = "W";
                    }
                }
                else {
                    tmp = board[i][j];
                }
            }
        }
        return cnt1<cnt2?cnt1:cnt2;
    }
}
