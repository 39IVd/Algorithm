package Study0922;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Planet {
    int  x, y, z;
    public Planet(int x, int y, int z) {
        this.x = x ; this.y = y;this.z =z;
    }
}

class Ternel implements Comparable<Ternel> {
    int a, b, dist;
    public Ternel(int a, int b, int dist) {
        this.a = a; this.b = b; this.dist=dist;
    }
//    @Override
    public int compareTo(Ternel o) {
        return Integer.compare(dist, o.dist);
    }
}

public class BJ_2887_PlanetTernel {
    static int n;
//    static int[][] pl;
    static Planet[] planets;
    static int[] parent;
    static ArrayList<Ternel> ternels = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
//        pl = new int[n+1][3]; // 메모리 초과
        planets = new Planet[n+1];
        parent = new int[n+1];
//        Arrays.fill(parent, -1);
        for(int i=1;i<=n;i++) {
//            pl[i][0] = in.nextInt(); pl[i][1] = in.nextInt(); pl[i][2] = in.nextInt();
            planets[i] = new Planet(in.nextInt(), in.nextInt(), in.nextInt());
            parent[i] = i;
        }
        for(int i=1;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
//                int m = Math.min(Math.abs(pl[i][0]-pl[j][0]), Math.abs(pl[i][1]-pl[j][1]));
//                m = Math.min(Math.abs(pl[i][2]-pl[j][2]), m);
                int m = Math.min(Math.abs(planets[i].x-planets[j].x), Math.abs(planets[i].y-planets[j].y));
                m = Math.min(Math.abs(planets[i].z-planets[j].z), m);
                ternels.add(new Ternel(i, j, m));
//                System.out.println("("+i+", "+j+") : "+m);
            }
        }
        Collections.sort(ternels);
//        for(int i=0;i<tsize;i++) {
//            System.out.println("("+tn[i].a+", "+tn[i].b+") : "+tn[i].dist);
//        }
        int cnt = 0; int total = 0;
        for(int i=0;cnt<n-1;i++) {
            if(find(ternels.get(i).a)!=find(ternels.get(i).b)) {
                union(ternels.get(i).a, ternels.get(i).b);
                total+= ternels.get(i).dist;
                cnt++;
            }
//            if(union(tn[i].a, tn[i].b)) {
//                total+= tn[i].dist;
//                cnt++;
//            }
        }
        System.out.println(total);
    }
    public static void union(int a, int b) {
        int aroot = find(a); int broot = find(b);
        parent[aroot] = broot;
    }
    public static int find(int a) {
        if(parent[a]==a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
//    public static boolean union(int a, int b) {
//        int aroot = find(a); int broot = find(b);
//        if(aroot==broot) {
//            return false;
//        }
//        parent[aroot] = broot;
//        return true;
//    }
}
