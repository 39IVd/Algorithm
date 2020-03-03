package Simulation;

import java.util.Scanner;

public class BJ_13458_ExamSupervisor {
    static long n;
    static long[] room = new long[10000000];
    static long b, c;
    static long total;
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        n = in.nextLong();
        for(int i=0;i<n;i++) {
            room[i] = in.nextLong();
        }
        total = n;
        b = in.nextLong(); c = in.nextLong();
        for(int i=0;i<n;i++) {
            long res = room[i];
            if(res<=b) {
                continue;
            }
            res -= b;
            total += Math.ceil(res/(c*1.0));
        }
        System.out.println(total);
    }
}
