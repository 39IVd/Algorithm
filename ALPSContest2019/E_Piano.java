package ALPSContest2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E_Piano {
    static int n;
    static int[] score;
    static int ls, rs;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ls = normalize(st.nextToken());
        rs = normalize(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        score = new int[n+1];
        dp = new int[n+1][2];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            score[i] = normalize(st.nextToken());
            System.out.print(score[i]+" ");
        }
        System.out.println(ls+", "+rs);
    }
    public static int normalize(String s) {
        int res = 0;
        char alpha = s.charAt(0);
        if(alpha>=67&&alpha<=69) { // cde
            res = (alpha-67)*2;
        }
        else if (alpha==70||alpha==71) { // fg
            res = (alpha-67)*2-1;
        }
        else if(alpha==65) { // a
            res += 10;
        }
        else if(alpha==66) { // b
            res += 12;
        }
//        switch (alpha) {
//            case 'A':
//                res += 10;
//                break;
//            case 'B':
//                res += 12;
//                break;
//            default:
//                res = (alpha-67)*2;
//        }
        res += (12*Integer.parseInt(s.charAt(1)+""));

        if(s.length()==3) { // #
            res = res+1;
        }
        return res;
    }
}
