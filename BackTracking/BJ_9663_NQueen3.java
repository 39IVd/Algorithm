package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Queen {
    int y, x;
    public Queen(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

// #######

public class BJ_9663_NQueen3 {
    static int n;
    static List<Queen> list = new LinkedList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(r.readLine());
        dfs(1, list);
        System.out.println(count);
    }
    public static void dfs(int y, List<Queen> list) {
        if(y==n+1) {
            count++;
            for(int k=0;k<list.size();k++) {
                System.out.println(list.get(k).y+", "+list.get(k).x);
            }
            System.out.println();
            return;
        }
        for(int j=1;j<=n;j++) { // 모든 행을 돌기
            boolean unblock = true;
            for(int k=0;k<list.size();k++) {
                Queen q = list.get(k);
                if(q.x==j||(Math.abs(y-q.y)==Math.abs(j-q.x))) {
                    // 행이 겹치거나 대각선상에 있으면
                    unblock = false;
                    // 놓을 수 없음
                }
            }
            if(unblock) {
                List<Queen> newList = new LinkedList<>();
                newList.addAll(list);
                // 원래 리스트를 저장
                newList.add(new Queen(y, j));
                dfs(y+1, newList);
            }
        }
    }
}
