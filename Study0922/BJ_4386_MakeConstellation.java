package Study0922;

import java.util.HashSet;
import java.util.Scanner;

class Node_Cons {
    float x, y;
    Node_Cons par;
    public Node_Cons(float x, float y) {
        this.x = x; this.y = y;
        this.par = this;
    }
}
class Edge_Cons implements Comparable<Edge_Cons> {
    Node_Cons aNode, bNode;
    float dist;
    public Edge_Cons(Node_Cons a, Node_Cons b, float dist) {
        this.aNode = a; this.bNode = b;
        this.dist = dist;
    }

    @Override
    public int compareTo(Edge_Cons o) {
        return Float.compare(dist, o.dist);
    }
}

public class BJ_4386_MakeConstellation {
    static int n;
    static Node_Cons[] p;
    static Edge_Cons[] e;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        p = new Node_Cons[n+1];
        e = new Edge_Cons[(n*(n+1))/2];
        for(int i=1;i<=n;i++) {
            p[i] = new Node_Cons(in.nextFloat(), in.nextFloat());
            // 자기 자신을 parent로 설정
        }
        int c=0;
        for(int i=1;i<n;i++) {
            for(int j=i+1;j<=n;j++) {
                float x1 = p[i].x; float x2 = p[j].x;
                float y1 = p[i].y; float y2 = p[j].y;
                float dist = (float)Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
                e[c] = new Edge_Cons(p[i], p[j], dist);
                c++;
            }
        }
//        Arrays.sort(e);
        for(int i=0;i<c-1;i++) {
//            sort edge
            for(int j=i+1;j<c;j++) {
                if(e[i].dist>e[j].dist) {
                    float tmp = e[i].dist;
                    e[i].dist = e[j].dist;
                    e[j].dist = tmp;
                }
            }
        }
//        Kruskal Alg
//        int cnt = 0;
        float total = 0;
        int i=0;
        HashSet<Node_Cons> Tset = new HashSet<>();
        while(Tset.size()<=n-1) {
            if (getRoot(e[i].bNode) != e[i].aNode.par) {
                // cycle을 만들지 않음
                Tset.add(e[i].aNode); Tset.add(e[i].bNode);
                e[i].aNode.par = getRoot(e[i].bNode);
//                cnt++;
                total += e[i].dist;
            }
            i++;
        }
        System.out.println(Math.round(total*100)/100.0);
    }
    public static Node_Cons getRoot(Node_Cons node) {
        if(node.par==node) {
            return node;
        }
        else {
            return getRoot(node.par);
        }
    }
}
