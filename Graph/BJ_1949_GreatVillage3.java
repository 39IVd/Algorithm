//package Graph;
//
//import java.util.*;
//
////class Edge {
////    int a, b;
////    public Edge(int a, int b) {
////        this.a = a; this.b = b;
////    }
////}
//class Node implements Comparable<Node> {
//    int index, number, visited;
//    public Node(int index, int number, int visited) {
//        this.index = index;
//        this.number = number;
//        this.visited = visited;
//    }
//
//    @Override
//    public int compareTo(Node o) {
//        if(this.number>o.number) {
//            return -1;
//        }
//        else if(this.number<o.number) {
//            return 1;
//        }
//        else {
//            return 0;
//        }
//    }
//}
//
//public class BJ_1949_GreatVillage3 {
//    static Scanner in = new Scanner(System.in);
//    static int n;
//    static int[][] num = new int[100000][3];
//    static List<Integer> selectNodeList = new LinkedList<>();
//    static List<Edge> edgeList = new LinkedList<>();
//    static ArrayList<Node> nodes = new ArrayList<>();
//    public static void main(String[] args) {
//        n = in.nextInt();
//        int maxIndex = -1, max = 0;
//        for(int i=0;i<n;i++) {
//            int index = i;
//            int number = in.nextInt();
//            nodes.add(new Node(index, number, 0));
//        }
//        Collections.sort(nodes);
//        for(int i=0;i<n;i++) {
//            System.out.println("index : "+nodes.get(i).index+", number : "+nodes.get(i).number);
//        }
//        for(int i=0;i<n-1;i++) {
//            int a = in.nextInt(); int b = in.nextInt();
//            edgeList.add(new Edge(a, b));
//        }
//        int cnt = 0;
//        while (!nodes.isEmpty()) {
//            Node n = nodes.get(cnt);
//            n.visited = 1;
//            selectNodeList.add(n.index);
//            for(int i=0;i<edgeList.size();i++) {
//                Edge curr = edgeList.get(i);
//                if(curr.a==n.index) {
//                    num[curr.b][1] = 1;
//                }
//                else if(curr.b==n.index) {
//                    num[curr.a][1] = 1;
//                }
//            }
//            max = 0;
//            boolean all = false;
//            for(int i=1;i<=n;i++) {
//                if(max<num[i][0] && i!=maxIndex) {
//                    if(num[i][1]!=1) {
//                        max = num[i][0];
//                        maxIndex = i;
//                        all = true;
//                    }
//                }
//            }
////            System.out.println("maxIndex : "+maxIndex);
//            if(!all) {
//                break;
//            }
//            cnt++;
//        }
//        int res = 0;
//        for(int i=0;i<selectNodeList.size();i++) {
//            res += num[selectNodeList.get(i)][0];
//        }
//        System.out.println(res);
//
//    }
//}
