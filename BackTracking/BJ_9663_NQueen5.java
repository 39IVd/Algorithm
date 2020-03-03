package BackTracking;

import java.util.Scanner;
import java.util.Stack;

//    Stack을 이용한 백트래킹

class Q {
    int col, row;
    public Q(int col, int row) {
        this.col = col;
        this.row = row;
    }
}
public class BJ_9663_NQueen5 {
    static int n;
    static Stack<Q> stack = new Stack<>();
    static int[] chess;
    static int res = 0;
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        n = in.nextInt();
        chess = new int[n];

//        첫번째 행의 모든 노드를 stack에 push
        for(int row=0;row<n;row++) {
            stack.push(new Q(0, row));
        }

//        stack이 빌 때까지 반복
        while (!stack.isEmpty()) {
            Q parent = stack.pop();
            if(parent.col==n-1) {
//                마지막 노드까지 도달하면 res++
                res++;
//                return을 하면 안되는 이유 ?
//                마지막 노드까지 탐색하고, stack이 전부 빌 때까지 반복해야 하기 때문
            }
            else {
//                현재 위치를 저장하고,
//                다음 행에 있는 모든 열에 대해 유망한 노드인지 검사
                chess[parent.col] = parent.row;
                for(int row=0;row<n;row++) {
                    Q curr = new Q(parent.col+1, row);
                    if(isValid(curr.col, curr.row)) {
//                        유망한 노드이면 push
                        stack.push(curr);
                    }
                }
            }
        }
        System.out.println(res);
    }
    public static boolean isValid(int col, int row) {
        for(int i=0;i<col;i++) {
            if((chess[i]==row)
                    ||(Math.abs(i-col)==Math.abs(chess[i]-row))) {
                return false;
            }
        }
        return true;
    }
}

//    Stack을 이용한 백트래킹
//    1. 첫번째 col부터 시작해서 전체 row를 stack에 넣음
//    2. stack에서 pop한 노드에서, 아래 col의 전체 row를 탐색하면서
//        (child 노드 탐색) 유망한 노드만 stack 에 넣음
//    3. 반복
//    4. pop한 노드의 col이 4이면, res ++하고 종료