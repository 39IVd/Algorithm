package Alg2019_2;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1495_Guitarist2 {
    static int n, s, m;
    static int[] V;
    static ArrayList<Integer>[] list;
    static int max = -1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); s = in.nextInt(); m = in.nextInt();
        V = new int[n+1];
        list = new ArrayList[n+1];
        V[0] = s;
        for(int i=1;i<=n;i++) {
            V[i] = in.nextInt();
        }
        for(int i=0;i<=n;i++) {
            list[i] = new ArrayList<>();
        }
        list[0].add(s);

        for(int i=1;i<=n;i++) {
            for(int j=0;j<list[i-1].size();j++) {
                int tmp = list[i-1].get(j)+V[i];
                if (tmp >= 0 && tmp <= m) {
                    if(i==n) {
                        max = Math.max(max, tmp);
                    }
                    list[i].add(tmp);
                }
                tmp = list[i-1].get(j)-V[i];
                if (tmp >= 0 && tmp <= m) {
                    if(i==n) {
                        max = Math.max(max, tmp);
                    }
                    list[i].add(tmp);
                }
            }
        }
//        for(int i=0;i<=n;i++) {
//            System.out.print("list "+i+" : ");
//            for(int j=0;j<list[i].size();j++ ){
//                System.out.print(list[i].get(j)+" ");
//            }
//            System.out.println();
//        }
//        for(int i=0;i<list[n].size();i++) {
//            max = Math.max(max, list[n].get(i));
//        }
        System.out.println(max);
    }
}
