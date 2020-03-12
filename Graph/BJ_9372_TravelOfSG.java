package Graph;

import java.util.Scanner;

//    그래프에서 가장 적은 edge로 n개의 노드를 방문하는, edge의 개수 구하기.
//    항상 연결 그래프이다.
//    연결 그래프에서, 모든 node n개를 방문하는 최소 edge의 개수 : n-1.
//    따라서 edge의 종류는 고려할 필요가 없다.
public class BJ_9372_TravelOfSG {
    static int t;
    static int[] n = new int[100], m = new int[100];
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        t = in.nextInt();
        for(int i=0;i<t;i++) {
            n[i] = in.nextInt(); m[i] = in.nextInt();
            in.nextLine();
            for(int j=0;j<m[i];j++) {
                in.nextLine();
            }
        }
        for(int i=0;i<t;i++) {
            System.out.println(n[i]-1);
        }
    }
}
