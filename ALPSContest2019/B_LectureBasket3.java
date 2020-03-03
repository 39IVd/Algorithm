package ALPSContest2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_LectureBasket3 {
    static int n, m;
    static int[][] L;
    static int[][] reg;
    static ArrayList<Integer>[] clear;
    static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken()); m = stoi(st.nextToken());
        L = new int[m+1][2];
        reg = new int[n][m+1];
        clear = new ArrayList[n];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++) {
            L[i][0] = stoi(st.nextToken());
        }
        // 1차
        for(int i=0;i<n;i++) {
            clear[i] = new ArrayList();
            st = new StringTokenizer(br.readLine());
            while(true) {
                int val = stoi(st.nextToken());
                if (val == -1) {
                    break;
                }
                reg[i][val]=1;
                L[val][0]--;
            }
        }
        for(int k=1;k<=m;k++) {
            for(int i=0;i<n;i++) {
                if(reg[i][k]==1&&L[k][0]>-1) {
                    clear[i].add(k);
                }
                reg[i][k] = 0;
            }
            L[k][1] = L[k][0];
        }

        // 2차
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            while(true) {
                int val = stoi(st.nextToken());
                if (val == -1) {
                    break;
                }
                reg[i][val]=1;
                L[val][1]--;
            }
        }
        for(int i=0;i<n;i++) {
            for(int k=1;k<=m;k++) {
                if(reg[i][k]==1&&L[k][1]>-1) {
                    clear[i].add(k);
                }
            }
        }
        String res = "";
        for(int i=0;i<n;i++) {
            if(clear[i].isEmpty()) {
                res+="망했어요\n";
            }
            else {
                for(int k : clear[i]) {
                    res+=k+" ";
                }
                res+="\n";
            }
        }
        System.out.println(res);
    }
}
