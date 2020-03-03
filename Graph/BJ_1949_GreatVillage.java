package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class BJ_1949_GreatVillage {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[] num = new int[10000];
    static int[][] map = new int[10000][10000];
    static int[] visited = new int[10000];

    static List<Integer> nodeXList = new LinkedList<>();
//    static Edge[] edges;
    static List<Edge> edgeList = new LinkedList<>();
    public static void main(String[] args) {
        n = in.nextInt();
//        edges = new Edge[n-1];
        int maxIndex = -1, max = 0;
        for(int i=0;i<n;i++) {
            num[i] = in.nextInt();
//            if(max<num[i]) {
//                max = num[i]; maxIndex = i;
//            }
        }
        for(int i=0;i<n-1;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            edgeList.add(new Edge(a, b));
            map[a][b] = 1; map[b][a] = 1;
        }
        nodeXList.add(edgeList.get(0).b);
        for(int i=1;i<n-1;i++) {
            Edge e = edgeList.get(i);
            boolean x = false;
            for(int j=0;j<nodeXList.size();j++) {
                if(e.a==nodeXList.get(j)||e.b==nodeXList.get(j)) {
                    x = true;
                    break;
                }
            }
            if(!x) {

            }
        }
        for(int i=0;i<nodeXList.size();i++) {
            System.out.println(nodeXList.get(i));
        }


    }
}
