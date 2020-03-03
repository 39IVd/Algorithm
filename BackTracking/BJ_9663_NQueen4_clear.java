package BackTracking;

import java.util.Scanner;

// 성공 => dfs 백트래킹 사용

public class BJ_9663_NQueen4_clear {
    static int n;
    static int[] queen;
    static int res = 0;
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        n = in.nextInt();
//        queen[col] = row 저장
        queen = new int[n];

        for(int row=0;row<n;row++) {
            queen[0] = row;
//            첫번째 퀸의 위치 : (1, row) = (행, 열)
            dfs(1);
//            두번째 행으로 이동해 dfs 수행
        }
        System.out.println(res);
    }
    public static void dfs(int col) {
        if(col==n) {
            res++;
            return;
        }
//        특정 행에 각 열에 대해서 유망한 노드인지 검사
        for(int row=0;row<n;row++) {
            queen[col] = row;
            if(isPossible(col)) {
                dfs(col+1);
//                유망하다면 현재 위치를 저장하고 서브트리로 이동해 dfs 수행
            }
            else {
//                유망하지 않다면 가지치기하고 이전으로 돌아감 (백트래킹)

//                return;
//                => return 을 하면 안되는 이유 ?
//                유망하지 않으면 이전으로 돌아가서 유망한 노드를 다시 탐색해야 하는데
//                return을 하면 탐색하고 있던 dfs 자체가 종료되기 때문.
            }
        }
    }
    public static boolean isPossible(int col) {
        for(int i=0;i<col;i++) {
            if((queen[col]==queen[i])
                    || (Math.abs(i-col)==Math.abs(queen[i]-queen[col]))) {
//                현재 놓은 퀸이 이전에 놓은 퀸들과 같은 열에 있거나,
//                대각선에 있으면 놓을 수 없음 => 유망하지 않음
                return false;
            }
        }
        return true;
    }
}

//    크기가 N*N 인 체스판 위에 N개의 퀸들을 서로 공격할 수 없게 놓음
//    퀸은 가로, 세로, 대각선 이동 가능
//    각 행에 하나의 퀸이 있어야 함
//    현재 퀸은 이전에 놓은 퀸들과 다른 열에 있어야 함
//    연산으로 대각선 위치인지 확인

//1. 첫번째 행부터 탐색
//2. 다음 행에 대해 dfs 수행
//3. for문으로 전체 열을 돌면서 현재 위치 저장
//4. 현재 위치가 유망한 노드인지 확인
//5. 유망하다면 서브트리로 이동 (dfs 수행)
//6. 유망하지 않다면 백트래킹 수행
//7. 전체 행을 탐색했다면 종료
