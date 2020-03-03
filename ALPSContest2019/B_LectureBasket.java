package ALPSContest2019;

import java.util.ArrayList;
import java.util.Scanner;

public class B_LectureBasket {
    static int n, m;
    static ArrayList[][] stu;
    static int[] lec, cp_lec;
    static ArrayList[] s_clear;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        stu = new ArrayList[n+1][2]; lec = new int[m+1];
        cp_lec = new int[m+1]; s_clear = new ArrayList[n+1];
        for(int i=1;i<=m;i++) {
            lec[i] = in.nextInt(); cp_lec[i] = lec[i];
        }
        for(int j=0;j<2;j++) {
            for(int i=1;i<=n;i++) {
                stu[i][j] = new ArrayList<Integer>();
                s_clear[i] = new ArrayList();
                while(true) {
                    int num = in.nextInt();
                    if(num==-1) {
                        break;
                    }
                    stu[i][j].add(num);
                }
            }
        }
//        for(int i=0;i<2;i++) {
//            System.out.println((i+1)+"차");
//            for(int j=1;j<=n;j++) {
//                System.out.print("stu "+j+" : ");
//                for(int k=0;k<stu[j][i].size();k++) {
//                    System.out.print(stu[j][i].get(k)+" ");
//                }
//                System.out.println();
//            }
//        }
        for(int p=0;p<2;p++) {
            for(int i=1;i<=n;i++) {
                for(int k=0;k<stu[i][p].size();k++) {
                    int l = (int)stu[i][p].get(k);
                    cp_lec[l]--;
                }
            }
            for(int i=1;i<=m;i++) {
                if(cp_lec[i]>-1) {
                    lec[i] = cp_lec[i];
                    for(int j=1;j<=n;j++) {
                        if(stu[j][p].contains(i)) {
                            s_clear[j].add(i);
                        }
                    }
                }
            }
        }
        for(int i=1;i<=n;i++) {
            if(s_clear[i].isEmpty()) {
                System.out.println("망했어요");
                break;
            }
            for(int k=0;k<s_clear[i].size();k++) {
                System.out.print(s_clear[i].get(k)+" ");
            }
            System.out.println();
        }
    }
}
