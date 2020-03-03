package Study0922;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Ternel2 implements Comparable<Ternel2>{
    int a, b, dist;
    public Ternel2(int a, int b, int dist) {
        this.a = a; this.b = b; this.dist=dist;
    }
    @Override
    public int compareTo(Ternel2 o) {
        return this.dist<o.dist? -1:1;
    }
}
class Planet2 {
    int x, y, z, idx;
    public Planet2(int x, int y, int z, int idx) {
        this.x =x;this.y=y;this.z=z;this.idx=idx;
    }
}

public class BJ_2887_PlanetTernel2 {
    static int n;
    static int[] parent;
    static Planet2[] p;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        parent = new int[n];
        p = new Planet2[n];
        for(int i=0;i<n;i++) {
            p[i] = new Planet2(in.nextInt(), in.nextInt(), in.nextInt(), i);
            parent[i] = i;
        }
        PriorityQueue<Ternel2> pq = new PriorityQueue<>();

        Comparator<Planet2> cp = (o1, o2) -> o1.x<o2.x? -1 : 1;
        Arrays.sort(p, cp);
        for(int i=1;i<n;i++) {
            pq.add(new Ternel2(p[i-1].idx, p[i].idx, Math.abs(p[i].x-p[i-1].x)));
        }
        cp = ((o1, o2) -> o1.y<o2.y? -1 : 1);
        Arrays.sort(p, cp);
        for(int i=1;i<n;i++) {
            pq.add(new Ternel2(p[i-1].idx, p[i].idx, Math.abs(p[i].y-p[i-1].y)));
        }
        cp = ((o1, o2) -> o1.z<o2.z? -1 : 1);
        Arrays.sort(p, cp);
        for(int i=1;i<n;i++) {
            pq.add(new Ternel2(p[i-1].idx, p[i].idx, Math.abs(p[i].z-p[i-1].z)));
        }
//        for(int i=1;i<n;i++) {
//            for(int j=i+1;j<=n;j++) {
//                int m = Math.min(Math.abs(pl[i][0]-pl[j][0]), Math.abs(pl[i][1]-pl[j][1]));
//                m = Math.min(Math.abs(pl[i][2]-pl[j][2]), m);
////                ternels.add(new Ternel(i, j, m));
//                tn[c++] = new Ternel2(i, j, m);
////                System.out.println("("+i+", "+j+") : "+m);
//            }
//        }
//        모든 간선 입력 -> 메모리 초과
        int cnt = 0; int total = 0;
        while(!pq.isEmpty()&&cnt<n) {
            Ternel2 t = pq.poll();
            if(find(t.a)!=find(t.b)) {
                union(t.a, t.b);
                total+= t.dist;
//                System.out.println(t.a+", "+t.b);
                cnt++;
            }
        }
        System.out.println(total);

    }
    public static int find(int a) {
        if(parent[a]==a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    public static void union(int a, int b) {
        int aroot = find(a); int broot = find(b);
        parent[aroot] = broot;
    }
}
