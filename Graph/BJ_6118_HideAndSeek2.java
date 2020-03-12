//package Graph;
//
////    그래프에서, 1번 노드로부터 거리가 가장 먼 노드의 번호와, 그 거리(거쳐야 하는 edge의 개수), 거리가 같은 다른 노드의 개수를 출력.
//
//import java.util.*;
//
//
//public class BJ_6118_HideAndSeek2 {
//    static Scanner in = new Scanner(System.in);
//    static int n, m;
//    static int[] d, visited;
////    static int[][] e;
////    static List<Integer>[] edge;
//    static List<edge_HS> edges = new LinkedList<>();
//    public static void main(String[] args) {
//        n = in.nextInt(); m = in.nextInt();
//        d = new int[n+1]; visited = new int[n+1];
////        e = new int[n+1][n+1];
////        edge = new List[n+1];
//        for(int i=1;i<=n;i++) {
//            d[i] = Integer.MAX_VALUE;
////            edge[i] = new LinkedList<>();
//        }
//        d[1]=0;
//
//        for(int i=0;i<m;i++) {
//            int a = in.nextInt(); int b = in.nextInt();
////            e[a][b] = 1; e[b][a] = 1;
////            edge[a].add(b); edge[b].add(a);
//            edges.add(new edge_HS(a, b));
//        }
//
//        int max = 0;
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        while (!q.isEmpty()) {
//            int curNode = q.poll();
////            System.out.println("cur : "+curNode);
//            visited[curNode] = 1;
//            for(int i=0;i<edges.size();i++) {
//                edge_HS e = edges.get(i);
//                if(curNode==e.a&&visited[e.b]==0) {
//                    d[e.b] = Math.min(d[e.b], d[curNode]+1);
//                    max = Math.max(max, d[e.b]);
//                    q.add(e.b);
//                }
//                else if(curNode==e.b&&visited[e.a]==0) {
//                    d[e.a] = Math.min(d[e.a], d[curNode]+1);
//                    max = Math.max(max, d[e.a]);
//                    q.add(e.a);
//                }
//            }
//        }
////        for(int i=1;i<=n;i++) {
////            System.out.print(d[i]+" ");
////        }
////        System.out.println();
//        int cnt = 0;
//        int index = 0;
//        for(int i=n;i>1;i--) {
//            if(d[i]==max) {
//                cnt++;
//                index = i;
//            }
//        }
//        System.out.println(index+" "+max+" "+cnt);
//    }
//}
