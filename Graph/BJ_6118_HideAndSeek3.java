package Graph;

//    그래프에서, 1번 노드로부터 거리가 가장 먼 노드의 번호와, 그 거리(거쳐야 하는 edge의 개수), 거리가 같은 다른 노드의 개수를 출력.
//    dijkstra 알고리즘 사용.

//    1. 모든 노드의 가중치 d를 Integer.MAX_VALUE 값으로 초기화한다.
//    2. 1번 노드와 인접한 노드의 d를 1로 변경하고, 1번을 포함한 인접 노드의 visited값을 1로 변경한다.
//    3. 모든 노드와 d를 Priority Queue에 추가한다. (d가 작은 순으로 poll되게 함.)
//    4. while문을 n-1번(n : 정점의 개수) 돌면서,
//        4-1. pq에서 노드를 poll한다. => 현재 노드
//        4-2. for 문을 돌면서, 현재 노드와 인접한 노드들 중, visited가 0인 노드 => adj라 칭한다.
//            - d[adj] = Math.min(d[adj], d[현재 노드]+1) 로 변경한다. 즉, 거리의 최솟값을 저장한다.
//            - visited[adj] = 1 로 변경한다.
//        4-3. 현재 노드의 d의 max값을 저장하고, max가 같은 노드들의 개수와 그 중 가장 작은 index를 저장한다.

import java.util.*;

class node_HS implements Comparable<node_HS>{
    int v, d;
    node_HS(int v, int d) {
        this.v = v; this.d = d;
    }
//    오름차순 정렬
    @Override
    public int compareTo(node_HS o) {
        if(o.d>this.d) return -1;
        else if(o.d<this.d) return 1;
        else return 0;
    }
}

public class BJ_6118_HideAndSeek3 {
    static Scanner in = new Scanner(System.in);
    static int n, m;
    static int[] d = new int[20001], visited= new int[20001];
    static PriorityQueue<node_HS> q = new PriorityQueue<>();
    static List<Integer>[] edges = new List[50001];
    public static void main(String[] args) {
        n = in.nextInt(); m = in.nextInt();
        for(int i=1;i<=n;i++) {
            d[i] = Integer.MAX_VALUE;
            q.add(new node_HS(i, Integer.MAX_VALUE));
            edges[i] = new LinkedList<>();
        }
        visited[1] = 1;
        int target;
        for(int i=0;i<m;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            edges[a].add(b); edges[b].add(a);
            if(a==1) target = b;
            else if(b==1) target = a;
            else continue;
            q.add(new node_HS(target, 1));
            d[target] = 1;
            visited[target] = 1;
        }
        int maxDist = 0, cnt = 1;
        int sameDist =1, minIndex = Integer.MAX_VALUE;
        while (cnt<n) {
            node_HS curNode = q.poll();
            if(maxDist<curNode.d) {
                sameDist = 1;
                minIndex = curNode.v;
                maxDist = curNode.d;
            }
            else if(maxDist==curNode.d) {
                sameDist++;
                minIndex = Math.min(minIndex, curNode.v);
            }
//            System.out.println("cur : "+curNode.v+" d : "+curNode.d);
            for(int i=0;i<edges[curNode.v].size();i++) {
                int adj = edges[curNode.v].get(i);
                if(visited[adj]==0) {
                    d[adj] = Math.min(d[adj], d[curNode.v]+1);
                    q.add(new node_HS(adj, d[adj]));
                    visited[adj] = 1;
                }

            }
            cnt++;
        }
        System.out.println(minIndex+" "+maxDist+" "+sameDist);
    }
}
