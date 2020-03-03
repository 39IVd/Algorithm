package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Edge {
    int a, b;
    public Edge(int a, int b) {
        this.a = a; this.b = b;
    }
}

public class BJ_1949_GreatVillage2 {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[][] num = new int[100000][2];
    static List<Integer> selectNodeList = new LinkedList<>();
    static List<Edge> edgeList = new LinkedList<>();
    public static void main(String[] args) {
        n = in.nextInt();
        int maxIndex = -1, max = 0;
        for(int i=1;i<=n;i++) {
            num[i][0] = in.nextInt();
            if(max<num[i][0]) {
                max = num[i][0]; maxIndex = i;
            }
        }
        for(int i=0;i<n-1;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            edgeList.add(new Edge(a, b));
        }
        while (true) {
            num[maxIndex][1] = 1;
            selectNodeList.add(maxIndex);
            for(int i=0;i<edgeList.size();i++) {
                Edge curr = edgeList.get(i);
                if(curr.a==maxIndex) {
                    num[curr.b][1] = 1;
                }
                else if(curr.b==maxIndex) {
                    num[curr.a][1] = 1;
                }
            }
            max = 0;
            boolean all = false;
            for(int i=1;i<=n;i++) {
                if(max<num[i][0] && i!=maxIndex) {
                    if(num[i][1]!=1) {
                        max = num[i][0];
                        maxIndex = i;
                        all = true;
                    }
                }
            }
//            System.out.println("maxIndex : "+maxIndex);
            if(!all) {
                break;
            }
        }
        int res = 0;
        for(int i=0;i<selectNodeList.size();i++) {
            res += num[selectNodeList.get(i)][0];
        }
        System.out.println(res);

    }
}
