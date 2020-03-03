package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_11866_Josephus {
    static int n, k;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); k = in.nextInt();
        for(int i=1;i<=n;i++) {
            q.add(i);
        }
        StringBuilder str = new StringBuilder();
        str.append("<");
        int i=0;
        while(!q.isEmpty()) {
            int num = q.poll();
            i++;
            if(i==k) {
                if(q.size()==0) {
                    str.append(num);
                    break;
                }
                str.append(num+", ");
                i=0;
            }
            else {
                q.add(num);
            }
        }
        str.append(">");
        System.out.println(str);
    }
}
