package Study0824;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class BJ_2437_Scale {
    static int N;
    static int[] arr;
    static int[] visited;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N];
        visited = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = in.nextInt();
        }
        for(int i=1;i<=N;i++) {
            for(int j=0;j<N;j++) {
                visited[j] = 0;
            }
            find(i, 0, 0);
        }
        int i=1;
//        System.out.println(set);
        Iterator<Integer> it = set.iterator();
        while(true) {
            if(i!=it.next()) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
    public static void find(int r, int cnt, int sum) {
        if(cnt==r) {
            return;
        }
        for(int i=0;i<N;i++) {
            if(visited[i]!=1) {
                visited[i] = 1;
                find(r, cnt+1, sum+arr[i]);
                set.add(sum+arr[i]);
                visited[i] = 0;
            }
        }
    }
}
