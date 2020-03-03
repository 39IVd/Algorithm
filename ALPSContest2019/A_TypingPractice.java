package ALPSContest2019;

import java.util.Scanner;

public class A_TypingPractice {
    static String[] c;
    static int l = 0, r = 0, center = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        c = in.nextLine().split("");
        for(int i=0;i<c.length;i++) {
            if(c[i].equals(" ")) {
                if(l<=r) {
                    l++;
                }
                center++;
            }
            else {
                char ch = c[i].charAt(0);
                if(ch>=65 && ch<=90) { // 대문자
                    center++;
                    if((ch>=72&&ch<=80)||ch==85) {
                        //right
                        r++;
                    }
                    else { // left
                        l++;
                    }
                }
                else { // 소문자
                    if((ch>=104&&ch<=112)||ch==117) {
                        //right
                        r++;
                    }
                    else { // left
                        l++;
                    }
                }
            }
        }
//        if(r+1-l>=center) {
//            l += center;
//        }
//        else {
//            l +=
//        }
        while(center>0) {
            if(l<=r) {
                l++; center--;
            }
        }
        System.out.println(l+" "+r);

    }
}
