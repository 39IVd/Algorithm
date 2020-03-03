package BackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Chess {
    int x, y;
    public Chess(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ_9663_NQueen2 {
    static int n;
    static List<Chess> list = new LinkedList<>();
    static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dfs(0, list);
        System.out.println(count);
    }
    public static void dfs(int q, List<Chess> list) {
        if(q==n-1) {
            count++;
            for(int i=0;i<list.size();i++) {
                System.out.println(list.get(i).x+", "+list.get(i).y);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++) {
            List<Chess> newList = new LinkedList<>();
            newList.addAll(list);
            boolean unblock = true;
            for(int j=0;j<newList.size();j++) {
                Chess prevC = newList.get(j);
                if(i==prevC.y||(Math.abs(prevC.x-prevC.y)==Math.abs(q-i))) {
                    unblock = false;
                    break;
                }
            }
            if(unblock) {
                newList.add(new Chess(q, i));
                dfs(q+1, newList);
            }
        }
    }

}
