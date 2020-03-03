package Simulation;

import java.util.Scanner;

public class BJ_3985_RollCake {
    static int l, n;
    static int[] cake;
    static int[][] pk;
    static int[] exp = new int[2];
//    exp[0]=max expectation    exp[1]=audience number
    static int[] actual = new int[2];
    //    actual[0]=actual max    actual[1]=audience number
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        l = in.nextInt(); n = in.nextInt();
        cake = new int[1000];
        pk = new int[1000][2];
//        java 런타임 에러 : 배열을 크기만큼 동적 할당하는 것이 아니라,
//        최대 max값 만큼 정적으로 할당하면 해결 가능.
        for(int i=0;i<n;i++) {
            pk[i][0]=in.nextInt(); // p
            pk[i][1]=in.nextInt(); // k

        }
        for(int i=0;i<n;i++) {
            if((pk[i][1]- pk[i][0]+1)>exp[0]) {
                exp[0] = pk[i][1]- pk[i][0]+1;
                exp[1] = i;
            }
            int max = 0;
            for(int j = pk[i][0]; j<= pk[i][1]; j++) {
                if(cake[j]==0) {
                    cake[j] = i+1;
                    max++;
                }
            }
            if(max>actual[0]) {
                actual[0] = max;
                actual[1] = i;
            }

        }
        System.out.println(exp[1]+1);
        System.out.println(actual[1]+1);
    }
}
