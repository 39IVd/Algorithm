package Greedy;

import java.util.Scanner;

public class BJ_5585_Changes {
    static Scanner in = new Scanner(System.in);
    static int change;
    static int m  = 0, res = 0;
    static int all = 1000;
    public static void main(String[] args) {
        change = all - in.nextInt();
        res = change;
//        620
        int divide = 0;
        while(res>0) {
            if(res/500>0) {
                divide = 500;
            }
            else if(res/100>0) {
                divide = 100;
            }
            else if(res/50>0) {
                divide = 50;
            }
            else if(res/10>0) {
                divide = 10;
            }
            else if(res/5>0) {
                divide = 5;
            }
            else if(res/1>0) {
                divide = 1;
            }
            m += res/divide;
            res = res%divide;
        }
        System.out.println(m);

    }
}
