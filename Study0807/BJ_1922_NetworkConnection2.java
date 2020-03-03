package Study0807;

import java.util.PriorityQueue;
import java.util.Scanner;

class Line implements Comparable<Line> {
    int a, b, v;
    public Line(int a, int b, int v) {
        this.a = a;
        this.b = b;
        this.v = v;
    }
    @Override
    public int compareTo(Line o) {
        return o.v>=this.v? -1:1;
    }
}

public class BJ_1922_NetworkConnection2 {
    static int N, M;
    static int[] parent;
    static PriorityQueue<Line> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); M = in.nextInt();
        parent = new int[N+1];
        for(int i=0;i<M;i++) {
            pq.add(new Line(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }
        int result = 0;
        for(int i=0;i<M;i++) {
            Line l = pq.poll();
            if(find(l.a)!=find(l.b)) {
                result += l.v;
                union(l.a, l.b);
            }
        }
        System.out.println(result);
    }
    public static void union(int a, int b) {
        int aroot = find(a);
        int broot = find(b);
        parent[aroot] = broot;
        if(aroot!=broot) {
            parent[aroot] = b;
        }
    }
    public static int find(int a) {
        if(parent[a]==a) {
            return a;
        }
        return find(parent[a]);
    }
}
