package BruteForce;

import java.util.Scanner;

public class BJ_1065_Hansu {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int res = 0;
    public static void main(String[] args) {
        n = in.nextInt();
        if(n<100) {
            res = n;
        }
        else {
//            100이상 1000이하
            res = 99;
            if(n==1000) n-=1;
            for(int i=100;i<=n;i++) {
                String c = i+"";
                int diff = c.charAt(0)-c.charAt(1);
                if(diff==c.charAt(1)-c.charAt(2)) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
