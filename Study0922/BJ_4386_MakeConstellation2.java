package Study0922;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge_Cons2 implements Comparable<Edge_Cons2> {
    int aNode, bNode;
    float dist;
    public Edge_Cons2(int a, int b, float dist) {
        this.aNode = a; this.bNode = b;
        this.dist = dist;
    }
    @Override
    public int compareTo(Edge_Cons2 o) {
        return Float.compare(this.dist, o.dist);
    }
}
public class BJ_4386_MakeConstellation2 {
    static int n;
    static float[][] node;
    static int[] parent;
    static ArrayList<Edge_Cons2> edges = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        node = new float[n+1][2];
        parent = new int[n+1];
        for(int i=1;i<=n;i++) {
            node[i][0] = in.nextFloat(); node[i][1] = in.nextFloat();
            parent[i] = i;
        }
        for(int i=1;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                float x1 = node[i][0]; float x2 = node[j][0];
                float y1 = node[i][1]; float y2 = node[j][1];
                float dist = (float)Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
                edges.add(new Edge_Cons2(i, j, dist));
            }
        }
        Collections.sort(edges);
//        Kruskal Alg
        int cnt = 0; float total = 0;
        for(int i=0;cnt<n-1;i++) {
            if(find(edges.get(i).aNode)!=find(edges.get(i).bNode)) {
                union(edges.get(i).aNode, edges.get(i).bNode);
                total += edges.get(i).dist;
                cnt++;
            }
        }
        double per = Double.parseDouble(String.format("%.2f",total));
        System.out.println(per);
    }
    public static void union(int a, int b) {
        int aroot = find(a); int broot = find(b);
        parent[aroot] = broot;
    }
    public static int find(int a) {
        if(parent[a]==a) {
            return a;
        }
        else {
            return parent[a] = find(parent[a]);
        }
    }
}
